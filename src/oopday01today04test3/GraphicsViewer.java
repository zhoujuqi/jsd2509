package oopday01today04test3;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Path2D;
import java.util.ArrayList;

/**
 * 图形可视化展示器，使用Java Swing GUI展示图形并标注参数
 */
public class GraphicsViewer extends JPanel {
    private ArrayList<Shape> shapes;
    private static final int PANEL_WIDTH = 800;
    private static final int PANEL_HEIGHT = 600;
    private static final int MARGIN = 50;
    
    public GraphicsViewer() {
        this.shapes = new ArrayList<>();
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setBackground(Color.WHITE);
    }
    
    /**
     * 添加图形到展示器
     * @param shape 要添加的图形
     */
    public void addShape(Shape shape) {
        shapes.add(shape);
        repaint(); // 重新绘制面板
    }
    
    /**
     * 清空所有图形
     */
    public void clearShapes() {
        shapes.clear();
        repaint();
    }
    
    /**
     * 设置图形列表
     * @param shapes 图形列表
     */
    public void setShapes(ArrayList<Shape> shapes) {
        this.shapes = new ArrayList<>(shapes);
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        // 设置抗锯齿
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        if (shapes.isEmpty()) {
            // 如果没有图形，显示提示信息
            g2d.setColor(Color.GRAY);
            g2d.setFont(new Font("Arial", Font.PLAIN, 16));
            String message = "没有图形可以显示";
            FontMetrics fm = g2d.getFontMetrics();
            int x = (PANEL_WIDTH - fm.stringWidth(message)) / 2;
            int y = PANEL_HEIGHT / 2;
            g2d.drawString(message, x, y);
            return;
        }
        
        // 计算布局参数
        int cols = (int) Math.ceil(Math.sqrt(shapes.size()));
        int rows = (int) Math.ceil((double) shapes.size() / cols);
        int cellWidth = (PANEL_WIDTH - 2 * MARGIN) / cols;
        int cellHeight = (PANEL_HEIGHT - 2 * MARGIN) / rows;
        
        // 绘制每个图形
        for (int i = 0; i < shapes.size(); i++) {
            int row = i / cols;
            int col = i % cols;
            int x = MARGIN + col * cellWidth + cellWidth / 2;
            int y = MARGIN + row * cellHeight + cellHeight / 2;
            
            drawShape(g2d, shapes.get(i), x, y, cellWidth, cellHeight, i + 1);
        }
    }
    
