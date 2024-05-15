class Bicycle extends Vehicle {
    public Bicycle(String model, int year) {
        super(model, year, VehicleType.BICYCLE);
    }

    @Override
    void startEngine() {
        System.out.println("Bicycles don't have engines.");
    }

    @Override
    void stopEngine() {
        System.out.println("Bicycles don't have engines.");
    }
}