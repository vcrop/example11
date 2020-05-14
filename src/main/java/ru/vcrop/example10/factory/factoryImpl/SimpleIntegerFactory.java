package ru.vcrop.example10.factory.factoryImpl;

import ru.vcrop.example10.factory.VertexFactory;
import ru.vcrop.example10.graph.Vertex;

public class SimpleIntegerFactory implements VertexFactory<Integer> {
    static int i;

    @Override
    public Vertex<Integer> create() {
        return new Vertex<>(++i);
    }
}
