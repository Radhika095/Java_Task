import java.util.Scanner;

public class BankingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int balance = 10000;
        System.out.println("Welcome to Kiran Bank");

        while (true) {
            System.out.println("\n1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.println("Current Balance: " + balance);
            } else if (choice == 2) {
                System.out.print("Enter deposit amount: ");
                int amount = sc.nextInt();
                if (amount > 0) {
                    balance += amount;
                    System.out.println("Deposit successful.");
                    System.out.println("Updated Balance: " + balance);
                } else {
                    System.out.println("Invalid amount. Must be greater than 0.");
                }
            } else if (choice == 3) {
                System.out.print("Enter withdrawal amount: ");
                int amount = sc.nextInt();
                if (amount > 0) {
                    if (amount <= balance) {
                        balance -= amount;
                        System.out.println("Withdrawal successful.");
                        System.out.println("Updated Balance: " + balance);
                    } else {
                        System.out.println("Transaction failed: Insufficient balance.");
                    }
                } else {
                    System.out.println("Invalid amount. Must be greater than 0.");
                }
            } else if (choice == 4) {
                System.out.println("Thank you for banking with us. Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        sc.close();
    }
}w

