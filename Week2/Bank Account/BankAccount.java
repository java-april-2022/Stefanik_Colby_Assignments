public class BankAccount {

    private double checkingBalance;
    private double savingsBalance;
    private static int numOfAccounts;
    private static int totalMoneyStored;

    public BankAccount() { //default values
        this.checkingBalance = 0;
        this.savingsBalance = 0;
        numOfAccounts++;
    }

    public BankAccount(double checkBal, double savBal) {
        this.checkingBalance = checkBal;
        this.savingsBalance = savBal;
        numOfAccounts++;
        totalMoneyStored = totalMoneyStored + checkBal + savBal;
    }

    //Getters
    public double getChecking() {
        return this.checkingBalance;
    }

    public double getSavings() {
        return this.savingsBalance;
    }

    public double getAccountMoney() {
        return this.checkingBalance + this.savingsBalance;
    }
    
    public static int getTotalAccounts() {
        return numOfAccounts;
    }

    public static int getTotalAmount() {
        return totalMoneyStored;
    }

    //Setters
    public void addChecking(double money) {
        this.checkingBalance = this.checkingBalance + money;
        totalMoneyStored = totalMoneyStored + money;
    }

    public void addSavings(double money) {
        this.savingsBalance = this.savingsBalance + money;
        totalMoneyStored = totalMoneyStored + money;
    }

    //Other methods
    public string withdrawChecking(double money) {
        if(this.checkingBalance >= money) {
            this.checkingBalance = this.checkingBalance - money;
            return "Funds withdrawn successfully.";
        } else {
            return "Error! insufficient funds!";
        }
    }

    public string withdrawSavings(double money) {
        if(this.savingsBalance >= money) {
            this.savingsBalance = this.savingsBalance - money;
            return "Funds withdrawn successfully.";
        } else {
            return "Error! insufficient funds!";
        }
    }
}