class Motorcycle extends Vehicle{

    //constructor for Motorcycle
    public Motorcycle(String model, int year){
        super(model, year, VehicleType.MOTORCYCLE);
    }

    @Override
    void startEngine(){
        System.out.println("Starting the motorcycle's engine.");
    }

    @Override
    void stopEngine(){
        System.out.println("Stopping the motorcycle's engine.");
    }
}