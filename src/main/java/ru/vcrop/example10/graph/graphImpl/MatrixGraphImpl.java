package ru.vcrop.example10.graph.graphImpl;

import ru.vcrop.example10.factory.VertexFactory;
import ru.vcrop.example10.factory.factoryImpl.BaseFactoryMatrixImpl;
import ru.vcrop.example10.graph.*;
import ru.vcrop.example10.graph.matrixImpl.ArrayMatrix;
import ru.vcrop.example10.util.BaseDirections;

import java.util.EnumSet;
import java.util.Set;

public class MatrixGraphImpl<T> implements MatrixGraph<T> {
    private final VertexFactory<T> factory;
    private final Graph<T> graph;

    private MatrixGraphImpl(VertexFactory<T> factory, Matrix matrix) {
        this.factory = factory;
        this.graph = new MatrixGraphAdapter<>(matrix, factory);
    }

    public MatrixGraphImpl(T[][] m, EnumSet<BaseDirections> directions) {
        this(new BaseFactoryMatrixImpl<>(m), new ArrayMatrix(m[0].length, m.length, directions));

    }

    @Override
    public Vertex<T> concrete(int x, int y) {
        return factory.concrete(x, y);
    }

    @Override
    public Set<Vertex<T>> vertexes() {
        return graph.vertexes();
    }
}
