package main;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a Car object
        Car car = new Car();

        // Read user input for car details
        System.out.print("Enter car model: ");
        String model = scanner.nextLine();
        car.setModel(model);

        System.out.print("Enter car color: ");
        String color = scanner.nextLine();
        car.setColor(color);

        System.out.print("Enter car speed: ");
        int speed = scanner.nextInt();
        car.setSpeed(speed);

        // Display the car's details
        System.out.println();
        car.displayDetails();

        scanner.close();
    }
}
