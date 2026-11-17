
//asherz09
import java.util.*;

public class BankAccount {

    int accountNumber;
    String accountHolderName;
    double balance;

    BankAccount(int accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Deposited: " + amount);
    }

    void withdraw(double amount) {

        if (amount>0 && amount<=balance) {
            balance = balance - amount;
            System.out.println();
            System.out.println("Withdrawn: " + amount);
            System.out.println("Balance: " + balance);
        } else {
            System.out.println("Insufficient Balance");
            System.out.println();
        }
    }

    void checkBalance() {
        System.out.println("Balance: " + balance);
        System.out.println();
    }

    void displayDetails() {
        System.out.println("Account number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Balance: " + balance);
        System.out.println();
    }
}

class main {
    static int searchAcc(BankAccount[] accounts, int n, int searchAcc) {
        for (int i=0; i<n; i++) {
            if (accounts[i].accountNumber==searchAcc) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        // Mock Data

        /*
         * BankAccount account1 = new BankAccount(101, "John Doe", 10000);
         * BankAccount account2 = new BankAccount(102, "Jane Doe", 5000);
         * 
         * account1.withdraw(1000);
         * account1.checkBalance();
         * 
         * account2.deposit(1000);
         * account2.checkBalance();
         * 
         * account1.displayDetails();
         * account2.displayDetails();
         */

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of accounts to open: ");
        int n = sc.nextInt();

        BankAccount[] accounts = new BankAccount[n];

        for (int i=0; i<n; i++) {

            System.out.println("\nEnter details for account " + (i+1));

            System.out.print("Enter account number: ");
            int accNo = sc.nextInt();

            System.out.print("Enter account holder name: ");
            String accHolNam = sc.next();

            System.out.print("Enter balance: ");
            double bal = sc.nextDouble();

            accounts[i] = new BankAccount(accNo, accHolNam, bal);
        }

        int anotherAccount;

        do {
            System.out.print("\nEnter account number to access: ");
            int searchAcc = sc.nextInt();

            int index = searchAcc(accounts, n, searchAcc);

            if (index==-1) {
                System.out.println("Account not found");
            }

            else {
                System.out.println("\nWelcome " + accounts[index].accountHolderName);

                int anotherOperation;

                do {
                    System.out.println("\n1. Deposit");
                    System.out.println("2. Withdraw");
                    System.out.println("3. Check Balance");
                    System.out.println("4. Display Account Details");

                    System.out.print("\nChoose an operation: ");
                    int choice = sc.nextInt();

                    switch (choice) {

                        case 1:
                            System.out.print("\nEnter deposit amount: ");
                            double depositAmount = sc.nextDouble();

                            accounts[index].deposit(depositAmount);
                            break;

                        case 2:
                            System.out.print("\nEnter withdrawal amount: ");
                            double withdrawAmount = sc.nextDouble();

                            accounts[index].withdraw(withdrawAmount);
                            break;

                        case 3:
                            accounts[index].checkBalance();
                            break;

                        case 4:
                            accounts[index].displayDetails();
                            break;

                        default:
                            System.out.println("\nInvalid choice");
                    }

                    System.out.print("\nDo you want another operation in this account? (1 = Yes, 0 = No): ");
                    anotherOperation = sc.nextInt();
                }

                while (anotherOperation==1);
            }

            System.out.print("\nDo you want to access another account? (1 = Yes, 0 = No): ");
            anotherAccount = sc.nextInt();

        }

        while (anotherAccount==1);

        System.out.println("\nThank you for using my banking system");

        sc.close();
    }
}

// ~asherz09