package ru.vcrop.example10;

import ru.vcrop.example10.factory.VertexFactory;
import ru.vcrop.example10.factory.VertexFactoryImpl;
import ru.vcrop.example10.graph.Graph;
import ru.vcrop.example10.graph.MatrixGraphAdapter;
import ru.vcrop.example10.graph.Vertex;
import ru.vcrop.example10.walk.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 0, 0, 1, 0},
                {1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1, 1},
                {1, 1, 0, 1, 0, 0},
                {0, 1, 0, 1, 0, 0}
        };
        VertexFactory<Integer> vertexFactory = new VertexFactoryImpl();
        Graph<Integer> graph = new MatrixGraphAdapter<>(matrix, vertexFactory);

        Vertex<Integer> from = graph.vertexes(i -> i.getValue() == 1).iterator().next();

        for (Walk<Integer> w : List.of(new DepthWalk<Integer>(), new WidthWalk<Integer>())) {
            System.out.println(w);
            w.walk(from).forEach(System.out::println);
        }

    }
}
