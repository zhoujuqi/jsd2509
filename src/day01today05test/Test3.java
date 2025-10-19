package day01today05test;

import java.util.Random;
import java.util.Scanner;

public class Test3 {
    /**
     * 数组排序：
     * 题目：编写一个程序，让用户输入一个整数n，然后生成一个长度为n的随机整数数组（每个元素的值在1到100之间）。使用冒泡排序算法对数组进行升序/降序排序，并输出排序后的数组。
     * 要求：
     * 使用Scanner类读取用户输入的整数n。
     * 使用Random类生成随机整数数组。
     * 实现冒泡排序算法对数组进行排序。
     * 输出排序前后的数组。
     */
    public static void main(String[] args) {
        System.out.println("此程序是要求输入一个整数n，然后生成一个长度为n的随机整数数组（每个元素的值在1到100之间）。使用冒泡排序算法对数组进行升序/降序排序，并输出排序后的数组。");
        System.out.println("下面请输入这个所谓的整数n：");
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            // 生成随机整数数组
            Random random = new Random();
            for (int i = 0; i < n; i++) {
                arr[i] = random.nextInt(100) + 1; // 生成1到100之间的随机整数
            }
            // 展示排序前的数组
            System.out.println("排序前的数组：");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            // 冒泡排序升序
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = 0; j < arr.length - 1 - i; j++) {
                    if (arr[j] > arr[j + 1]) {
                        // 交换
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
            System.out.println("升序排序后的数组：");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            // 冒泡排序降序
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = 0; j < arr.length - 1 - i; j++) {
                    if (arr[j] < arr[j + 1]) {
                        // 交换
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
            System.out.println("降序排序后的数组：");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }

            System.out.println();
        }
    }

}
