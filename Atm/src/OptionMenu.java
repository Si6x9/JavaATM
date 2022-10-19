import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class OptionMenu extends Account {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'₹'###,##0.00");
    HashMap<Integer, Integer> Data = new HashMap<Integer, Integer>();

    public void getLogin() throws IOException {
        try {
            Data.put(507610110, 2645);
            Data.put(123, 456);
            Data.put(941322000, 9986);

            System.out.println("Welcome to JavaATM Machine!");
            System.out.print("Enter your Consumer Number: ");
            setCustomerNumber(menuInput.nextInt());
            System.out.print("Enter your Pin: ");
            setPinNumber(menuInput.nextInt());
        } catch (Exception e) {
            System.out.println("Please enter valid input");
        }
        int checkConsumerNumber = getCustomerNumber();
        int checkPinNumber = getPinNumber();
        if (Data.containsKey(checkConsumerNumber) && Data.containsValue(checkPinNumber)) {
            getAccountType();
        } else {
            System.out.println("Please enter valid credentials\n");
            getLogin();
        }

    }
    public void getAccountType() throws IOException {
        System.out.println("\nSelect the Account Type you want to access");
        System.out.println("1. Current Account");
        System.out.println("2. Savings Account");
        System.out.println("3. Exit");
        int selection = menuInput.nextInt();

        switch (selection){
            case 1:
                getChecking();
                break;
            case 2:
                getSaving();
                break;
            case 3:
                System.out.println("Thankyou, visit again.");
                break;
            default:
                System.out.println("Please choose a correct input.\n");
                getAccountType();
        }
    }
    public void getChecking() throws IOException {
        System.out.println("\nWhat do you want to perform-");
        System.out.println("1. Check Account Balance");
        System.out.println("2. Withdraw Amount");
        System.out.println("3. Deposit Amount");
        System.out.println("4. Log Out");
        int selection = menuInput.nextInt();
        switch (selection){
            case 1:
                System.out.println("Your account balance is: " + moneyFormat.format(getCheckingBalance()));
                getChecking();
                break;
            case 2:
                getCheckingWithdrawInput();
                getChecking();
                break;
            case 3:
                getCheckingDepositInput();
                getChecking();
                break;
            case 4:
                System.out.println("Thankyou, visit again.");
                getAccountType();
                break;
            default:
                System.out.println("Please enter a valid input\n");
                getChecking();

        }
    }
    public void getSaving() throws IOException {
        System.out.println("\nWhat do you want to perform-");
        System.out.println("1. Check Account Balance");
        System.out.println("2. Withdraw Amount");
        System.out.println("3. Deposit Amount");
        System.out.println("4. Log Out");
        int selection = menuInput.nextInt();
        switch (selection){
            case 1:
                System.out.println("Your account balance is: " + moneyFormat.format(getSavingBalance()));
                getSaving();
                break;
            case 2:
                getSavingWithdrawInput();
                getSaving();
                break;
            case 3:
                getSavingDepositInput();
                getSaving();
                break;
            case 4:
                System.out.println("Thankyou, visit again.");
                getAccountType();
                break;
            default:
                System.out.println("Please enter a valid input\n");
                getSaving();

        }
    }
}
