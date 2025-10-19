package oopday01today04test2;

/**
 * 动物抽象类
 * 包含抽象方法eat()和drink()
 */
public abstract class Animal {
    protected String name;
    
    public Animal(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    // 抽象方法：吃
    public abstract void eat();
    
    // 抽象方法：喝
    public abstract void drink();
    
    // 显示动物信息
    public void displayInfo() {
        System.out.println("动物名字: " + name);
        eat();
        drink();
    }
}
