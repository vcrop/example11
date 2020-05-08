package ru.vcrop.example10.factory.factoryImpl;

import ru.vcrop.example10.factory.VertexFactory;
import ru.vcrop.example10.graph.Vertex;

import java.util.stream.Stream;

public class BaseFactoryMatrixImpl<T> implements VertexFactory<T> {
    private final T[][] matrix;
    private final Object[][] m;
    private int x = -1, y = 0;

    public BaseFactoryMatrixImpl(T[][] matrix) {
        this.matrix = matrix;
        m = Stream.of(matrix).map(i -> Stream.of(i).map(Vertex::new).toArray()).toArray(Object[][]::new);
    }

    @Override
    public Vertex<T> create() {
        return (Vertex<T>) (x != m[y].length - 1 ? m[y][x += 1] : m[++y][x = 0]);
    }

    @Override
    public Vertex<T> concrete(int x, int y) {
        return (Vertex<T>) m[y][x];
    }

    @Override
    public String toString() {
        return "BaseFactoryMatrixImpl{}";
    }
}
