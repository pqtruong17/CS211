public class ShapeAnalyzer {
  private static final Object EMPTY_PROPERTY = new Object();
    public static Machine analyze(String json) {
      String[][] parse_entry = parseEntries(json);
      //Extract kind from parse_entry
      String kind = reifyKind(parse_entry);
      /*Gathers the properties from entries, inferring objects as needed. 
       It does not include kind, and it may be not the first property.*/
      Object[] properties = reifyProperties(parse_entry);
      // The above statement are arrays full of PartState object
      boolean humanConstrained = SystemWhole.isHumanoid(properties);
      // Use kind, properties, and humanConstrained to create Machince
      return new Machine(kind,properties,humanConstrained);
    }

    public static String[][] parseEntries(String flatJson) {
      String trim_space = flatJson.replaceAll(" ", ""); // Cut the all space open and replace it with empty space
      String cut_bracket = trim_space.substring(1,trim_space.length() - 1);
      String[] part_states = cut_bracket.split(",");
      String[][] entries = new String[part_states.length][1];
      for(int i = 0; i < part_states.length; i++){
        // There's probally way better way to this but its just work and i'll settle with that.
        // Regex??sounds usefull. Lets not learn it.
        String[] states = part_states[i].split(":");
        //Expected string value is (EX: "\"kind\"")
        String unEdited_property = states[0]; 
        // Begin Index is inclusive and so start 1. End index is exclusive so start at length()-1 when ultilize substring
        String property = unEdited_property.substring(1, unEdited_property.length()-1); 
        //Expected string property is (EX: "Kind") AFTER
        //Expected string value is (EX: "\"Humanoid\"") BEFORE
        String unEdited_value = states[1];
        // Begin Index is inclusive and so start 1. End index is exclusive so start at length()-1 when ultilize substring
        String value = unEdited_value.substring(1,unEdited_value.length()-1); 
        //Expected string value is (EX: "Humanoid") AFTER
        entries[i] = new String[]{property,value};
      }
      return entries; 
    }
    
    public static String reifyKind(String[][] entries) {
      for(int i = 0; i < entries.length; i++){
        String property = entries[i][0];
        Object pass_value = inferObject(entries[i][1]);
        if(property.toLowerCase().equals("kind")){
          return pass_value.toString(); //Extracts the kind from parsed entries
        }
      }
      return "null"; 
    }
    
    public static Object[] reifyProperties(String[][] entries) {
      int index = 0;
      // Initialize PartState Array if 
      boolean is_null = reifyKind(entries).equals("null");
      boolean is_empty_string = reifyKind(entries).equals("EMPTY_STRING");
      PartState[] inputObj = ((is_null) || (is_empty_string)) ? new PartState[entries.length]:new PartState[entries.length-1];
      for(int i = 0; i < entries.length; i++){
        String property = entries[i][0];
        // kind may be not the first property.
        if(property.toLowerCase().equals("kind")){
          continue; 
        }
        String value = entries[i][1];
        // Initiate object and use reifyProperties as instructed
        Object infer_object = inferObject(value);
        Object object_value = infer_object.equals(EMPTY_PROPERTY) ? EMPTY_PROPERTY:infer_object;
        //Edit index with new PartState object and incredment index by 1. 
        inputObj[index++] = new PartState(property,object_value);
      }
      return inputObj;
    }

    public static boolean isDigit(char c) {
      //https://www.javatpoint.com/java-ascii-table
      // '/' begins at 47 and ':' ends at 58 which leaves the rest in-between as char of numbers, mainly 0 through 9. 
        return ('/' < c) && (c < ':');
    }

    public static boolean hasNonNumbers(String value) {
      // Need to clean up expression since its hard to read 
      int dot_count = 0;
      char[] c_arr = value.toCharArray();
      for(int i = 0; i < c_arr.length; i++){
        boolean is_dot = (c_arr[i] == '.'); 
        boolean is_digit = isDigit(c_arr[i]); 
        /* We must have is_digit and is_dot operate independently of each therefore the counter 
         * and two conditions below with the expected value as dot_counter
         * String value must not be a digit under the exception of '.' in order to incredment dot_count, 
         * otherwise keep the same value.*/
        int dot_counter = ((is_dot) && (!is_digit)) ? dot_count++:dot_count;
        // First condition is the string value if is '.' must only appear once to be true and otherwise false.
        boolean condition_1 = (dot_count >= 2) ? true:false;
        // Secound is the string value must not be a digit and '.' to in order to be true and otherwise false.
        boolean condition_2 = ((!is_dot) && (!is_digit)) ? true:false;
        if((condition_1) || (condition_2)){
          return true;
        }
      }
      return false;
    }
    public static Object inferObject(String value) {
      if (value.equals("null") || (value.isEmpty())){ // First, it check if the string is null or empty, then returns EMPTY_PROPERTY
        return EMPTY_PROPERTY;
      } else if (hasNonNumbers(value)){ // Otherwise checks for hasNonNumbers
        return value;
      } else { // If there is a "." in the string to determine parsing as Double or Integer
        return (value.indexOf(".") == -1) ? Integer.parseInt(value): Double.parseDouble(value);
      }
    }
}