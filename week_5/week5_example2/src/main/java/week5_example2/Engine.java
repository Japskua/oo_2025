package week5_example2;

public class Engine {
    private double fuelLevel;
    private boolean isRunning;
    
    public Engine(double initialFuel) {
        this.fuelLevel = initialFuel;
        this.isRunning = false;
    }
    
    public boolean start() {
        if (fuelLevel > 0) {
            isRunning = true;
            return true;
        }
        return false;
    }
    
    public void stop() {
        isRunning = false;
    }
    
    public double getFuelLevel() {
        return fuelLevel;
    }
    
    public void refuel(double amount) {
        if (amount > 0) {
            fuelLevel += amount;
        }
    }
}
