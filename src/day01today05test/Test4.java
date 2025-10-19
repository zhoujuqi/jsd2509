package day01today05test;
import java.util.Scanner;

public class Test4 {
    /**
     * 成绩分级：
     * 题目：编写一个程序，让用户输入一个学生的成绩（0到100之间的整数），然后根据成绩进行分级并输出结果。成绩分级规则如下：
     * 90分及以上：优秀
     * 80分及以上但低于90分：良好
     * 70分及以上但低于80分：一般
     * 60分及以上但低于70分：及格
     * 低于60分：不及格
     * 要求：
     * 使用Scanner类读取用户输入的成绩。
     * 使用if-else语句进行成绩分级。
     * 输出成绩和对应的等级。
     */

    public static void main(String[] args) {
        System.out.println("请输入学生的成绩（0到100之间的整数）：");
        try (Scanner scanner = new Scanner(System.in)) {
            int score = scanner.nextInt();
            String grade;

            if (score >= 90) {
                grade = "优秀";
            } else if (score >= 80) {
                grade = "良好";
            } else if (score >= 70) {
                grade = "一般";
            } else if (score >= 60) {
                grade = "及格";
            } else {
                grade = "不及格";
            }

            System.out.println("成绩：" + score + "，等级：" + grade);
        }
    }

}