    /**
     * 绘制单个图形
     */
    private void drawShape(Graphics2D g2d, Shape shape, int centerX, int centerY, 
                          int cellWidth, int cellHeight, int shapeNumber) {
        
        // 设置绘制颜色（随机但固定）
        Color shapeColor = generateColor(shapeNumber);
        g2d.setColor(shapeColor);
        g2d.setStroke(new BasicStroke(2));
        
        String paramText = "";
        
        if (shape instanceof Circle) {
            Circle circle = (Circle) shape;
            double radius = circle.getRadius();
            
            // 改进圆形尺寸计算，确保不超出窗口
            int maxRadius = Math.min(cellWidth, cellHeight) / 2 - 50; // 留出边距
            int drawRadius = Math.min(maxRadius, Math.max(30, (int)(radius * 15)));
            drawRadius = Math.max(30, drawRadius); // 最小半径
            
            // 绘制圆形
            Ellipse2D.Double ellipse = new Ellipse2D.Double(
                centerX - drawRadius, centerY - drawRadius, 
                drawRadius * 2, drawRadius * 2
            );
            g2d.draw(ellipse);
            g2d.setColor(new Color(shapeColor.getRed(), shapeColor.getGreen(), 
                                 shapeColor.getBlue(), 50));
            g2d.fill(ellipse);
            
            paramText = String.format("圆形 #%d\n半径: %.1f\n面积: %.2f", 
                                    shapeNumber, radius, Math.PI * radius * radius);
            
        } else if (shape instanceof Rectangle) {
            Rectangle rect = (Rectangle) shape;
            double width = rect.getWidth();
            double height = rect.getHeight();
            
            // 改进矩形尺寸计算，确保不超出窗口
            int maxWidth = cellWidth - 100; // 留出边距
            int maxHeight = cellHeight - 100; // 留出边距
            
            // 根据矩形的比例计算绘制尺寸
            double aspectRatio = width / height;
            int drawWidth, drawHeight;
            
            if (aspectRatio > 1) {
                // 宽度更大，以宽度为准
                drawWidth = Math.min(maxWidth, Math.max(50, (int)(width * 15)));
                drawHeight = (int)(drawWidth / aspectRatio);
                if (drawHeight > maxHeight) {
                    drawHeight = maxHeight;
                    drawWidth = (int)(drawHeight * aspectRatio);
                }
            } else {
                // 高度更大，以高度为准
                drawHeight = Math.min(maxHeight, Math.max(40, (int)(height * 15)));
                drawWidth = (int)(drawHeight * aspectRatio);
                if (drawWidth > maxWidth) {
                    drawWidth = maxWidth;
                    drawHeight = (int)(drawWidth / aspectRatio);
                }
            }
            
            // 确保最小尺寸
            drawWidth = Math.max(50, drawWidth);
            drawHeight = Math.max(40, drawHeight);
            
            // 绘制矩形
            Rectangle2D.Double rectangle = new Rectangle2D.Double(
                centerX - drawWidth / 2, centerY - drawHeight / 2, 
                drawWidth, drawHeight
            );
            g2d.draw(rectangle);
            g2d.setColor(new Color(shapeColor.getRed(), shapeColor.getGreen(), 
                                 shapeColor.getBlue(), 50));
            g2d.fill(rectangle);
            
            paramText = String.format("矩形 #%d\n宽度: %.1f\n高度: %.1f\n面积: %.2f", 
                                    shapeNumber, width, height, width * height);
            
        } else if (shape instanceof Triangle) {
            Triangle triangle = (Triangle) shape;
            double base = triangle.getBase();
            double triangleHeight = triangle.getHeight();
            
            // 重新设计三角形尺寸计算，确保不超出窗口
            int maxWidth = cellWidth - 100; // 留出边距
            int maxHeight = cellHeight - 100; // 留出边距
            
            // 根据三角形的比例计算绘制尺寸
            double aspectRatio = base / triangleHeight;
            int drawTriangleHeight, drawBase;
            
            if (aspectRatio > 1) {
                // 宽度更大，以宽度为准
                drawBase = Math.min(maxWidth, Math.max(60, (int)(base * 20)));
                drawTriangleHeight = (int)(drawBase / aspectRatio);
                if (drawTriangleHeight > maxHeight) {
                    drawTriangleHeight = maxHeight;
                    drawBase = (int)(drawTriangleHeight * aspectRatio);
                }
            } else {
                // 高度更大，以高度为准
                drawTriangleHeight = Math.min(maxHeight, Math.max(40, (int)(triangleHeight * 20)));
                drawBase = (int)(drawTriangleHeight * aspectRatio);
                if (drawBase > maxWidth) {
                    drawBase = maxWidth;
                    drawTriangleHeight = (int)(drawBase / aspectRatio);
                }
            }
            
            // 确保最小尺寸
            drawBase = Math.max(60, drawBase);
            drawTriangleHeight = Math.max(40, drawTriangleHeight);
            
            // 绘制三角形
            Path2D.Double trianglePath = new Path2D.Double();
            trianglePath.moveTo(centerX, centerY - drawTriangleHeight / 2); // 顶点
            trianglePath.lineTo(centerX - drawBase / 2, centerY + drawTriangleHeight / 2); // 左下
            trianglePath.lineTo(centerX + drawBase / 2, centerY + drawTriangleHeight / 2); // 右下
            trianglePath.closePath();
            
            g2d.draw(trianglePath);
            g2d.setColor(new Color(shapeColor.getRed(), shapeColor.getGreen(), 
                                 shapeColor.getBlue(), 50));
            g2d.fill(trianglePath);
            
            paramText = String.format("三角形 #%d\n底边: %.1f\n高度: %.1f\n面积: %.2f", 
                                    shapeNumber, base, triangleHeight, 0.5 * base * triangleHeight);
        }
        
        // 绘制参数标注
        drawParameterText(g2d, paramText, centerX, centerY - cellHeight / 2 + 15);
    }
    
