package main;

import main.java.main.BankAccount;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        // Create accounts
        BankAccount account1 = new BankAccount("John Doe", 1000.0, 0.05);
        BankAccount account2 = new BankAccount("Jane Smith"); // Uses second constructor

        // Demonstrate method chaining using 'this'
        account1.deposit(500.0)
                .deposit(200.0)
                .deposit(300.0);

        // Demonstrate object reference using 'this'
        account1.transferTo(account2, 400.0);

        System.out.println("Account 1 balance: " + account1.getBalance());
        System.out.println("Account 2 balance: " + account2.getBalance());
    }
}
