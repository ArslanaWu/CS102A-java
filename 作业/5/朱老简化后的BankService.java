import java.util.ArrayList;
import java.text.DecimalFormat;

public class BankService {
    private double availableCash;
    private ArrayList<BankAccount> accounts;

    public BankService() {
        availableCash = 100000.00;
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
        for (Account acc : accounts) {
            if (acc.getOwner() == customer) {
                return acc;
            }
        }
        return null;
    }

    public BankAccount getAccount(String ssn) {
        for (Account acc : accounts) {
            if (acc.getSocialSecurityNumber().equals(ssn)) {
                return acc;
            }
        }
        return null;
    }

    public void checkAccountBalance(String ssn) {
        Account acc = getAccount(ssn);
        if (acc == null) {
            System.out.println("No account found");
            return;
        }
        if (acc.getOwner().getGender() == Gender.FEMALE) {
            System.out.print("Ms. ");
        } else {
            System.out.print("Mr. ");
        }
        System.out.printf("%s, your account balance: %.2f ¥\n", getAccount(ssn).getOwner().getLastName(),
                getAccount(ssn).getBalance());
    }

    public void createAccount(String firstName, String lastName, char gender, String ssn) {
        firstName = Customer.formatName(firstName);
        lastName = Customer.formatName(lastName);

        if (!Customer.checkName(firstName) || !Customer.checkName(lastName)) {
            System.out.print("Invalid name");
            return;
        } else if (Character.toLowerCase(gender) != 'm' && Character.toLowerCase(gender) != 'f') {
            System.out.print("Invalid input for gender");
            return;
        } else if (!Customer.checkSSN(ssn)) {
            System.out.print("Invalid social security number");
            return;
        }
        boolean isMale = Character.toLowerCase(gender) == 'm';
        String title = isMale ? "Mr" : "Ms";

        for (Account acc : accounts) {
            Customer owner = acc.getOwner();
            if (owner.getFirstName().equals(firstName) && owner.getLastName().equals(lastName)) {
                System.out.printf("%s. %s, you already have an account with a balance %.2f ¥.\n", title, lastName,
                        acc.getBalance());
                return;
            }
        }

        Cusomer cus = new Customer(firstName, lastName, isMale ? Gender.MALE : Gender.FEMALE, ssn);
        BankAccount bA = new BankAccount(cus, 0.00);
        accounts.add(bA);
        System.out.printf("Congrats, %s. %s! Your account is created successfully.", title, lastName);
    }

    public void makeDeposit(String ssn, double amount) {
        if (amount < 0) {
            System.out.println("Invalid amount");
            return;
        }
        if (!Customer.checkSSN(ssn)) {
            System.out.println("Invalid social security number");
            return;
        }
        Account acc = getAccount(ssn);
        if (acc == null) {
            System.out.println("No account found");
            return;
        }
        System.out.printf("Original balance: %.2f ¥\n", acc.getBalance());
        acc.setBalance(acc.getBalance() + amount);
        System.out.printf("Balance after deposit: %.2f ¥\n", acc.getBalance());
    }

    public void withdraw(String ssn, double amount) {
        if (amount < 0) {
            System.out.println("Invalid amount");
            return;
        }
        if (!Customer.checkSSN(ssn)) {
            System.out.println("Invalid social security number");
            return;
        }
        Account acc = getAccount(ssn);
        if (acc == null) {
            System.out.println("No account found");
            return;
        }

        if (acc.getBalance() < amount || amount > availableCash) {
            System.out.println("No enough balance or cash");
            return;
        }
        System.out.printf("Original balance: %.2f ¥\n", acc.getBalance());
        acc.setBalance(acc.getBalance() - amount);
        System.out.printf("Balance after deposit: %.2f ¥\n", acc.getBalance());
    }

    public static void calculateMonthlyPayment(double loanAmount, int years) {
        double rate = calculateRate(years);
        System.out.printf("Loan amount (¥): %f\n", loanAmount);
        System.out.printf("Loan term (years): %d\n", years);
        if (loanAmount < 0 || years < 1) {
            System.out.println("invalid loan");
            return;
        }

        System.out.println("\nCalculation result:");

        DecimalFormat monryFormat = new DecimalFormat("#,###.00");
        
        String formatLoanAmount = monryFormat.format(loanAmount);
        System.out.printf("Loan amount: %s ¥\n", formatLoanAmount);

        System.out.printf("Yearly interest rate: %.2f%\n", rate);
        System.out.printf("Number of installments (months): %d", years * 12);

        double pay = loanAmount * rate / 1200 * Math.pow((1 + rate / 100), years * 12)
                / (Math.pow((1 + rate / 100), years * 12) - 1);
        String formatPay = monryFormat.format(pay);
        System.out.printf("Monthly payment: %s ¥\n", formatPay);

        double interest = loanAmount * rate / 100 * years;
        String formatInterest = monryFormat.format(interest);
        System.out.printf("Total interest: %s ¥\n", formatInterest);
    }

    private static double calculateRate(int years) {
        if (years <= 2) {
            return 4.35;
        } else if (years <= 5) {
            return 4.75;
        } else {
            return 4.90;
        }
    }

}
