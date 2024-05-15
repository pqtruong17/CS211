public class Bank {
    private String bankName;

    // Constructor for Bank class
    public Bank(String name) {
        this.bankName = name;
    }

    // Method in Bank class
    public void displayBankInfo() {
        System.out.println("Bank Name: " + bankName);
    }

    // Nested class inside Bank class
    public class Account {
        private String accountNumber;
        private double balance;

        // Constructor for Account class
        public Account(String accNumber, double initialBalance) {
            this.accountNumber = accNumber;
            this.balance = initialBalance;
        }

        // Method in Account class
        public void displayAccountInfo() {
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Balance: $" + balance);
        }

        // Method to deposit money into the account
        public void deposit(double amount) {
            balance += amount;
            System.out.println("$" + amount + " deposited successfully.");
        }

        // Method to withdraw money from the account
        public void withdraw(double amount) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("$" + amount + " withdrawn successfully.");
            } else {
                System.out.println("Insufficient balance.");
            }
        }
    }
}
