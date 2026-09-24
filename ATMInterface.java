import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Deposit successful. New balance: %.2f%n", balance);
        } else {
            System.out.println("Deposit amount must be greater than 0.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than 0.");
        } else if (amount > balance) {
            System.out.println("Transaction failed: insufficient balance.");
        } else {
            balance -= amount;
            System.out.printf("Withdrawal successful. New balance: %.2f%n", balance);
        }
    }

    public void checkBalance() {
        System.out.printf("Available balance: %.2f%n", balance);
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount(10000.00);

        int choice;

        System.out.println("=================================");
        System.out.println("          ATM INTERFACE");
        System.out.println("=================================");

        do {
            System.out.println("\n1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 3:
                    account.checkBalance();
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM.");
                    break;

                default:
                    System.out.println("Invalid choice. Please select 1-4.");
            }

        } while (choice != 4);

        sc.close();
    }
}
