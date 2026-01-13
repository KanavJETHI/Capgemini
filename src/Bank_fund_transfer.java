import java.util.Scanner;

// Custom Exception for Insufficient Funds
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

// Custom Exception for Account Not Found
class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String message) {
        super(message);
    }
}

// Account Class
class Account {
    private int accountNumber;
    private String accountHolderName;
    private double balance;

    public Account(int accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (balance < amount) {
            throw new InsufficientFundsException("Insufficient funds in account " + accountNumber);
        }
        balance -= amount;
    }

    public String toString() {
        return "Account[" + accountNumber + ", " + accountHolderName + ", Balance: " + balance + "]";
    }
}

// Online Banking System
class OnlineBankingSystem {
    private Account[] accounts;
    private int count;
    private Scanner sc;

    public OnlineBankingSystem() {
        accounts = new Account[10]; // Fixed size array
        count = 0;
        sc = new Scanner(System.in);

        // Initialize with sample accounts
        accounts[count++] = new Account(101, "Alice", 5000);
        accounts[count++] = new Account(102, "Bob", 5000);
        accounts[count++] = new Account(103, "Charlie", 3000);
    }

    // Find account by account number
    private Account findAccount(int accountNumber) throws AccountNotFoundException {
        for (int i = 0; i < count; i++) {
            if (accounts[i].getAccountNumber() == accountNumber) {
                return accounts[i];
            }
        }
        throw new AccountNotFoundException("Target account " + accountNumber + " does not exist");
    }

    // Transfer funds between accounts
    public void transferFunds() {
        try {
            System.out.print("Enter source account number: ");
            int sourceAccountNumber = sc.nextInt();

            System.out.print("Enter target account number: ");
            int targetAccountNumber = sc.nextInt();

            System.out.print("Enter amount to transfer: ");
            double amount = sc.nextDouble();

            // Validate amount
            if (amount <= 0) {
                throw new IllegalArgumentException("Amount cannot be negative or zero");
            }

            // Find accounts
            Account sourceAccount = findAccount(sourceAccountNumber);
            Account targetAccount = findAccount(targetAccountNumber);

            // Perform transfer
            sourceAccount.withdraw(amount);
            targetAccount.deposit(amount);

            System.out.println("Transaction successful!");
            System.out.println("Updated balance of " + sourceAccountNumber + ": " + (int)sourceAccount.getBalance());
            System.out.println("Updated balance of " + targetAccountNumber + ": " + (int)targetAccount.getBalance());

        } catch (InsufficientFundsException e) {
            System.out.println("Transaction failed: " + e.getMessage());
        } catch (AccountNotFoundException e) {
            System.out.println("Transaction failed: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Transaction failed: " + e.getMessage());
        } finally {
            System.out.println("Transaction ended.");
        }
    }

    // Display all accounts
    public void displayAccounts() {
        System.out.println("\n=== Account Details ===");
        for (int i = 0; i < count; i++) {
            System.out.println(accounts[i]);
        }
        System.out.println();
    }
}

// Main class matching your file name
public class Bank_fund_transfer {
    public static void main(String[] args) {
        OnlineBankingSystem system = new OnlineBankingSystem();

        // Perform multiple transactions to demonstrate all scenarios
        system.transferFunds();
        System.out.println();

        system.transferFunds();
        System.out.println();

        system.transferFunds();
        System.out.println();

        system.transferFunds();
    }
}