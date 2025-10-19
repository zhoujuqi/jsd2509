package oopday01today04test1;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    private List<Student> students = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // 添加学生
    public boolean addStudent(Student student) {
        if (student != null) {
            students.add(student);
            System.out.println("学生添加成功：" + student.getName());
            return true;
        } else {
            System.out.println("添加失败：学生信息不能为空");
            return false;
        }
    }

    // 删除学生（通过学号）
    public boolean removeStudentById(String studentId) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId().equals(studentId)) {
                Student removedStudent = students.remove(i);
                System.out.println("学生删除成功：" + removedStudent.getName());
                return true;
            }
        }
        System.out.println("未找到学号为 " + studentId + " 的学生");
        return false;
    }

    // 删除学生（通过学生对象）
    public boolean removeStudent(Student student) {
        if (students.remove(student)) {
            System.out.println("学生删除成功：" + student.getName());
            return true;
        } else {
            System.out.println("未找到该学生");
            return false;
        }
    }

    // 根据学号查询学生
    public Student findStudentById(String studentId) {
        if (studentId == null || studentId.trim().isEmpty()) {
            return null; // 查询条件无效
        }
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    // 根据姓名查询学生
    public List<Student> findStudentsByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return null; // 查询条件无效
        }
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().contains(name)) {
                result.add(student);
            }
        }
        return result.isEmpty() ? null : result; // 没找到返回null
    }

    // 根据班级查询学生
    public List<Student> findStudentsByClass(String className) {
        if (className == null || className.trim().isEmpty()) {
            return null; // 查询条件无效
        }
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getClassName().equals(className)) {
                result.add(student);
            }
        }
        return result.isEmpty() ? null : result; // 没找到返回null
    }

    // 显示所有学生信息
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("暂无学生信息");
            return;
        }

        System.out.println("====== 所有学生信息 ======");
        for (Student student : students) {
            displayStudentInfo(student);
            System.out.println("------------------------");
        }
    }

    // 显示单个学生信息
    public void displayStudentInfo(Student student) {
        System.out.println("姓名：" + student.getName());
        System.out.println("年龄：" + student.getAge());
        System.out.println("学号：" + student.getStudentId());
        System.out.println("班级：" + student.getClassName());
    }

    // 获取学生列表（返回副本）
    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }

    // 获取学生总数
    public int getStudentCount() {
        return students.size();
    }

    // 检查学号是否已存在
    public boolean isStudentIdExists(String studentId) {
        return findStudentById(studentId) != null;
    }

    // 命令行界面
    public void showMenu() {
        while (true) {
            System.out.println("\n====== 学生管理系统 ======");
            System.out.println("1. 添加学生");
            System.out.println("2. 删除学生");
            System.out.println("3. 查询学生");
            System.out.println("4. 显示所有学生");
            System.out.println("5. 退出系统");
            System.out.print("请选择操作（1-5）：");

            int choice = scanner.nextInt();
            scanner.nextLine(); // 消费换行符

            switch (choice) {
                case 1:
                    addStudentFromInput();
                    break;
                case 2:
                    deleteStudentFromInput();
                    break;
                case 3:
                    queryStudentFromInput();
                    break;
                case 4:
                    displayAllStudents();
                    break;
                case 5:
                    System.out.println("退出系统，谢谢使用！");
                    return;
                default:
                    System.out.println("无效选择，请重新输入！");
            }
        }
    }

    // 从控制台输入添加学生
    private void addStudentFromInput() {
        System.out.println("\n====== 添加学生 ======");
        
        // 输入姓名
        String name;
        while (true) {
            System.out.print("请输入学生姓名：");
            name = scanner.nextLine().trim();
            if (!name.isEmpty()) {
                break;
            }
            System.out.println("姓名不能为空，请重新输入！");
        }

        // 输入年龄
        int age;
        while (true) {
            try {
                System.out.print("请输入学生年龄：");
                age = scanner.nextInt();
                scanner.nextLine(); // 消费换行符
                if (age > 0 && age < 150) {
                    break;
                }
                System.out.println("年龄必须在1-149之间，请重新输入！");
            } catch (Exception e) {
                System.out.println("请输入有效的数字！");
                scanner.nextLine(); // 清除无效输入
            }
        }

        // 输入学号
        String studentId;
        while (true) {
            System.out.print("请输入学号：");
            studentId = scanner.nextLine().trim();
            if (studentId.isEmpty()) {
                System.out.println("学号不能为空，请重新输入！");
                continue;
            }
            if (isStudentIdExists(studentId)) {
                System.out.println("学号已存在，请重新输入！");
                continue;
            }
            break;
        }

        // 输入班级
        String className;
        while (true) {
            System.out.print("请输入班级：");
            className = scanner.nextLine().trim();
            if (!className.isEmpty()) {
                break;
            }
            System.out.println("班级不能为空，请重新输入！");
        }

        // 创建学生对象并添加
        Student student = new Student(name, age, studentId, className);
        if (!addStudent(student)) {
            System.out.println("添加学生失败！");
        }
    }

    // 从控制台输入删除学生
    private void deleteStudentFromInput() {
        System.out.println("\n====== 删除学生 ======");
        System.out.print("请输入要删除的学生学号：");
        String studentId = scanner.nextLine();
        removeStudentById(studentId);
    }

    // 从控制台输入查询学生
    private void queryStudentFromInput() {
        System.out.println("\n====== 查询学生 ======");
        System.out.println("1. 按学号查询");
        System.out.println("2. 按姓名查询");
        System.out.println("3. 按班级查询");
        System.out.print("请选择查询方式（1-3）：");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("请输入学号：");
                String studentId = scanner.nextLine();
                Student student = findStudentById(studentId);
                if (student != null) {
                    System.out.println("找到学生信息：");
                    displayStudentInfo(student);
                } else {
                    System.out.println("未找到该学生");
                }
                break;
            case 2:
                System.out.print("请输入姓名（支持模糊查询）：");
                String name = scanner.nextLine();
                List<Student> studentsByName = findStudentsByName(name);
                if (studentsByName != null && !studentsByName.isEmpty()) {
                    System.out.println("找到 " + studentsByName.size() + " 个学生：");
                    for (Student s : studentsByName) {
                        displayStudentInfo(s);
                        System.out.println("------------------------");
                    }
                } else {
                    System.out.println("未找到相关学生");
                }
                break;
            case 3:
                System.out.print("请输入班级：");
                String className = scanner.nextLine();
                List<Student> studentsByClass = findStudentsByClass(className);
                if (studentsByClass != null && !studentsByClass.isEmpty()) {
                    System.out.println("找到 " + studentsByClass.size() + " 个学生：");
                    for (Student s : studentsByClass) {
                        displayStudentInfo(s);
                        System.out.println("------------------------");
                    }
                } else {
                    System.out.println("未找到该班级的学生");
                }
                break;
            default:
                System.out.println("无效选择");
        }
    }

}
