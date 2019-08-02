package com.solverpeng.example;

public enum GraphEnum {
    ROUND("圆形"),
    TRIANGLE_GRAPH("三角形"),
    SQUARE_GRAPH("正方形");

    private String graphName;

    GraphEnum(String graphName) {
        this.graphName = graphName;
    }

    public String getGraphName() {
        return graphName;
    }
}
