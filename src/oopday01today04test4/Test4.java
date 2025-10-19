package oopday01today04test4;

import java.util.Scanner;

/**
 * 银行账户系统：
 * 题目：编写一个银行账户系统，包含以下功能：
 * 定义一个Account类，包含账户号、余额和户主姓名。
 * 定义一个Bank类，包含账户列表（使用ArrayList），并提供开户、存款、取款和查询余额的方法。
 * 要求：
 * Account类应有构造方法、Getter和Setter方法。
 * Bank类应有开户、存款、取款和查询余额的方法。
 * 提供一个简单的命令行界面，允许用户进行开户、存款、取款和查询余额的操作。
 */

public class Test4 {
    private static Bank bank = new Bank();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("=== 银行账户管理系统 ===");
        
        boolean running = true;
        while (running) {
            showMenu();
            int choice = getChoice();
            
            switch (choice) {
                case 1:
                    openAccount();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    queryBalance();
                    break;
                case 5:
                    showAllAccounts();
                    break;
                case 0:
                    running = false;
                    System.out.println("感谢使用银行账户管理系统，再见！");
                    break;
                default:
                    System.out.println("无效选择，请重新输入！");
            }
            
            if (running) {
                System.out.println("\n按回车键继续...");
                scanner.nextLine();
            }
        }
        
        scanner.close();
    }
    
    // 显示菜单
    private static void showMenu() {
        System.out.println("\n请选择操作：");
        System.out.println("1. 开户");
        System.out.println("2. 存款");
        System.out.println("3. 取款");
        System.out.println("4. 查询余额");
        System.out.println("5. 显示所有账户");
        System.out.println("0. 退出");
        System.out.print("请输入选择: ");
    }
    
    // 获取用户选择
    private static int getChoice() {
        try {
            int choice = scanner.nextInt();
            scanner.nextLine(); // 消费换行符
            return choice;
        } catch (Exception e) {
            scanner.nextLine(); // 清除错误输入
            return -1;
        }
    }
    
    // 开户操作
    private static void openAccount() {
        System.out.println("\n=== 开户 ===");
        System.out.print("请输入户主姓名: ");
        String accountHolder = scanner.nextLine();
        
        if (accountHolder.trim().isEmpty()) {
            System.out.println("户主姓名不能为空！");
            return;
        }
        
        System.out.print("请输入初始存款金额（直接回车则为0）: ");
        String amountStr = scanner.nextLine();
        
        String accountNumber;
        if (amountStr.trim().isEmpty()) {
            accountNumber = bank.openAccount(accountHolder);
        } else {
            try {
                double initialAmount = Double.parseDouble(amountStr);
                if (initialAmount < 0) {
                    System.out.println("初始存款金额不能为负数！");
                    return;
                }
                accountNumber = bank.openAccount(accountHolder, initialAmount);
            } catch (NumberFormatException e) {
                System.out.println("金额格式错误！");
                return;
            }
        }
        
        System.out.println("开户成功！您的账户号是: " + accountNumber);
    }
    
    // 存款操作
    private static void deposit() {
        System.out.println("\n=== 存款 ===");
        System.out.print("请输入账户号: ");
        String accountNumber = scanner.nextLine();
        
        if (!bank.accountExists(accountNumber)) {
            System.out.println("账户不存在！");
            return;
        }
        
        System.out.print("请输入存款金额: ");
        try {
            double amount = Double.parseDouble(scanner.nextLine());
            if (amount <= 0) {
                System.out.println("存款金额必须大于0！");
                return;
            }
            
            if (bank.deposit(accountNumber, amount)) {
                System.out.println("存款成功！当前余额: " + bank.getBalance(accountNumber));
            } else {
                System.out.println("存款失败！");
            }
        } catch (NumberFormatException e) {
            System.out.println("金额格式错误！");
        }
    }
    
    // 取款操作
    private static void withdraw() {
        System.out.println("\n=== 取款 ===");
        System.out.print("请输入账户号: ");
        String accountNumber = scanner.nextLine();
        
        if (!bank.accountExists(accountNumber)) {
            System.out.println("账户不存在！");
            return;
        }
        
        System.out.println("当前余额: " + bank.getBalance(accountNumber));
        System.out.print("请输入取款金额: ");
        try {
            double amount = Double.parseDouble(scanner.nextLine());
            if (amount <= 0) {
                System.out.println("取款金额必须大于0！");
                return;
            }
            
            if (bank.withdraw(accountNumber, amount)) {
                System.out.println("取款成功！当前余额: " + bank.getBalance(accountNumber));
            } else {
                System.out.println("取款失败！余额不足或金额无效！");
            }
        } catch (NumberFormatException e) {
            System.out.println("金额格式错误！");
        }
    }
    
    // 查询余额操作
    private static void queryBalance() {
        System.out.println("\n=== 查询余额 ===");
        System.out.print("请输入账户号: ");
        String accountNumber = scanner.nextLine();
        
        Account account = bank.getAccount(accountNumber);
        if (account != null) {
            System.out.println(account);
        } else {
            System.out.println("账户不存在！");
        }
    }
    
    // 显示所有账户
    private static void showAllAccounts() {
        System.out.println("\n=== 所有账户信息 ===");
        if (bank.getAllAccounts().isEmpty()) {
            System.out.println("暂无账户信息！");
        } else {
            for (Account account : bank.getAllAccounts()) {
                System.out.println(account);
            }
        }
    }
}
