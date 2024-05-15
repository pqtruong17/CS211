public class Zoo{
  public static void main(String[] args){
    Animal an = new Animal(true, "Bear","Bearum");
    an.printInfo();
    an.printSleepInfo();
    an.printRoam();
    an.printFeed();
    System.out.println("-----------------------");
    Monkey mon = new Monkey(true,"Monkey","Mankey");
    mon.printInfo();
    mon.printSleepInfo();
    mon.printRoam();
    mon.printFeed();
    mon.printClimb();
    System.out.println("-----------------------");
    Owl owl = new Owl(true, "Owl", "Pigedot");
    owl.printInfo();
    owl.printSleepInfo();
    owl.printRoam();
    System.out.println("-----------------------");
    owl.printFeed();
    System.out.println("-----------------------");
  }
}