import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== WELCOME TO MICROX DIGITAL BANK ===");
        System.out.print("Enter Account Holder Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Initial Deposit Amount: ");
        double initialAmount = scanner.nextDouble();

        // Object creation (OOP Concept)
        BankAccount userAccount = new BankAccount(name, initialAmount);
        
        boolean running = true;
        while (running) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    userAccount.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depAmt = scanner.nextDouble();
                    userAccount.deposit(depAmt);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double witAmt = scanner.nextDouble();
                    userAccount.withdraw(witAmt);
                    break;
                case 4:
                    running = false;
                    System.out.println("Thank you for using MicroX Bank.");
                    break;
                default:
                    System.out.println("Invalid option! Try again.");
            }
        }
        scanner.close();
    }
}

// Separate Class demonstrating Encapsulation
class BankAccount {
    private String accountHolder;
    private double balance;

    public BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void checkBalance() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Current Balance: Rs. " + balance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Rs. " + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Rs. " + amount + " withdrawn successfully.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance inside account.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }
}