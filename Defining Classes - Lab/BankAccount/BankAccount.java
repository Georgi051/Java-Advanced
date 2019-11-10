package DefiningClassesLab.BankAccount;

public class BankAccount {
    private int id;
    private double balance;
    private static double interestRate = 0.02;
    private static int accountCount = 0;

    public BankAccount(){
        accountCount++;
        this.id = accountCount;
        this.balance = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getInterestRate(int years) {
        return  BankAccount.interestRate * years * this.balance;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }
    public void deposit(double amount){
        this.balance += amount;
    }
}
