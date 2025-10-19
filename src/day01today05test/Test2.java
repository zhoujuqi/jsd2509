package day01today05test;

import java.util.Random;
import java.util.Scanner;

public class Test2 {
    /**
     * 查找最大值：
     * 题目：编写一个程序，让用户输入一个整数n，然后生成一个长度为n的随机整数数组（每个元素的值在1到100之间）。最后，找到并输出数组中的最大值。
     * 要求：
     * 使用Scanner类读取用户输入的整数n。
     * 使用Random类生成随机整数数组。
     * 使用for循环遍历数组并找到最大值。
     * 输出数组的所有元素和最大值。
     */
    public static void main(String[] args) {
        System.out.println("此程序是要求输入一个整数n，然后生成一个长度为n的随机整数数组（每个元素的值在1到100之间）。最后，找到并输出数组中的最大值。");
        System.out.println("下面请输入这个所谓的整数n：");
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            // 生成随机整数数组
            Random random = new Random();
            for (int i = 0; i < n; i++) {
                arr[i] = random.nextInt(100) + 1; // 生成1到100之间的随机整数
            }
            // 展示数组元素并找到最大值
            int max = arr[0];
            for (int i = 0; i < arr.length; i++) {
                System.out.println("arr[" + i + "] = " + arr[i]);
                if (arr[i] > max) {
                    max = arr[i];
                }
            }
            System.out.println("数组中的最大值为：" + max);
        }
    }

}
