/**
* A HAL9000 is a subclass which extends and inherited all of MovieRobot functionality.
* @ Phuc(Kevin) Truong
* @ Version 1.0
*/
public class HAL9000 extends MovieRobot{
  /**
  * A public HAL9000 constructor which utilize the inherited overload MovieRobot constructor 
  * with preset capability as can fly.
  * @param serialNumber identification number
  * @param autonomous indicate whether or not the robot can act on its own without a human operator.
  * @param teleoperated indicate whether or not a human can operate the robot manually.
  */
  public HAL9000(int serialNumber, boolean autonomous, boolean teleoperated){
    super(serialNumber, true, autonomous, teleoperated);
  } 
  
  /**
  * A method which override canSpeak in MovieRobot.
 `* @return the preset boolean variable true
  */   
  @Override
  public boolean canSpeak(){
    return true;
  }
  
  /**
  * A method which override canFly in Robot.
 `* @return the preset boolean variable true.
  */ 
 @Override
  public boolean canFly(){
    return true;
  }
 
  /**
  * A method which override getCatchPhrase in MovieRobot
 `* @return String "I can't let you do that Dave."
  */
 @Override
   public String getCatchPhrase(){
    return "I can't let you do that Dave.";
  }
}