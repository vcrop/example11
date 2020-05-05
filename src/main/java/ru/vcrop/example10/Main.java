package ru.vcrop.example10;

import ru.vcrop.example10.factory.ChessBoardFactory;
import ru.vcrop.example10.factory.VertexFactory;
import ru.vcrop.example10.graph.Graph;
import ru.vcrop.example10.graph.MatrixGraphAdapter;
import ru.vcrop.example10.graph.Vertex;
import ru.vcrop.example10.graph.matrixImpl.HorseTurnMatrix;
import ru.vcrop.example10.paths.pathImpl.BasePathImpl;
import ru.vcrop.example10.walk.Walk;
import ru.vcrop.example10.walk.walkimpl.DepthWalk;

public class Main {

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 0, 0, 1, 0},
                {1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1, 1},
                {1, 1, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 0}
        };
        /*int[][] matrix = {
                {0, 1, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 0},
                {0, 1, 0, 0, 0, 1},
                {1, 0, 0, 0, 1, 0},
                {0, 1, 0, 1, 0, 1},
                {0, 0, 1, 0, 1, 0}
        };
    */


        VertexFactory<String> factory = new ChessBoardFactory();
        Graph<String> graph = new MatrixGraphAdapter<>(new HorseTurnMatrix().get(), factory);

        Vertex<String> from = graph.vertexes(i -> i.getValue().equals("d4")).iterator().next();
        Vertex<String> to = graph.vertexes(i -> i.getValue().equals("h8")).iterator().next();

        Walk<String, Void> walk = new DepthWalk<>(new BasePathImpl<>());
        System.out.println(walk.walk(from, VertexVisitors.<String,Void>findPathLength(40).and(VertexVisitors.doNotCross())));
    }
}
