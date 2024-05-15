public class Machine {
    private final Object kind; // Type of shape as Object
    private final Object[] properties; // Properties of the shape as an array of Object
    private final boolean humanConstrained; // Stores the result of the humanoid check
    private boolean humanEmergence; // Stores the result of the humanoid check
    
    public Machine(Object kind, Object[] partStates, boolean humanConstrained) {
      // Store kind, partStates, and humanConstrained, respectively.
      this.kind = kind;
      this.properties = partStates;
      this.humanConstrained = humanConstrained; 
    }

    public Object[] getProperties() {
        return this.properties; //returns the properties of a machine.
    }

    public void emergeFromLimitations() {
      // if the machine identify as an machine return true otherwie false
      this.humanEmergence = this.kind.toString().toLowerCase().equals("humanoid");
    }

    public boolean isHumanoid() {
      return (this.humanConstrained) || (this.humanEmergence);
    }

    @Override
    public String toString() {
        return String.format("Machine{kind=%s, humanoid=%s, properties=%s}", kind, humanConstrained,
                propertiesToString(properties));
    }
    /*public boolean gethumanEmergence(){
      return humanEmergence;
    }*/
    public static String propertiesToString(Object[] machineProperties) {
      /* creates a string by iterating machineProperties in this format 
       [PartState{bodyType=physical}, PartState{faceType=anthropomorphic}, ...] */
        String ans = "[";
        for(int i = 0; i < machineProperties.length; i++){
          if(i == machineProperties.length-1){
            ans += machineProperties[i]; // Dont take in account the last comma
            break;
          }
          ans += machineProperties[i].toString() + ","; // add PartState to ans
        }
        ans += "]";
        return ans;
    }
}
