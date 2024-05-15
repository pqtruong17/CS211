//import java.util.Arrays;
public class SystemWhole {
    public static String[] emergences; // To store JSON strings representing emergences
    public static Machine[] parts; // To store Machine objects directly as an array
    public static void main(String[] args) {
  
        //Sample JSON strings representing different "emergences"
       String[] emergences = {
                "{\"kind\": \"Humanoid\", \"bodyType\": \"physical\", \"faceType\": \"anthropomorphic\", \"reverie\": \"mechatypical\"}",
                "{\"kind\": \"Humanoid\", \"bodyType\": \"physical\", \"faceType\": \"anthropomorphic\", \"reverie\": \"biotypical\"}",
                "{\"kind\": \"Humanoid\", \"bodyType\": \"physical\", \"faceType\": \"anthropomorphic\", \"reverie\": \"biotypical\"}",
                "{\"kind\": \"Robot\", \"material\": \"metal\", \"function\": \"industrial\"}",
                "{\"kind\": \"Humanoid\", \"bodyType\": \"physical\", \"faceType\": \"anthropomorphic\"}",
                "{\"bodyType\": \"__32e432\", \"faceType\": \"32.0\", \"material\": \"2.002....\", \"function\": \"industrial\"}",
                "{\"bodyType\": \"\", \"faceType\": \"null\"}",
                "{\"kind\": \"\", \"faceType\": \"32.0\"}",
         
       };
        //Parse the emergences and set them to the SystemWhole state
        emergencesFromPhenomena(emergences);
        // Analyze the shapes based on the set emergences
        reifyFrameOfReference();
        //System.out.println("Prelude of the Rise of the Machines: " + Arrays.deepToString(parts));
        //parts[0].emergeFromLimitations();
        // Track humanoid machines and identify singularities
        Machine[] singularities = trackSingularityMachines();
        System.out.println();
        //System.out.println("Singularities: " + Arrays.deepToString(singularities)); 
      
    }

   //Visibility modifiers: public vs private
    public static void emergencesFromPhenomena(String[] emergences) {
        //Class and Object State: static vs this
        SystemWhole.emergences = emergences;
    }

  public static void reifyFrameOfReference() {
        SystemWhole.parts= new Machine[emergences.length];
        int i = 0; // not elegant =(
        for (String emergence:emergences){
            SystemWhole.parts[i++] = ShapeAnalyzer.analyze(emergence); 
        }
        
    }

    public static boolean isHumanoid(Object[] machineProperties) {
      int count = 0;
      PartState[] humanoid_conditions = new PartState[3];
      //Initialize all 3 humanoid condition as object
      humanoid_conditions[0] = new PartState("bodyType", "physical");
      humanoid_conditions[1] = new PartState("faceType", "anthropomorphic");
      humanoid_conditions[2] = new PartState("reverie", "biotypical");
      for(int i = 0; i < machineProperties.length; i++){
        // Check if input object is match with the three humanoid conditions
        boolean cond_1 = machineProperties[i].toString().equals(humanoid_conditions[0].toString());
        boolean cond_2 = machineProperties[i].toString().equals(humanoid_conditions[1].toString());
        boolean cond_3 = machineProperties[i].toString().equals(humanoid_conditions[2].toString());
        // if any of these three humanoid coditions are met return add 1 to coutn otherwise stay the same value
        int temp_check = ((cond_1) || (cond_2) || (cond_3)) ? count++:count;
      }
      //If all three condition are met, return true and otherwise return false
      return (count == 3);
    }

    // SystemWhole's logic to determine if a Machine is humanoid and count them
    public static int identitySingularityMachines() {
      int count = 0;
      Machine[] input = SystemWhole.parts; 
      for(int i = 0; i < input.length; i++){
        // The component parts that belongs to the Machine arrray is humanoid is true 
        // then incredement count other wise count stay the same 
        input[i].emergeFromLimitations();
        int temp_count = (input[i].isHumanoid()) ? count++:count;
      }
      return count;
    }

    public static Machine[] trackSingularityMachines() {
      int is_humanoid_count = SystemWhole.identitySingularityMachines();
      Machine[] trackMachine = new Machine[is_humanoid_count];
      // Initialize an oversize Machine array that will collect Machine parts. 
      int index = 0;
      for(int i = 0; i < parts.length; i++){
        // Use the Machine class getProperties to set a new of object which is the machine_properties
        Object[] machine_properties = parts[i].getProperties();
        // Check if the following machine properties is hunmanoid
        /*if (!parts[i].gethumanEmergence()){
          continue;
        } else */if (parts[i].isHumanoid()){
          // Adds humanoid parts to track_humanoid
          trackMachine[index++] = parts[i];
        }
      }
      return trackMachine;
    }
}
