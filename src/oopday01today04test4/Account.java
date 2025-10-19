package oopday01today04test4;

public class Account {
    private String accountNumber;  // 账户号
    private double balance;        // 余额
    private String accountHolder;  // 户主姓名
    
    // 构造方法
    public Account(String accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0.0;  // 初始余额为0
    }
    
    public Account(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }
    
    // Getter方法
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public String getAccountHolder() {
        return accountHolder;
    }
    
    // Setter方法
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }
    
    // 存款方法
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }
    
    // 取款方法
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "账户号: " + accountNumber + ", 户主: " + accountHolder + ", 余额: " + balance;
    }
}
