/**
* A Replicant class which extends and inherited all of MovieRobot functionality.
* @ Phuc(Kevin) Truong
* @ Version 1.0
*/
public class Replicant extends MovieRobot{
  private static boolean fight;
  /**
  * A public HAL9000 constructor which utilize the inherited overload MovieRobot constructor 
  * with preset capability as cannot fly.
  * @param serialNumber identification number
  * @param autonomous indicate whether or not the robot can act on its own without a human operator.
  * @param teleoperated indicate whether or not a human can operate the robot manually.
  */
  public Replicant(int serialNumber, boolean autonomous, boolean teleoperated, boolean fight){
    super(serialNumber, false, autonomous, teleoperated);
    this.fight = fight;
  }
  
  /**
  * A method which override canSpeak in MovieRobot.
 `* @return the preset boolean variable true.
  */   
  @Override
  public boolean canSpeak(){
    return true;
  }
  
  /**
  * A public getter called canFight.
  * @return the preset boolean variable true.
  */ 
  public boolean canFight(){
    return this.fight;
  }
  
 /**
  * A method which override getCatchPhrase in MovieRobot.
 `* @return String "like tears in rain..."
  */ 
  @Override
  public String getCatchPhrase(){
    return  "like tears in rain...";
  }
    
 /**
  * A method which override getCapabilities in MovieRobot. 
  * @return String getCapabilities inherited from MovieRobot with additional space and canFight at the end.
  */ 
  @Override
  public String getCapabilities(){
    return (canFight()) ? String.format("%s canFight", super.getCapabilities()):String.format("%s",super.getCapabilities());
  }
}