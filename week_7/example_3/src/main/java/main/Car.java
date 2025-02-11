package main.java.main;

// Class that extends the abstract Vehicle class
class Car extends Vehicle {
    private int engineSize;

    public Car(String brand, String model, int year, int engineSize) {
        super(brand, model, year);
        this.engineSize = engineSize;
    }

    @Override
    double calculateFuelEfficiency() {
        return 30.5 - (engineSize / 1000.0) * 5;
    }

    @Override
    void startEngine() {
        System.out.println("Starting car engine...");
    }
}