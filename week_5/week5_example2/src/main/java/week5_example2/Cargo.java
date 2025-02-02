package week5_example2;

public class Cargo {
    private double weight;
    private String description;
    
    public Cargo(double weight, String description) {
        this.weight = weight;
        this.description = description;
    }
    
    public double getWeight() {
        return weight;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void updateWeight(double newWeight) {
        this.weight = newWeight;
    }
}
