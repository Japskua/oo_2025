package main.java.main;

// First, let's define an interface for payment methods
public interface PaymentMethod {
    void processPayment(double amount);

    boolean verifyPayment();

    // Constants are implicitly public static final
    double TRANSACTION_FEE = 0.02;
}