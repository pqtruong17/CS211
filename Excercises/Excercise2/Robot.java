/**
* A general class that identifies some common capabilities that different robots might have, 
* with the possibility that new capabilities might be added in the future through subclasses.
* @ Phuc(Kevin) Truong
* @ Version 1.0
*/
public class Robot {
  /**
  * A private serial number which uniquely identifies the robot. 
  */
  private static int serialNumber;  
  
  /**
  * A private boolean variable indicates whether or not the robot can move through the air.
  */
  private static boolean flies;
    
  /**
  * A private boolean variable indicates whether or not the robot can act on its own without a human operator.
  */ 
  private static boolean autonomous; 
  
  /**
  * A private boolean variable indicates whether or not a human can operate the robot manually.
  */ 
  private static boolean teleoperated;
  
  /**
  * A public Robot constructor initializing serialNumber and common capabilites of Robot.
  * @param serialNumber identification number
  * @param flies, autonomous, and teleoperated as boolean capabilities
  */
  public Robot(int serialNumber, boolean flies, boolean autonomous, boolean teleoperated){
    this.serialNumber = serialNumber;
    setCapabilities(flies, autonomous, teleoperated);
  }
  
  /**
  * A public setter that takes the boolean array capabilities as parameter then
  * set them to flies, autonomous, and teleoperated by chronologically acording to capabilities.
  * @param capabilities represent capabilities boolean array [flies, autonomous, teleoperated]
  */ 
  public void setCapabilities(boolean flies, boolean autonomous, boolean teleoperated){
      this.flies = flies;
      this.autonomous = autonomous;
      this.teleoperated = teleoperated;
  }
  /**
  * A public getter called getSerialNumber for the serialNumber,
  * (it may even make sense to declare the method and the corresponding field final).
  */ 
  public final int getSerialNumber(){
    return serialNumber;
  }
  
  /**
  * A public getter called canFly
  * @return the boolean flies.
  */ 
  public boolean canFly(){
    return flies;
  }
    
  /**
  * A public getter called isAutonomous
  * @return the boolean autonomous.
  */ 
  public boolean isAutonomous(){
    return autonomous;
  }
  
  /**
  * A public getter called isTeleoperated
  * @return the boolean teleoperated.
  */ 
  public boolean isTeleoperated(){
    return teleoperated;
  }
  
  /**
  * A public getCapabilities method that takes no parameters. 
  * @see java.lang.String#format(String,object,...)
  * @return String containing each of the capabilities of the robot separated by spaces 
  */
  public String getCapabilities(){
    String temp1 = (canFly()) ? " canFly":"";
    // temp1 derive the String " canFly" String if true, otherwise ""
    String temp2 = (isAutonomous()) ? " isAutonomous":"";
    // temp2 derive the String " isAutonomous" String if true, otherwise "", and
    String temp3 = (isTeleoperated()) ? " isTeleoperated":"";
    // temp3 derive the String " isTeleoperated" String if true, othewise "" are all conditional expression as String.
    String str = String.format("%s%s%s", temp1,temp2,temp3);
    // The last conditional expression str chained all three together using String format method. 
    return (!str.isEmpty()) ? str.substring(1,str.length()):"";
  }
  
  /**
  * A public toString method that takes no parameters and
  * replace with actual serial number and list of capabilities, respectively.
  * @return "ID: <serialNumber>, Capabilities: <list of capabilities>." 
  */
  public String toString() {
    String hasSpace =  (getCapabilities().isEmpty()) ? "":" ";
    return String.format("ID: %d, Capabilities:%s%s", serialNumber, hasSpace, getCapabilities());
  }
}