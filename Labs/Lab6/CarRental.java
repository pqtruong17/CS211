class CarRental extends Car implements Rentable{
  private double dailyRate;
  public CarRental(String model, int year, double dailyRate){
    super(model, year);
    setRate(dailyRate);
  }
  public void setRate(double rate){
    this.dailyRate = dailyRate;
  }
  @Override
  public double rent(int days){
    return (double) dailyRate*days;
  }
  public void returnItem(){
    System.out.println("Car has been returned");
  }
}