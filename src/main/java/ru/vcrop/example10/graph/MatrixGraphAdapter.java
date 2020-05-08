package ru.vcrop.example10.graph;

import ru.vcrop.example10.factory.VertexFactory;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Stream.*;

public class MatrixGraphAdapter<T> implements Graph<T> {

    int[][] matrix;
    VertexFactory<T> factory;
    Set<Vertex<T>> vertexSet;

    public MatrixGraphAdapter(Matrix matrix, VertexFactory<T> factory) {
        this.matrix = matrix.get();
        this.factory = factory;
        this.vertexSet = vertexes();
    }

    public Set<Vertex<T>> vertexes() {
        if (Objects.isNull(vertexSet)) {
            List<Vertex<T>> vertexList = generate(factory::create).limit(matrix.length).collect(Collectors.toList());
            IntStream.range(0, matrix.length)
                    .forEach(i -> IntStream.range(0, matrix.length)
                            .filter(j -> matrix[i][j] != 0)
                            .forEach(j -> vertexList.get(i).addEdge(vertexList.get(j))));
            vertexSet = Set.copyOf(vertexList);
        }
        return vertexSet;
    }

    @Override
    public String toString() {
        return "MatrixGraphAdapter{" +
                "vertexSet=" + vertexSet +
                '}';
    }
}
