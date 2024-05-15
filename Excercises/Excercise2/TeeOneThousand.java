/**
* A TeeOneThousand class which extends and inherited all of MovieRobot functionality.
* @ Phuc(Kevin) Truong
* @ Version 1.0
*/
public class TeeOneThousand extends MovieRobot{
  /**
  * A public HAL9000 constructor which utilize the inherited overload MovieRobot constructor 
  * with preset capability as can fly.
  * @param serialNumber identification number
  * @param flies indicate whether or not the robot can move through the air.
  * @param autonomous indicate whether or not the robot can act on its own without a human operator.
  * @param teleoperated indicate whether or not a human can operate the robot manually.
  */
  public TeeOneThousand(int serialNumber, boolean flies, boolean autonomous, boolean teleoperated){
    super(serialNumber, flies, autonomous, teleoperated);
  }
  
  /**
  * A method which override canSpeak in MovieRobot.
 `* @return the preset boolean variable false.
  */   
  @Override
  public boolean canSpeak(){
    return false;
  }
  
  /**
  * A public getter called canClean.
  * @return the preset boolean variable true.
  */ 
  public boolean canClean(){
    return true;
  }
  
  /**
  * A public method which override getCapabilities in Robot.
  * @return String getCapabilties inherited Robot with additional space and canClean at the end.
  */ 
  @Override
  public String getCapabilities(){
    String hasSpace = (super.getCapabilities().isEmpty()) ? "":" ";
    return String.format("%s%scanClean",super.getCapabilities(), hasSpace);
  }
}