package oopday01today04test5;

import java.util.Scanner;

/**
 * 图书管理系统：
 * 题目：编写一个图书管理系统，包含以下功能：
 * 定义一个Book类，包含书名、作者、出版社和ISBN。
 * 定义一个Library类，包含图书列表（使用ArrayList），并提供添加图书、删除图书、查询图书信息的方法。
 * 要求：
 * Book类应有构造方法、Getter和Setter方法。
 * Library类应有添加图书、删除图书、查询图书信息的方法。
 * 提供一个简单的命令行界面，允许用户进行添加图书、删除图书和查询图书信息的操作。
 */

public class Test5 {
    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("========== 欢迎使用图书管理系统 ==========");
        
        // 预添加一些测试数据
        initializeTestData();
        
        while (true) {
            displayMenu();
            int choice = getChoice();
            
            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    searchBookByTitle();
                    break;
                case 4:
                    searchBookByAuthor();
                    break;
                case 5:
                    displayAllBooks();
                    break;
                case 6:
                    System.out.println("感谢使用图书管理系统，再见！");
                    return;
                default:
                    System.out.println("无效选择，请重新输入！");
                    break;
            }
            
            System.out.println(); // 空行分隔
        }
    }
    
    // 显示菜单
    private static void displayMenu() {
        System.out.println("==========================================");
        System.out.println("请选择操作：");
        System.out.println("1. 添加图书");
        System.out.println("2. 删除图书");
        System.out.println("3. 按书名查询图书");
        System.out.println("4. 按作者查询图书");
        System.out.println("5. 显示所有图书");
        System.out.println("6. 退出系统");
        System.out.println("==========================================");
        System.out.print("请输入您的选择（1-6）：");
    }
    
    // 获取用户选择
    private static int getChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1; // 返回无效值
        }
    }
    
    // 添加图书
    private static void addBook() {
        System.out.println("----- 添加图书 -----");
        System.out.print("请输入书名：");
        String title = scanner.nextLine();
        
        System.out.print("请输入作者：");
        String author = scanner.nextLine();
        
        System.out.print("请输入出版社：");
        String publisher = scanner.nextLine();
        
        System.out.print("请输入ISBN：");
        String isbn = scanner.nextLine();
        
        Book book = new Book(title, author, publisher, isbn);
        library.addBook(book);
    }
    
    // 删除图书
    private static void removeBook() {
        System.out.println("----- 删除图书 -----");
        System.out.print("请输入要删除图书的ISBN：");
        String isbn = scanner.nextLine();
        library.removeBook(isbn);
    }
    
    // 按书名查询图书
    private static void searchBookByTitle() {
        System.out.println("----- 按书名查询图书 -----");
        System.out.print("请输入书名关键字：");
        String title = scanner.nextLine();
        library.searchBookByTitle(title);
    }
    
    // 按作者查询图书
    private static void searchBookByAuthor() {
        System.out.println("----- 按作者查询图书 -----");
        System.out.print("请输入作者关键字：");
        String author = scanner.nextLine();
        library.searchBookByAuthor(author);
    }
    
    // 显示所有图书
    private static void displayAllBooks() {
        System.out.println("----- 所有图书信息 -----");
        library.displayAllBooks();
        System.out.println("图书总数：" + library.getBookCount() + " 本");
    }
    
    // 初始化测试数据
    private static void initializeTestData() {
        library.addBook(new Book("Java核心技术", "Cay S. Horstmann", "机械工业出版社", "978-7-111-54742-6"));
        library.addBook(new Book("算法导论", "Thomas H. Cormen", "机械工业出版社", "978-7-111-40701-0"));
        library.addBook(new Book("设计模式", "Erich Gamma", "人民邮电出版社", "978-7-115-10862-4"));
        library.addBook(new Book("Spring实战", "Craig Walls", "人民邮电出版社", "978-7-115-41717-9"));
        System.out.println("系统已预加载 " + library.getBookCount() + " 本测试图书\n");
    }
}
