import java.util.Scanner;
import java.util.InputMismatchException;

// Custom Exception
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

public class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double balance = 0;

        while (true) {
            try {
                System.out.println("\n===MENU===");
                System.out.println("1.Deposit");
                System.out.println("2.Withdraw");
                System.out.println("3.Show Balance");
                System.out.println("4.Exit");
                System.out.print("Enter your choice: ");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter amount: ");
                        double deposit = sc.nextDouble();

                        if (deposit <= 0) {
                            throw new IllegalArgumentException("Deposit must be positive.");
                        }

                        balance += deposit;
                        System.out.println("Deposit successful! Balance: " + balance);
                        break;

                    case 2:
                        System.out.print("Enter amount withdraw: ");
                        double withdraw = sc.nextDouble();

                        if (withdraw <= 0) {
                            throw new IllegalArgumentException("Withdraw must be positive.");
                        }

                        if (withdraw > balance) {
                            throw new InsufficientBalanceException("Not enough balance!");
                        }

                        balance -= withdraw;
                        System.out.println("Withdraw successful! Balance: " + balance);
                        break;

                    case 3:
                        System.out.println("Current balance: " + balance);
                        break;

                    case 4:
                        System.out.println("Goodbye!");
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter numbers only.");
                sc.nextLine();

            } catch (InsufficientBalanceException e) {
                System.out.println(e.getMessage());

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());

            } catch (Exception e) {
                System.out.println("Unexpected error.");
            }
        }
    }
}