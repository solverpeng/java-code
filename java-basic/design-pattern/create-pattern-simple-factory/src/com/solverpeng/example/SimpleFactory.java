package com.solverpeng.example;

public class SimpleFactory {
    public static Graph createGraph(GraphEnum graphEnum) {
        if (graphEnum == null) {
            return null;
        }

        if (GraphEnum.ROUND.equals(graphEnum)) {
            return new RoundGraph();
        } else if (GraphEnum.TRIANGLE_GRAPH.equals(graphEnum)) {
            return new TriangleGraph();
        } else if (GraphEnum.SQUARE_GRAPH.equals(graphEnum)) {
            return new SquareGraph();
        } else {
            return null;
        }

    }
}
