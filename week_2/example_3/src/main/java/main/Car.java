package main;

/**
 * Represents a Car with a model, color, and speed.
 */
public class Car {
    private String model;
    private String color;
    private int speed;

    /**
     * Gets the car's model.
     *
     * @return the car's model
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets the car's model.
     *
     * @param model the car's model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Gets the car's color.
     *
     * @return the car's color
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the car's color.
     *
     * @param color the car's color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Gets the car's speed.
     *
     * @return the car's speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Sets the car's speed.
     *
     * @param speed the car's speed
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * Displays the car's details.
     */
    public void displayDetails() {
        System.out.println("Car Details:");
        System.out.println("Model: " + model);
        System.out.println("Color: " + color);
        System.out.println("Speed: " + speed + " km/h");
    }
}