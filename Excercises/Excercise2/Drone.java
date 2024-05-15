/**
* A Drone class which extends and inherited all of Robot functionality.
* @ Phuc(Kevin) Truong
* @ Version 1.0
*/
public class Drone extends Robot{
  /**
  * A public Drone constructor which utilize the inherited Robot constructor with preset capabilities as 
  * can fly, not teleoperated and is autonomous.
  * @param serialNumber identification number
  */ 
  public Drone(int serialNumber){
    super(serialNumber, true, false, true);
  }
 
  /**
  * A method which override canFly in Robot.
  * @return preset boolean as true.
  */  
  @Override
  public boolean canFly(){
    return true;
  } 
  
  /**
  * A method which override isAutonomous in Robot.
  * @return preset boolean as false.
  */ 
  @Override
  public boolean isAutonomous(){
    return false;
  }
  
  /**
  * A method which override isTeleoperated in Robot.
  * @return preset boolean as false.
  */  
  @Override
  public boolean isTeleoperated(){
    return false;
  }
}