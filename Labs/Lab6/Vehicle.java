enum VehicleType{ 
  CAR, MOTORCYCLE, TRUCK, BICYCLE
}
 abstract class Vehicle{
  protected String model;   
  protected int year;
  protected VehicleType type;
    public Vehicle(String model, int year, VehicleType type){
      setModel(model);
      setYear(year);
      setType(type);
  }
    public void setModel(String model){
      this.model = model;
    }
    public void setYear(int year){
      this.year = year;
    }
    public void setType(VehicleType type){
      this.type = type;
    }
  abstract void startEngine();
  abstract void stopEngine();
  public static void main(String[] args){
    Car c1 = new Car("camry", 1999);
    c1.startEngine();
    c1.stopEngine();
    System.out.println("----------------");
    Motorcycle m1 = new Motorcycle("Harly Davidson", 2000);
    m1.startEngine();
    m1.stopEngine();
    System.out.println("----------------");
    Truck t1 = new Truck("Ford", 2010);
    t1.startEngine();
    t1.stopEngine();
    System.out.println("----------------");
    Bicycle b1 = new Bicycle("Fonkrd", 2010);
    b1.startEngine();
    b1.stopEngine();
  }
}