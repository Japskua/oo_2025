package fi.lut.oo.week_3.example_1;

// Enum for Pizza Size
enum PizzaSize {
    SMALL, MEDIUM, LARGE
}

// Enum for Pizza Type
enum PizzaType {
    MARGHERITA, PEPPERONI, VEGGIE, HAWAIIAN
}

public class PizzaPlace {
    // Constants for prices
    private static final double BASE_PRICE_SMALL = 8.0;
    private static final double BASE_PRICE_MEDIUM = 10.0;
    private static final double BASE_PRICE_LARGE = 12.0;

    public static void main(String[] args) {
        // Example Pizza Order
        PizzaType pizzaType = PizzaType.PEPPERONI;
        PizzaSize pizzaSize = PizzaSize.LARGE;
        
        int quantity = 2; // Number of pizzas
        System.out.println("Order Details:");
        System.out.println("Pizza: " + pizzaType);
        System.out.println("Size: " + pizzaSize);
        System.out.println("Quantity: " + quantity);

        // Calculate total price
        double price = calculatePrice(pizzaSize, quantity);
        System.out.println("Total Price: $" + price);

        // Example usage of ++ operator
        System.out.println("\nCustomer decides to add one more pizza...");
        quantity++;
        System.out.println("Updated Quantity: " + quantity);
        System.out.println("Updated Total Price: $" + calculatePrice(pizzaSize, quantity));

        // Example usage of -- operator
        System.out.println("\nCustomer changes their mind and removes one pizza...");
        quantity--;
        System.out.println("Updated Quantity: " + quantity);
        System.out.println("Updated Total Price: $" + calculatePrice(pizzaSize, quantity));
    }

    // Method to calculate price based on size and quantity
    private static double calculatePrice(PizzaSize size, int quantity) {
        double basePrice;
        switch (size) {
            case SMALL:
                basePrice = BASE_PRICE_SMALL;
                break;
            case MEDIUM:
                basePrice = BASE_PRICE_MEDIUM;
                break;
            case LARGE:
            default:
                basePrice = BASE_PRICE_LARGE;
        }
        return basePrice * quantity;
    }
}