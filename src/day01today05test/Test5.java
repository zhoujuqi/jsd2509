package day01today05test;

import java.util.Scanner;
import java.util.Random;

public class Test5 {
    /**
     * 猜数字游戏：
     * 题目：编写一个程序，让系统随机生成一个1到100之间的整数，用户通过控制台输入猜测的数字，程序会提示用户猜大了、猜小了或猜对了。用户可以多次猜测，直到猜对为止。
     * 要求：
     * 使用Random类生成一个1到100之间的随机整数。
     * 使用Scanner类读取用户输入的猜测数字。
     * 使用while循环让用户多次猜测，直到猜对为止。
     * 提示用户猜大了、猜小了或猜对了。
     */

    public static void main(String[] args) {
        System.out.println("此程序是一个猜数字游戏，系统会随机生成一个1到100之间的整数，您需要通过控制台输入猜测的数字，程序会提示您猜大了、猜小了或猜对了。");
        System.out.println("请开始您的第一次猜测：");
        try (Scanner scanner = new Scanner(System.in)) {
            Random random = new Random();
            int targetNumber = random.nextInt(100) + 1; // 生成1到100之间的随机整数
            int guess = 0;

            while (guess != targetNumber) {
                guess = scanner.nextInt();
                if (guess < targetNumber) {
                    System.out.println("猜小了，请再试一次：");
                } else if (guess > targetNumber) {
                    System.out.println("猜大了，请再试一次：");
                } else {
                    System.out.println("恭喜您，猜对了！");
                }
            }
        }
    }
}