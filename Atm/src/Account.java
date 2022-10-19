import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'₹'###,##0.00");

    //  Initialization
    private int customerNumber;
    private int pinNumber;
    private double checkingBalance = 0;
    private double savingBalance = 0;


//  Getters and Setters

    public int getCustomerNumber() {
        return customerNumber;
    }

    public int setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
        return customerNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public int setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
        return pinNumber;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

//   Withdraw Balance Calculator

    public double calcCheckingWithdraw(double amount) {
        checkingBalance = (checkingBalance - amount);
        return checkingBalance;
    }

    public double calcSavingWithdraw(double amount) {
        savingBalance = (savingBalance - amount);
        return savingBalance;
    }

//   Deposit Balance Calculator

    public double calcCheckingDeposit(double amount) {
        checkingBalance = (checkingBalance + amount);
        return checkingBalance;
    }

    public double calcSavingDeposit(double amount) {
        savingBalance = (savingBalance + amount);
        return savingBalance;
    }

    //Checking Withdraw Logic
    public void getCheckingWithdrawInput() {
        System.out.println("\nChecking Account Balance: " + moneyFormat.format(checkingBalance));
        System.out.print("Amount to Withdraw from Checking Account: ");
        double amount = input.nextDouble();
        if ((checkingBalance - amount) > 0) {
            calcCheckingWithdraw(amount);
            System.out.println("Remaining Checking Account Balance: " + moneyFormat.format(checkingBalance));
        } else {
            System.out.println("Balance ShortFall! Cannot Withdraw.\n");
        }
    }
    //Checking Deposit Logic

    public void getCheckingDepositInput() {
        System.out.println("\nChecking Account Balance: " + moneyFormat.format(checkingBalance));
        System.out.println("Amount to Deposit in Checking Account: ");
        double amount = input.nextDouble();
        if ((amount) > 0) {
            calcCheckingDeposit(amount);
            System.out.println("New Checking Account Balance: " + moneyFormat.format(checkingBalance));
        } else {
            System.out.println("Deposit amount should be greater than zero.");
        }
    }
    //Saving Withdraw Logic
    public void getSavingWithdrawInput() {
        System.out.println("\nSaving Account Balance: " + moneyFormat.format(savingBalance));
        System.out.print("Amount to Withdraw from Saving Account: ");
        double amount = input.nextDouble();
        if ((savingBalance - amount) > 0) {
            calcSavingWithdraw(amount);
            System.out.println("Remaining Saving Account Balance: " + moneyFormat.format(savingBalance));
        } else {
            System.out.println("Balance ShortFall! Cannot Withdraw.\n");
        }
    }
    //Saving Deposit Logic

    public void getSavingDepositInput() {
        System.out.println("\nSaving Account Balance: " + moneyFormat.format(savingBalance));
        System.out.println("Amount to Deposit in Saving Account: ");
        double amount = input.nextDouble();
        if ((amount) > 0) {
            calcSavingDeposit(amount);
            System.out.println("New Saving Account Balance: " + moneyFormat.format(savingBalance));
        } else {
            System.out.println("Deposit amount should be greater than zero.");
        }
    }
}
