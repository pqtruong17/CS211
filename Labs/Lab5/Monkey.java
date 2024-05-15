public class Monkey extends Animal{
  public Monkey( Boolean nocturnal, String type,String name){
    super(nocturnal, type, name);
  }
  public void printFeed(){
    System.out.printf("You give this monkey some bannanas.\n");
  }
  public void printClimb(){
    System.out.printf("This monkey climbs a tree.\n");
  }
}