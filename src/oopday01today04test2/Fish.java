package oopday01today04test2;

/**
 * 鱼类，继承Animal抽象类
 */
public class Fish extends Animal {
    
    public Fish(String name) {
        super(name);
    }
    
    @Override
    public void eat() {
        System.out.println(name + "正在吃水草和小虫子");
    }
    
    @Override
    public void drink() {
        System.out.println(name + "通过鳃呼吸，从水中获取氧气");
    }
    
    // 鱼特有的行为
    public void swim() {
        System.out.println(name + "在水中游泳");
    }
}
