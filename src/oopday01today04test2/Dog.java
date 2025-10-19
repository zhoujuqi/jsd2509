package oopday01today04test2;

/**
 * 狗类，继承Animal抽象类
 */
public class Dog extends Animal {
    
    public Dog(String name) {
        super(name);
    }
    
    @Override
    public void eat() {
        System.out.println(name + "正在吃骨头和狗粮");
    }
    
    @Override
    public void drink() {
        System.out.println(name + "正在喝水");
    }
    
    // 狗特有的行为
    public void bark() {
        System.out.println(name + "在汪汪叫");
    }
}
