package ru.vcrop.example10.factory;

import ru.vcrop.example10.graph.Vertex;

public interface VertexFactory<T> {
    Vertex<T> create();
    default Vertex<T> concrete(int x, int y) {
        throw new UnsupportedOperationException();
    }
}
