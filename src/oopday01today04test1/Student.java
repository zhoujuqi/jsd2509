package oopday01today04test1;

public class Student {
    private String name;
    private int age;
    private String studentId;
    private String className;

    public Student(String name, int age, String studentId, String className) {
        this.name = name;
        this.age = age;
        this.studentId = studentId;
        this.className = className;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + ", studentId='" + studentId + "', className='" + className
                + "'}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Student student = (Student) obj;
        return studentId != null ? studentId.equals(student.studentId) : student.studentId == null;
    }

    @Override
    public int hashCode() {
        return studentId != null ? studentId.hashCode() : 0;
    }
}
