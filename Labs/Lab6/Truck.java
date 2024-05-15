class Truck extends Vehicle{

    //constructor for Truck
    public Truck(String model, int year){
        super(model, year, VehicleType.TRUCK);
    }

    @Override
    void startEngine(){
        System.out.println("Starting the truck's engine.");
    }

    @Override
    void stopEngine(){
        System.out.println("Stopping the truck's engine.");
    }
}