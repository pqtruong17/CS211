/**
* A Vacuum class which extends and inherited all of Robot functionality.
* @ Phuc(Kevin) Truong
* @ Version 1.0
*/
public class Vacuum extends Robot{
  /**
  * A public Vacuum constructor which utilize the inherited Robot constructor with preset capabilities as 
  * cannot fly, not teleoperated, is autonomous, and can clean.
  * @param serialNumber identification number
  */ 
  public Vacuum(int serialNumber){
     super(serialNumber, false, true, false);
  }
  /**
  * A public getter called canClean
  * @return the preset boolean variable true.
  */ 
  public boolean canClean(){
    return true;
  }
  /**
  * A method which override getCapabilities
  * @return String getCapabilties inherited Robot with additional space and canClean at the end.
  */ 
  @Override
  public String getCapabilities(){
    return String.format("%s canCLean", super.getCapabilities());
  }
  
  /**
  * A method which override canFly
  * @return preset boolean as false.
  */ 
  @Override
  public boolean canFly(){
    return false;
  } 
  
  /**
  * A method which override isAutonomous
  * @return preset boolean as true.
  */ 
  @Override
  public boolean isAutonomous(){
    return true;
  }
  
  /**
  * A method which override isTeleoperated
  * @return preset boolean as false.
  */
  @Override
  public boolean isTeleoperated(){
    return false;
  }
}
