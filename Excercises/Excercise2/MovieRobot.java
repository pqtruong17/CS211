/**
* An abstract MovieRobot class which extends and inherited all of Robot functionality.
* @ Phuc(Kevin) Truong
* @ Version 1.0
*/
public abstract class MovieRobot extends Robot{
  /**
  * A private String catchphrase that is either null or String.
  */
  private static String catchphrase;  
  
  /**
  * An overload public MovieRobot constructor which chain the first four arguments and sets catchphrase to null.
  * @param serialNumber identification number
  * @param flies, autonomous, and teleoperated as boolean capabilities.
  * @param catchphrase preset to null
  */
  public MovieRobot(int serialNumber, boolean flies, boolean autonomous, boolean teleoperated){
    this(serialNumber, flies, autonomous, teleoperated, catchphrase);
  }
  
  /**
  * A public MovieRobot constructor which utilize the inherited Robot constructor in additional parameter of catchphrase.
  * @param serialNumber identification number
  * @param flies, autonomous, and teleoperated as boolean capabilities.
  * @param catchphrase which let MovieRobot give a speech
  */ 
  public MovieRobot(int serialNumber, boolean flies, boolean autonomous, boolean teleoperated, String catchphrase){
    super(serialNumber, flies, autonomous, teleoperated);
    setCatchPhrase(catchphrase);
  }
  
  /**
  * A public setter that take the String catchphrase the set it as the MovieRobot catchphrase
  * @param catchphrase which let MovieRobot gives speech
  */ 
  public void setCatchPhrase(String catchphrase){
        this.catchphrase = catchphrase;
  }
  /**
  * A public getter called getCatchPhrase
  * @return the String catchphrase.
  */ 
  public String getCatchPhrase(){
    return catchphrase;
  }
  
  /**
  * An abstract method called canSpeak.
  * @return a boolean dependent on concrete sub-class can speak capabilities
  */ 
  public abstract boolean canSpeak();
  
  /**
  * A public method which override getCapabilities in Robot.
  * @return String in the same format as the parent class Robot, but with the additional canSpeak capability at the end
  */ 
  @Override
  public String getCapabilities(){
    String hasSpace =  (super.getCapabilities().isEmpty()) ? "":" ";
    return (canSpeak()) ? String.format("%s%scanSpeak" ,super.getCapabilities(),hasSpace): String.format("%s" ,super.getCapabilities());
  }
  
  /**
  * A public method which override toString in Robot.
  * @return String in the same format as the parent class Robot, and 
  * if the robot can speak appends a space followed by the catchphrase surrounded by quotation marks.
  */ 
  @Override
   public String toString(){
    return (canSpeak()) ? String.format ("%s \"%s\"" , super.toString(), this.getCatchPhrase()):String.format("%s" , super.toString());
   }
}