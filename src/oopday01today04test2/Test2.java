package oopday01today04test2;

import java.util.Scanner;

/**
 * 动物行为模拟：
 * 题目：编写一个程序，模拟不同动物的行为。定义一个Animal抽象类，包含抽象方法eat()和drink()。然后定义几个具体的动物类（如Dog、Cat、Fish），并实现这些方法。
 * 要求：
 * Animal类应是抽象类，包含抽象方法eat()和drink()。
 * Dog、Cat和Fish类应继承Animal类，并实现eat()和drink()方法。
 * 创建一个Zoo类，包含一个动物列表（使用ArrayList），并提供添加动物、显示所有动物信息的方法。
 * 提供一个简单的命令行界面，允许用户添加动物并显示所有动物的信息。
 */

public class Test2 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Zoo zoo = new Zoo();
        
        System.out.println("欢迎来到动物园管理系统!");
        
        while (true) {
            displayMenu();
            System.out.print("请选择操作: ");
            
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // 消费换行符
                
                switch (choice) {
                    case 1:
                        addAnimal(scanner, zoo);
                        break;
                    case 2:
                        zoo.displayAllAnimals();
                        break;
                    case 3:
                        System.out.println("当前动物园共有 " + zoo.getAnimalCount() + " 只动物");
                        break;
                    case 4:
                        demonstrateAnimals(zoo);
                        break;
                    case 0:
                        System.out.println("谢谢使用动物园管理系统，再见!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("无效的选择，请重新输入!");
                }
            } catch (Exception e) {
                System.out.println("输入格式错误，请输入数字!");
                scanner.nextLine(); // 清除错误输入
            }
            
            System.out.println("\n按回车键继续...");
            scanner.nextLine();
        }
    }
    
    /**
     * 显示菜单
     */
    private static void displayMenu() {
        System.out.println("\n====== 动物园管理系统 ======");
        System.out.println("1. 添加动物");
        System.out.println("2. 显示所有动物信息");
        System.out.println("3. 查看动物数量");
        System.out.println("4. 演示动物特有行为");
        System.out.println("0. 退出系统");
        System.out.println("==========================");
    }
    
    /**
     * 添加动物
     */
    private static void addAnimal(Scanner scanner, Zoo zoo) {
        System.out.println("\n选择要添加的动物类型:");
        System.out.println("1. 狗 (Dog)");
        System.out.println("2. 猫 (Cat)");
        System.out.println("3. 鱼 (Fish)");
        System.out.print("请选择: ");
        
        try {
            int animalType = scanner.nextInt();
            scanner.nextLine(); // 消费换行符
            
            System.out.print("请输入动物的名字: ");
            String name = scanner.nextLine().trim();
            
            if (name.isEmpty()) {
                System.out.println("动物名字不能为空!");
                return;
            }
            
            Animal animal = null;
            switch (animalType) {
                case 1:
                    animal = new Dog(name);
                    break;
                case 2:
                    animal = new Cat(name);
                    break;
                case 3:
                    animal = new Fish(name);
                    break;
                default:
                    System.out.println("无效的动物类型!");
                    return;
            }
            
            zoo.addAnimal(animal);
            
        } catch (Exception e) {
            System.out.println("输入格式错误!");
            scanner.nextLine(); // 清除错误输入
        }
    }
    
    /**
     * 演示动物特有行为
     */
    private static void demonstrateAnimals(Zoo zoo) {
        if (zoo.getAnimalCount() == 0) {
            System.out.println("动物园里还没有动物，请先添加动物!");
            return;
        }
        
        System.out.println("\n==== 动物特有行为演示 ====");
        for (int i = 0; i < zoo.getAnimalCount(); i++) {
            Animal animal = zoo.getAnimal(i);
            System.out.println("\n" + animal.getName() + "的特有行为:");
            
            if (animal instanceof Dog) {
                ((Dog) animal).bark();
            } else if (animal instanceof Cat) {
                ((Cat) animal).meow();
            } else if (animal instanceof Fish) {
                ((Fish) animal).swim();
            }
        }
        System.out.println("========================");
    }
}
