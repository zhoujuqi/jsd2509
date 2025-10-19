package oopday01today04test3;

import java.util.ArrayList;

/**
 * 绘图板类，管理多个图形
 */
public class DrawingBoard {
    private ArrayList<Shape> shapes;
    
    public DrawingBoard() {
        shapes = new ArrayList<>();
    }
    
    /**
     * 添加形状到绘图板
     * @param shape 要添加的形状
     */
    public void addShape(Shape shape) {
        shapes.add(shape);
        System.out.println("形状已添加到绘图板");
    }
    

    
    /**
     * 获取形状数量
     * @return 形状数量
     */
    public int getShapeCount() {
        return shapes.size();
    }
    
    /**
     * 获取所有形状的列表
     * @return 形状列表的副本
     */
    public ArrayList<Shape> getShapes() {
        return new ArrayList<>(shapes);
    }
    
    /**
     * 使用GUI展示所有图形
     */
    public void showGraphicsGUI() {
        if (shapes.isEmpty()) {
            System.out.println("绘图板上没有形状可以展示，请先添加图形");
            return;
        }
        GraphicsViewer.showGraphicsWindow(getShapes());
    }
    
    /**
     * 在控制台以表格形式显示所有图形信息
     */
    public void showShapesList() {
        if (shapes.isEmpty()) {
            System.out.println("绘图板上没有图形");
            return;
        }
        
        System.out.println("\n" + "=".repeat(80));
        System.out.println("                              图形列表                              ");
        System.out.println("=".repeat(80));
        
        // 重新设计表格结构，统一显示格式
        System.out.println("编号\t类型\t\t参数信息\t\t\t面积");
        System.out.println("----\t----\t\t--------\t\t\t----");
        
        for (int i = 0; i < shapes.size(); i++) {
            Shape shape = shapes.get(i);
            String type = "";
            String paramInfo = "";
            double area = 0;
            
            if (shape instanceof Circle) {
                Circle circle = (Circle) shape;
                type = "圆形";
                paramInfo = "半径: " + String.format("%.1f", circle.getRadius());
                area = Math.PI * circle.getRadius() * circle.getRadius();
            } else if (shape instanceof Rectangle) {
                Rectangle rect = (Rectangle) shape;
                type = "矩形";
                paramInfo = "宽: " + String.format("%.1f", rect.getWidth()) + 
                           ", 高: " + String.format("%.1f", rect.getHeight());
                area = rect.getWidth() * rect.getHeight();
            } else if (shape instanceof Triangle) {
                Triangle triangle = (Triangle) shape;
                type = "三角形";
                paramInfo = "底: " + String.format("%.1f", triangle.getBase()) + 
                           ", 高: " + String.format("%.1f", triangle.getHeight());
                area = 0.5 * triangle.getBase() * triangle.getHeight();
            }
            
            // 使用固定宽度格式化，简单直接
            System.out.printf("%d\t%s\t\t%-24s\t%.2f%n", 
                             (i + 1), type, paramInfo, area);
        }
        
        System.out.println("=".repeat(80));
        
        // 计算总面积
        double totalArea = 0;
        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                Circle circle = (Circle) shape;
                totalArea += Math.PI * circle.getRadius() * circle.getRadius();
            } else if (shape instanceof Rectangle) {
                Rectangle rect = (Rectangle) shape;
                totalArea += rect.getWidth() * rect.getHeight();
            } else if (shape instanceof Triangle) {
                Triangle triangle = (Triangle) shape;
                totalArea += 0.5 * triangle.getBase() * triangle.getHeight();
            }
        }
        
        System.out.printf("总计图形数量: %d\t\t\t\t\t所有图形总面积: %.2f%n", 
                         shapes.size(), totalArea);
        System.out.println("=".repeat(80) + "\n");
    }
}
