package oopday01today04test4;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts;  // 账户列表
    private int nextAccountNumber;        // 用于生成账户号
    
    // 构造方法
    public Bank() {
        this.accounts = new ArrayList<>();
        this.nextAccountNumber = 1001;  // 起始账户号
    }
    
    // 开户方法
    public String openAccount(String accountHolder) {
        String accountNumber = String.valueOf(nextAccountNumber++);
        Account newAccount = new Account(accountNumber, accountHolder);
        accounts.add(newAccount);
        return accountNumber;
    }
    
    // 开户方法（带初始余额）
    public String openAccount(String accountHolder, double initialBalance) {
        String accountNumber = String.valueOf(nextAccountNumber++);
        Account newAccount = new Account(accountNumber, accountHolder, initialBalance);
        accounts.add(newAccount);
        return accountNumber;
    }
    
    // 根据账户号查找账户
    private Account findAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
    
    // 存款方法
    public boolean deposit(String accountNumber, double amount) {
        Account account = findAccount(accountNumber);
        if (account != null && amount > 0) {
            account.deposit(amount);
            return true;
        }
        return false;
    }
    
    // 取款方法
    public boolean withdraw(String accountNumber, double amount) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            return account.withdraw(amount);
        }
        return false;
    }
    
    // 查询余额方法
    public double getBalance(String accountNumber) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            return account.getBalance();
        }
        return -1;  // 账户不存在返回-1
    }
    
    // 获取账户信息
    public Account getAccount(String accountNumber) {
        return findAccount(accountNumber);
    }
    
    // 获取所有账户
    public ArrayList<Account> getAllAccounts() {
        return accounts;
    }
    
    // 检查账户是否存在
    public boolean accountExists(String accountNumber) {
        return findAccount(accountNumber) != null;
    }
}
