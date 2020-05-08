package ru.vcrop.example10;

import ru.vcrop.example10.factory.factoryImpl.BaseFactoryMatrixImpl;
import ru.vcrop.example10.factory.VertexFactory;
import ru.vcrop.example10.graph.Graph;
import ru.vcrop.example10.graph.Matrix;
import ru.vcrop.example10.graph.MatrixGraphAdapter;
import ru.vcrop.example10.graph.Vertex;
import ru.vcrop.example10.graph.matrixImpl.BaseDirectionMatrix;
import ru.vcrop.example10.paths.collectors.Collectors;
import ru.vcrop.example10.paths.pathImpl.BasePathImpl;
import ru.vcrop.example10.paths.pathImpl.SimplePathImpl;
import ru.vcrop.example10.walk.Walk;
import ru.vcrop.example10.walk.visitors.VertexVisitor;
import ru.vcrop.example10.walk.visitors.VertexVisitorResult;
import ru.vcrop.example10.walk.visitors.VertexVisitors;
import ru.vcrop.example10.walk.walkImpl.DepthWalk;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Map;

import static ru.vcrop.example10.graph.matrixImpl.directions.BaseDirections.*;

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
        Matrix matrix1 = new BaseDirectionMatrix(4, 2, EnumSet.of(UP, RIGHT));
        System.out.println(Arrays.deepToString(matrix1.get()));
        Integer[][] m = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
        };
        VertexFactory<Integer> factory = new BaseFactoryMatrixImpl<>(m);
        Graph<Integer> graph = new MatrixGraphAdapter<>(matrix1, factory);

        Vertex<Integer> from = factory.concrete(0, 0);
        Vertex<Integer> to = factory.concrete(3, 1);

        Walk<Integer, Void> walk1 = new DepthWalk<>(new SimplePathImpl<>());

        System.out.println(walk1.walk(from, VertexVisitors.find(to)));

/*
        VertexFactory<String> factory = new ChessBoardFactory();
        Graph<String> graph = new MatrixGraphAdapter<>(new HorseTurnMatrix(), factory);

        Vertex<String> from = graph.vertexes(i -> i.getValue().equals("d4")).iterator().next();
        Vertex<String> to = graph.vertexes(i -> i.getValue().equals("h8")).iterator().next();

        Walk<String, Void> walk = new DepthWalk<>(new BasePathImpl<>());
        System.out.println(walk.walk(from, VertexVisitors.<String,Void>findPathLength(40).and(VertexVisitors.doNotCross())));
    */
    }

}
