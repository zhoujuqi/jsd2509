package oopday01today04test3;

import java.util.Scanner;

/**
 * 图形绘制：
 * 题目：编写一个程序，模拟绘制不同的图形。定义一个Shape接口，包含方法draw()。然后定义几个具体的图形类（如Circle、Rectangle、Triangle），并实现draw()方法。
 * 要求：
 * Shape接口应包含方法draw()。
 * Circle、Rectangle和Triangle类应实现Shape接口，并在draw()方法中输出相应的图形信息。
 * 创建一个DrawingBoard类，包含一个形状列表（使用ArrayList），并提供添加形状、显示所有形状信息的方法。
 * 提供一个简单的命令行界面，允许用户添加形状并显示所有形状的信息。
 */
public class Test3 {
    
    public static void main(String[] args) {
        DrawingBoard drawingBoard = new DrawingBoard();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== 欢迎使用图形绘制系统 ===");
        
        while (true) {
            System.out.println("\n请选择操作：");
            System.out.println("1. 添加圆形");
            System.out.println("2. 添加矩形");
            System.out.println("3. 添加三角形");
            System.out.println("4. 查看图形列表");
            System.out.println("5. GUI可视化展示图形");
            System.out.println("6. 退出程序");
            System.out.print("请输入选择 (1-6): ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("请输入圆形半径: ");
                    double radius = scanner.nextDouble();
                    Circle circle = new Circle(radius);
                    drawingBoard.addShape(circle);
                    break;
                    
                case 2:
                    System.out.print("请输入矩形宽度: ");
                    double width = scanner.nextDouble();
                    System.out.print("请输入矩形高度: ");
                    double height = scanner.nextDouble();
                    Rectangle rectangle = new Rectangle(width, height);
                    drawingBoard.addShape(rectangle);
                    break;
                    
                case 3:
                    System.out.print("请输入三角形底边长度: ");
                    double base = scanner.nextDouble();
                    System.out.print("请输入三角形高度: ");
                    double triangleHeight = scanner.nextDouble();
                    Triangle triangle = new Triangle(base, triangleHeight);
                    drawingBoard.addShape(triangle);
                    break;
                    
                case 4:
                    drawingBoard.showShapesList();
                    break;
                    
                case 5:
                    drawingBoard.showGraphicsGUI();
                    break;
                    
                case 6:
                    System.out.println("感谢使用图形绘制系统，再见！");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("无效选择，请输入 1-6 之间的数字");
            }
        }
    }
}
