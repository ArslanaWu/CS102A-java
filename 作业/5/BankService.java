import java.util.ArrayList;
import java.text.DecimalFormat;

public class BankService {
    private double availableCash;
    private ArrayList<BankAccount> accounts =  new ArrayList<>();

    public BankService() {
        availableCash = 100000;
        accounts.clear();
        System.out.printf("Initializing bank service: no accounts yet, %.2f ¥ cash available\n",availableCash);
    }

    public double getAvailableCash() {
        return availableCash;
    }

    public void setAvailableCash(double availableCash) {
        this.availableCash = availableCash;
    }

    public ArrayList<BankAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<BankAccount> accounts) {
        this.accounts = accounts;
    }

    public BankAccount getAccount(Customer customer) {
        for (BankAccount acc : accounts) {
            if (acc.getOwner() == customer) {
                return acc;
            }
        }
        return null;
    }

    public BankAccount getAccount(String ssn) {
        for (BankAccount acc : accounts) {
            if (acc.getOwner().getSocialSecurityNumber().equals(ssn)) {
                return acc;
            }
        }
        return null;
    }

    public void checkAccountBalance(String ssn) {
        if(accounts.size() == 0){
            System.out.println("No account found");
            return;
        }
        Customer cus = getAccount(ssn).getOwner();
        if (cus.getSocialSecurityNumber().equals(ssn)) {
            if (cus.getGender() == Gender.FEMALE) {
                System.out.print("Ms. ");
            } else {
                System.out.print("Mr. ");
            }
            System.out.printf("%s, your account balance: %.2f ¥\n", cus.getLastName(),
                    getAccount(ssn).getBalance());
            return;
        }
    }

    public void createAccount(String firstName, String lastName, char gender, String ssn) {
        firstName = Customer.formatName(firstName);
        lastName = Customer.formatName(lastName);


        if (!Customer.checkName(firstName) || !Customer.checkName(lastName)) {
            System.out.println("Invalid name");
            return;
        } else if (Character.toLowerCase(gender) != 'm' && Character.toLowerCase(gender) != 'f') {
            System.out.println("Invalid input for gender");
            return;
        } else if (!Customer.checkSSN(ssn)) {
            System.out.println("Invalid social security number");
            return;
        }
        if (accounts.size() != 0) {
            if (getAccount(ssn).getOwner().getSocialSecurityNumber().equals(ssn)) {
                if (Character.toLowerCase(gender) == 'm') {
                    System.out.print("Mr. ");
                } else if (Character.toLowerCase(gender) == 'f') {
                    System.out.print("Ms. ");
                }
                System.out.printf("%s, you already have an account with a balance %.2f ¥.\n", lastName,
                        getAccount(ssn).getBalance());
                return;
            }
        }

        if (Character.toLowerCase(gender) == 'm') {
            Customer cus = new Customer(firstName, lastName, Gender.MALE, ssn);
            BankAccount bA = new BankAccount(cus, 0.00);
            accounts.add(bA);
            System.out.printf("Congrats, Mr. %s! Your account is created successfully.\n", lastName);
            return;
        } else {
            Customer cus = new Customer(firstName, lastName, Gender.FEMALE, ssn);
            BankAccount bA = new BankAccount(cus, 0.00);
            accounts.add(bA);
            System.out.printf("Congrats, Ms. %s! Your account is created successfully.\n", lastName);
            return;
        }

    }

    public void makeDeposit(String ssn, double amount){
        if(accounts.size() == 0){
            System.out.println("No account found");
            return;
        }
        if(amount < 0){
            System.out.println("Invalid amount");
            return;
        }
        if(!Customer.checkSSN(ssn)){
            System.out.println("Invalid social security number");
            return;
        }
        if(getAccount(ssn).getOwner().getSocialSecurityNumber().equals(ssn)){
            System.out.printf("Original balance: %.2f ¥\n",getAccount(ssn).getBalance());
            getAccount(ssn).setBalance(getAccount(ssn).getBalance() + amount);
            System.out.printf("Balance after deposit: %.2f ¥\n",getAccount(ssn).getBalance());
            return;
        }
    }

    public void withdraw(String ssn, double amount){
        if(accounts.size() == 0){
            System.out.println("No account found");
            return;
        }
        if(amount < 0){
            System.out.println("Invalid amount");
            return;
        }
        if(!Customer.checkSSN(ssn)){
            System.out.println("Invalid social security number");
            return;
        }
        if(getAccount(ssn).getOwner().getSocialSecurityNumber().equals(ssn)){
            if(getAccount(ssn).getBalance() < amount || amount > availableCash){
                System.out.println("No enough balance or cash");
                return;
            }else{
                System.out.printf("Original balance: %.2f ¥\n",getAccount(ssn).getBalance());
                getAccount(ssn).setBalance(getAccount(ssn).getBalance() - amount);
                System.out.printf("Balance after withdrawal: %.2f ¥\n",getAccount(ssn).getBalance());
                availableCash = availableCash - amount;
                return;
            }
        }
    }

    public static void calculateMonthlyPayment(double loanAmount, int years){
        double rate;
        System.out.printf("Loan amount (¥): %f\n",loanAmount);
        System.out.printf("Loan term (years): %d\n",years);
        if(loanAmount < 0 || years < 1){
            System.out.println("invalid loan");
            return;
        }
        System.out.println();
        System.out.println("Calculation result:");

        DecimalFormat dfLoanAmount = new DecimalFormat("#,###.00");
        String formatLoanAmount = dfLoanAmount.format(loanAmount);
        System.out.printf("Loan amount: %s ¥\n",formatLoanAmount);

        if(years <= 2){
            rate = 4.35;
        }else if(years <= 5){
            rate = 4.75;
        }else{
            rate = 4.90;
        }
        System.out.printf("Yearly interest rate: %.2f",rate);
        System.out.println("%");
        System.out.printf("Number of installments (months): %d\n",years*12);

        double pay = loanAmount * rate / 1200 * Math.pow((1 + rate / 1200),years * 12) / (Math.pow((1 + rate / 1200),years * 12) - 1);
        DecimalFormat dfPay = new DecimalFormat("#,###.00");
        String formatPay = dfPay.format(pay);
        System.out.printf("Monthly payment: %s ¥\n",formatPay);

        double interest = pay * years * 12 - loanAmount;
        DecimalFormat dfInterest = new DecimalFormat("#,###.00");
        String formatInterest = dfInterest.format(interest);
        System.out.printf("Total interest: %s ¥\n",formatInterest);
    }
}

