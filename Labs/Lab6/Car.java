class Car extends Vehicle{

    //constructor for Car
    public Car(String model, int year){
        super(model, year, VehicleType.CAR);
    }

    void startEngine(){
        System.out.println("Starting the car's engine.");
    }

    void stopEngine(){
        System.out.println("Stopping the car's engine.");
    }
}