package main;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        // Using the interface
        PaymentMethod payment = new CreditCard("1234-5678-9012-3456", "12/25");
        payment.processPayment(100.0);
        payment.verifyPayment();

        // Using the abstract class
        Vehicle car = new Car("Volkswagen", "Golf", 2024, 2500);
        car.displayInfo();
        car.startEngine();
        System.out.println("Fuel efficiency: " + car.calculateFuelEfficiency() + " mpg");
    }
}
