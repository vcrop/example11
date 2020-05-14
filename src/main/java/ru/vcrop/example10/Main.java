package ru.vcrop.example10;

import ru.vcrop.example10.factory.factoryImpl.BaseFactoryMatrixImpl;
import ru.vcrop.example10.factory.VertexFactory;
import ru.vcrop.example10.graph.*;
import ru.vcrop.example10.graph.graphImpl.MatrixGraphImpl;
import ru.vcrop.example10.graph.matrixImpl.ArrayMatrix;
import ru.vcrop.example10.paths.Path;
import ru.vcrop.example10.paths.pathImpl.BasePathImpl;
import ru.vcrop.example10.util.BaseDirections;
import ru.vcrop.example10.util.Collectors;
import ru.vcrop.example10.paths.pathImpl.ReducedPathImpl;
import ru.vcrop.example10.walk.Behavior;
import ru.vcrop.example10.walk.BehaviorClass;
import ru.vcrop.example10.walk.Walk;
import ru.vcrop.example10.util.PathVisitors;
import ru.vcrop.example10.walk.walkImpl.DepthWalk;

import java.util.*;

import static java.util.stream.Collectors.*;
import static ru.vcrop.example10.util.BaseDirections.*;

public class Main {

    public static void main(String[] args) {
        Integer[][] matrix = {
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

       /* MatrixGraph<Integer> matrixGraph = new MatrixGraphImpl<>(matrix, EnumSet.of(UP, RIGHT));
        Vertex<Integer> from = matrixGraph.concrete(0, 0);
        Vertex<Integer> to = matrixGraph.concrete(matrix[0].length - 1, matrix.length - 1);
        Path<Integer> path = new ReducedPathImpl<>(() -> 0, Integer::sum);
        Behavior<Integer, Optional<Path<Integer>>> behavior =
                new BehaviorClass<>(PathVisitors.noCross(),
                        Collectors.pathsTo(to, minBy(Comparator.comparingInt(Path::reduce))));
        Walk<Integer, Optional<Path<Integer>>> walk =
                new DepthWalk<>(path, behavior);
        System.out.println(walk.walk(from));
/*
        VertexFactory<String> factory = new ChessBoardFactory();
        Graph<String> graph = new MatrixGraphAdapter<>(new HorseTurnMatrix(), factory);

        Vertex<String> from = graph.vertexes(i -> i.getValue().equals("d4")).iterator().next();
        Vertex<String> to = graph.vertexes(i -> i.getValue().equals("h8")).iterator().next();

        Walk<String, Void> walk = new DepthWalk<>(new BasePathImpl<>());
        System.out.println(walk.walk(from, VertexVisitors.<String,Void>findPathLength(40).and(VertexVisitors.doNotCross())));
    */

        Integer[][] matrix2 = {{1, 2, 3, 4, 5},
                               {6, 7, 8, 9, 10}};

        MatrixGraph<Integer> graph = new MatrixGraphImpl<>(matrix2, hvDIRECTIONS);

        Vertex<Integer> from = graph.concrete(2, 1);
        Vertex<Integer> to = graph.concrete(4, 1);

        Behavior<Integer,Optional<Path<Integer>>> behavior =
                new BehaviorClass<>(PathVisitors.noCross(), Collectors.pathsTo(to, maxBy(Comparator.comparingInt(Path::reduce))));

        Path<Integer> path = new ReducedPathImpl<>(() -> 0, Integer::sum);

        Walk<Integer, Optional<Path<Integer>>> walk = new DepthWalk<>(path, behavior);

        System.out.println(walk.walk(from));
    }

}
