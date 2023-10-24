import java.util.Scanner;

class BankAccount{
    private double balance;

    public BankAccount(double initialBalance) {
       balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double newBalance) {
        balance = newBalance;
    }
}

class ATM{
    private BankAccount userAccount;

    public ATM(double initialBalance) {
        userAccount = new BankAccount(initialBalance);
    }

    public void withdraw(double amount){
        if (amount > 0 && amount<=userAccount.getBalance()){
            userAccount.setBalance(userAccount.getBalance()-amount);
            System.out.println("Withdrawal of $" + amount + "successful.");
        } else {
            System.out.println("Insufficient balance !!");
        }
    }

    public void deposit(double amount){
        if (amount > 0){
            userAccount.setBalance(userAccount.getBalance()+amount);
            System.out.println("Deposit of $" + amount + "successful.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public double checkBalance(){
        return userAccount.getBalance();
    }
}





public class ATMapp {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        ATM atm = new ATM(100000000);

        while (true){
            System.out.println("\nOptions:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("Enter withdrawal amount: $");
                    double withdrawalAmount = scanner.nextDouble();
                    atm.withdraw(withdrawalAmount);
                }
                case 2 -> {
                    System.out.println("Enter deposit-able amount: $");
                    double depositableAmount = scanner.nextDouble();
                    atm.deposit(depositableAmount);
                }
                case 3 -> {
                    double yourBalance = atm.checkBalance();
                    System.out.println("Your balance is: $" + yourBalance);
                }

                case 4 -> {
                    System.out.println("Thank you for using ATM !!!");
                    System.exit(0);
                }

                default -> {
                    System.out.println("Invalid choice");
                    System.out.println("Thank you for using ATM !!!");
                    System.exit(0);
                }
            }
        }

    }
}
