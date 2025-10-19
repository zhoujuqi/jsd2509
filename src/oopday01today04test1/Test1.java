package oopday01today04test1;

/**
 * 学生管理系统：
 * 题目：编写一个学生管理系统，包含以下功能：
 * 定义一个Student类，包含学生的姓名、年龄、学号和班级。
 * 定义一个Course类，包含课程名称和学分。
 * 定义一个StudentManager类，包含添加学生、删除学生、查询学生信息的方法。
 * 要求：
 * Student类应有构造方法、Getter和Setter方法。
 * Course类应有构造方法、Getter和Setter方法。
 * StudentManager类应有添加学生、删除学生、查询学生信息的方法。
 * 使用集合（如ArrayList）来存储学生信息。
 * 提供一个简单的命令行界面，允许用户进行添加、删除和查询操作。
 */

public class Test1 {
    // 主方法，用于测试
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        manager.showMenu();
    }

}