    /**
     * 绘制参数文本
     */
    private void drawParameterText(Graphics2D g2d, String text, int x, int y) {
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Microsoft YaHei", Font.BOLD, 16)); // 增大字体并加粗
        
        String[] lines = text.split("\n");
        FontMetrics fm = g2d.getFontMetrics();
        
        for (int i = 0; i < lines.length; i++) {
            int textWidth = fm.stringWidth(lines[i]);
            int textX = x - textWidth / 2;
            int textY = y + i * (fm.getHeight() + 4); // 增加行间距
            
            // 绘制文本背景
            g2d.setColor(new Color(255, 255, 255, 220));
            g2d.fillRect(textX - 4, textY - fm.getAscent(), textWidth + 8, fm.getHeight());
            
            // 绘制文本边框
            g2d.setColor(new Color(200, 200, 200));
            g2d.drawRect(textX - 4, textY - fm.getAscent(), textWidth + 8, fm.getHeight());
            
            // 绘制文本
            g2d.setColor(Color.BLACK);
            g2d.drawString(lines[i], textX, textY);
        }
    }
    
    /**
     * 根据图形编号生成固定的颜色
     */
    private Color generateColor(int shapeNumber) {
        Color[] colors = {
            new Color(255, 99, 99),   // 红色
            new Color(99, 150, 255),  // 蓝色
            new Color(99, 255, 99),   // 绿色
            new Color(255, 200, 99),  // 橙色
            new Color(255, 99, 255),  // 紫色
            new Color(99, 255, 255),  // 青色
            new Color(255, 255, 99),  // 黄色
            new Color(150, 150, 150)  // 灰色
        };
        return colors[(shapeNumber - 1) % colors.length];
    }
    
    /**
     * 创建并显示多个图形查看器窗口（每个图形一个窗口）
     */
    public static void showGraphicsWindow(ArrayList<Shape> shapes) {
        if (shapes.isEmpty()) {
            System.out.println("没有图形可以显示");
            return;
        }
        
        final Object windowClosedLock = new Object();
        final int[] closedWindowCount = {0};
        final int totalWindows = shapes.size();
        
        System.out.println("正在打开 " + totalWindows + " 个图形展示窗口...");
        
        SwingUtilities.invokeLater(() -> {
            for (int i = 0; i < shapes.size(); i++) {
                final int shapeIndex = i;
                Shape shape = shapes.get(i);
                
                JFrame frame = new JFrame("图形 " + (i + 1) + " - " + getShapeTypeName(shape));
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                
                // 创建只包含单个图形的列表
                ArrayList<Shape> singleShapeList = new ArrayList<>();
                singleShapeList.add(shape);
                
                GraphicsViewer viewer = new GraphicsViewer();
                viewer.setShapes(singleShapeList);
                
                // 添加窗口关闭监听器
                frame.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosed(java.awt.event.WindowEvent e) {
                        synchronized (windowClosedLock) {
                            closedWindowCount[0]++;
                            System.out.println("图形窗口 " + (shapeIndex + 1) + " 已关闭 (" + 
                                             closedWindowCount[0] + "/" + totalWindows + ")");
                            
                            if (closedWindowCount[0] == totalWindows) {
                                windowClosedLock.notify(); // 所有窗口都关闭时通知主线程
                                System.out.println("所有图形窗口已关闭，返回控制台操作");
                            }
                        }
                    }
                });
                
                frame.add(viewer);
                frame.pack();
                
                // 设置窗口位置，避免重叠
                int offsetX = (i % 3) * 320; // 水平偏移
                int offsetY = (i / 3) * 240; // 垂直偏移
                frame.setLocation(100 + offsetX, 100 + offsetY);
                
                frame.setVisible(true);
            }
        });
        
        System.out.println("所有图形窗口已打开，关闭所有窗口后将返回控制台菜单");
        
        // 等待所有窗口关闭
        synchronized (windowClosedLock) {
            while (closedWindowCount[0] < totalWindows) {
                try {
                    windowClosedLock.wait(); // 等待所有窗口关闭的通知
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }
    
    /**
     * 获取图形类型名称
     */
    private static String getShapeTypeName(Shape shape) {
        if (shape instanceof Circle) {
            return "圆形";
        } else if (shape instanceof Rectangle) {
            return "矩形";
        } else if (shape instanceof Triangle) {
            return "三角形";
        }
        return "未知图形";
    }
}