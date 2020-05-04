package ru.vcrop.example10;

import ru.vcrop.example10.factory.*;
import ru.vcrop.example10.graph.*;
import ru.vcrop.example10.paths.pathImpl.PathImpl;
import ru.vcrop.example10.walk.Walk;
import ru.vcrop.example10.walk.walkimpl.DepthWalk;
import ru.vcrop.example10.walk.walkimpl.WidthWalk;

import static ru.vcrop.example10.VertexVisitors.find;
import static ru.vcrop.example10.VertexVisitors.fullWalk;

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
        VertexFactory<Integer> vertexFactory = new VertexFactoryImpl();
        Graph<Integer> graph = new MatrixGraphAdapter<>(matrix, vertexFactory);

        Vertex<Integer> from = graph.vertexes(i -> i.getValue() == 1).iterator().next();
        Vertex<Integer> to = graph.vertexes(i -> i.getValue() == 6).iterator().next();

        Walk<Integer> walk1 = new WidthWalk<>(new PathImpl<>());
        Walk<Integer> walk2 = new DepthWalk<>(new PathImpl<>());

        System.out.println(walk1);
        walk1.walk(from, find(to).and(fullWalk())).forEach(System.out::println);

        System.out.println(walk2);
        walk2.walk(from, find(to).and(fullWalk())).forEach(System.out::println);
    }
}
