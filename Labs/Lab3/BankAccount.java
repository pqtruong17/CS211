import java.util.Scanner;

public class BankAccount {

    // Declare the fields of the class
    private double balance;
    private double interestRate;
    private String ownerName;

    // Define the constructor of the class that takes three parameters
    public BankAccount(double balance, double interestRate, String ownerName) {
        // Assign the values of the parameters to the attributes
        this.balance = balance;
        this.interestRate = interestRate;
        this.ownerName = ownerName;
    }

    // Define a method to deposit money into the account
    public void deposit(double amount) {
      this.balance += amount;
      //System.out.printf("You have deposited %s in your account.\n" ,this.balance);
    }

    // Define a method to withdraw money from the account
    public void withdraw(double amount) {
        // Check if the amount is less than or equal to the balance
        if (amount <= balance) {
        // Subtract the amount from the balance
            this.balance -= amount;
        // Print a message to confirm the withdrawal

        } else {
        // Print a message to indicate insufficient funds
          System.out.println("insufficient funds");
        }
    }

    // Define a method to transfer money from one account to another
    public void transfer(BankAccount other, double amount) {
        // Check if the amount is less than or equal to the balance
        if (amount <= balance) {
        // Subtract the amount from the balance of this account
            this.withdraw(amount);
        // Add the amount to the balance of the other account
            other.deposit(amount);
        // Print a message to confirm the transfer
            System.out.println("You have transferred " + amount + " from your account to " + other.ownerName 
   + "'s account.");
        } else {
        // Print a message to indicate insufficient funds
            System.out.println("You do not have enough money in your account.");
        }
    }

    // Define a method to display the information of the account
    public void display() {
        // Print the owner name, balance, and interest rate of the account
        System.out.println("Owner name: " + ownerName);
        System.out.println("Balance: " + balance);
        System.out.println("Interest rate: " + interestRate);
    }


    public static void main(String[] args) {
        // Create an object called account1 with initial values
        BankAccount account_1 = new BankAccount(1000,0.05, "Alice");
        // Create another object called account2 with different values
        Scanner scnr = new Scanner(System.in);
        
        System.out.println("Enter Bob Balance (For example: 1000.05, 3450.99, 599.86 etc)");
        double input_balance = scnr.nextDouble();
        System.out.println("Enter Bob interestRate in percentage (For example: 50, 40, 65, and etc)");
        double input_interestRate = scnr.nextDouble();
        input_interestRate = input_interestRate/100;
        
        BankAccount account_2 = new BankAccount(input_balance,input_interestRate,"Bob");
        
        // Display the information of both accounts
        account_1.display();
        account_2.display();
        
        // Deposit 100 into account1
        account_1.deposit(100);

        // Withdraw 200 from account2
        account_2.deposit(100);

        // Transfer 300 from account1 to account2
        account_1.transfer(account_2, 300);
        
        // Display the information of both accounts again
        account_1.display();
        account_2.display();
    }
}




