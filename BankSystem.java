import java.util.*;

class BankAccount {

    double balance = 0;
    ArrayList<String> history = new ArrayList<>();

    void deposit(double amount) {
        balance += amount;
        history.add("Deposited: " + amount);
        System.out.println("Amount Deposited Successfully");
    }

    void withdraw(double amount) {

        if(amount > balance) {
            System.out.println("Insufficient Balance");
        } 
        else {
            balance -= amount;
            history.add("Withdrawn: " + amount);
            System.out.println("Amount Withdrawn Successfully");
        }
    }

    void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }

    void showHistory() {
        System.out.println("Transaction History:");
        for(String h : history) {
            System.out.println(h);
        }
    }
}

public class BankSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankAccount acc = new BankAccount();
       
        int choice;

        do {

            System.out.println("\n1 Deposit");
            System.out.println("2 Withdraw");
            System.out.println("3 Check Balance");
            System.out.println("4 Transaction History");
            System.out.println("5 Exit");

            choice = sc.nextInt();

            switch(choice) {

                case 1:
                    System.out.print("Enter amount: ");
                    double d = sc.nextDouble();
                    acc.deposit(d);
                    break;

                case 2:
                    System.out.print("Enter amount: ");
                    double w = sc.nextDouble();
                    acc.withdraw(w);
                    break;

                case 3:
                    acc.checkBalance();
                    break;

                case 4:
                    acc.showHistory();
                    break;

                case 5:
                    System.out.println("Thank you!");
                    break;
            }

        } while(choice != 5);
        sc.close();
    }
}