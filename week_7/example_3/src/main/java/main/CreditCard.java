package main.java.main;

// Implementation of PaymentMethod interface
class CreditCard implements PaymentMethod {
    private String cardNumber;
    private String expiryDate;

    public CreditCard(String cardNumber, String expiryDate) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
    }

    @Override
    public void processPayment(double amount) {
        double totalAmount = amount * (1 + TRANSACTION_FEE);
        System.out.println("Processing credit card payment of $" + totalAmount);
    }

    @Override
    public boolean verifyPayment() {
        System.out.println("Verifying credit card payment...");
        return true;
    }
}