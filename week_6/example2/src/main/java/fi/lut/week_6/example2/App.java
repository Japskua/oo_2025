package fi.lut.week_6.example2;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        // Upcasting (implicit)
        BankAccount account1 = new SavingsAccount("SA001", 1000.0, 0.05);
        BankAccount account2 = new CheckingAccount("CA001", 2000.0, 500.0);

        // Downcasting (explicit)
        if (account1 instanceof SavingsAccount) {
            SavingsAccount savingsAccount = (SavingsAccount) account1;
            savingsAccount.addInterest();
        }

        // This will fail at runtime (ClassCastException)
        try {
            SavingsAccount wrongCast = (SavingsAccount) account2;
        } catch (ClassCastException e) {
            System.out.println("Cannot cast CheckingAccount to SavingsAccount!");
        }

        // Safe casting using instanceof
        if (account2 instanceof CheckingAccount) {
            CheckingAccount checkingAccount = (CheckingAccount) account2;
            checkingAccount.withdraw(1400.0); // Uses overdraft
        }
        System.out.println("account has balance: " + account1.getBalance());
        System.out.println("account has balance: " + account2.getBalance());
    }
}
