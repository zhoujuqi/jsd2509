package oopday01today04test2;

import java.util.ArrayList;
import java.util.List;

/**
 * 动物园类，管理动物列表
 */
public class Zoo {
    private List<Animal> animals;
    
    public Zoo() {
        this.animals = new ArrayList<>();
    }
    
    /**
     * 添加动物到动物园
     * @param animal 要添加的动物
     */
    public void addAnimal(Animal animal) {
        animals.add(animal);
        System.out.println("成功添加动物: " + animal.getName());
    }
    
    /**
     * 显示所有动物的信息
     */
    public void displayAllAnimals() {
        if (animals.isEmpty()) {
            System.out.println("动物园里暂时没有动物");
            return;
        }
        
        System.out.println("\n==== 动物园里的所有动物 ====");
        for (int i = 0; i < animals.size(); i++) {
            System.out.println("\n第" + (i + 1) + "只动物:");
            animals.get(i).displayInfo();
        }
        System.out.println("========================");
    }
    
    /**
     * 获取动物数量
     * @return 动物数量
     */
    public int getAnimalCount() {
        return animals.size();
    }
    
    /**
     * 根据索引获取动物
     * @param index 索引
     * @return 动物对象
     */
    public Animal getAnimal(int index) {
        if (index >= 0 && index < animals.size()) {
            return animals.get(index);
        }
        return null;
    }
}
