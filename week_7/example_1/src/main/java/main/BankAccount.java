package main.java.main;

public class BankAccount {
    private String accountHolder;
    private double balance;
    private double interestRate;

    // Constructor with parameter names same as instance variables
    public BankAccount(String accountHolder, double balance, double interestRate) {
        // Without 'this', we would have parameter shadowing - can't distinguish
        // between instance variables and parameters
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.interestRate = interestRate;
    }

    // Getter methods
    public String getAccountHolder() {
        return this.accountHolder;
    }

    public double getBalance() {
        return this.balance;
    }

    public double getInterestRate() {
        return this.interestRate;
    }

    // Method demonstrating 'this' for method chaining
    public BankAccount deposit(double amount) {
        this.balance += amount;
        // Returning 'this' allows method chaining
        return this;
    }

    // Method demonstrating 'this' to pass current object to another method
    public void transferTo(BankAccount otherAccount, double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            otherAccount.deposit(amount);
        }
    }

    // Method demonstrating 'this' to call another constructor
    public BankAccount(String accountHolder) {
        // Calls the main constructor with default values
        this(accountHolder, 0.0, 0.05); // 5% default interest rate
    }

    // Method demonstrating 'this' to disambiguate instance method
    public void updateInterestRate(double interestRate) {
        if (this.validateInterestRate(interestRate)) { // Explicit call to instance method
            this.interestRate = interestRate;
        }
    }

    private boolean validateInterestRate(double rate) {
        return rate >= 0 && rate <= 0.1; // Ensure rate is between 0% and 10%
    }
}