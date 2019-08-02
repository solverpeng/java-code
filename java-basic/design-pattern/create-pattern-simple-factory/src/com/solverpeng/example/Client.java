package com.solverpeng.example;

/**
 * 使用简单工厂模式设计一个可以创建不同几何形状（如圆形、方形和三角形等）的绘图
 * 工具，每个几何图形都具有绘制draw()和擦除erase()两个方法，要求在绘制不支持的几何
 * 图形时，提示一个UnSupportedShapeException。
 */
public class Client {
    public static void main(String[] args) {
        Graph graph = SimpleFactory.createGraph(GraphEnum.SQUARE_GRAPH);
        graph.draw();
        graph.erase();
    }
}
