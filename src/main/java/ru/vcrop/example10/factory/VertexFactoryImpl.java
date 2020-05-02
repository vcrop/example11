package ru.vcrop.example10.factory;

import ru.vcrop.example10.graph.Vertex;

public class VertexFactoryImpl implements VertexFactory<Integer> {
    static int i;

    @Override
    public Vertex<Integer> create() {
        return new Vertex<>(++i);
    }
}
