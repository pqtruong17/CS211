class RentalDriver{
  public static void main(String[] args){
    CarRental cR1 = new CarRental("SUV", 2021, 50.0);
    CarRental cR2 = new CarRental("Raptor", 2000, 60.0);
    
    cR1.startEngine();
    cR1.stopEngine();
    
    double carRentalCost = cR1.rent(7);
    System.out.printf("Car rental cost: $%s", carRentalCost);
    cR1.returnItem();
    
    System.out.println(cR2.model); // Proctected access
  }
}