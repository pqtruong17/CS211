public class Owl extends Animal{
  public Owl(Boolean nocturnal, String type,String name){
    super(nocturnal,type,name);
  }
  public void printFeed(){
    System.out.printf("You give this owl some mice.\n");
  }
  
  @Override
  public void printRoam(){
    System.out.printf("This owl flies around.\n");
  }
}