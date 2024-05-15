public class Animal{
  private static String name, type;
  private boolean nocturnal;
  public Animal(Boolean nocturnal, String type, String name){
    this.name = name;
    this.type = type;
    this.nocturnal = nocturnal; 
  }
  public void printInfo(){  
    System.out.printf("%s is a(n) %s.\n",name, type);
  }
  public void printSleepInfo(){
    String temp = (nocturnal) ? "sleeps during day":"sleeps during night";
    System.out.printf("%s %s.\n", type, temp);
  }
  public void printRoam(){
    System.out.printf("%s walks around.\n", name);
  }
  public void printFeed(){
    System.out.printf("Chomp Chomp.\n");
  }
  /*public String getName(){
    return name;
  }
  public String getType(){
    return type;
  }
  public boolean isNocturnal(){
    return nocturnal;
  }*/
}