package oopday01today04test2;

/**
 * 猫类，继承Animal抽象类
 */
public class Cat extends Animal {
    
    public Cat(String name) {
        super(name);
    }
    
    @Override
    public void eat() {
        System.out.println(name + "正在吃鱼和猫粮");
    }
    
    @Override
    public void drink() {
        System.out.println(name + "正在喝牛奶");
    }
    
    // 猫特有的行为
    public void meow() {
        System.out.println(name + "在喵喵叫");
    }
}
