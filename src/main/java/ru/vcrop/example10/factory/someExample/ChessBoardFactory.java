package ru.vcrop.example10.factory.someExample;

import ru.vcrop.example10.factory.VertexFactory;
import ru.vcrop.example10.graph.Vertex;

public class ChessBoardFactory implements VertexFactory<String> {
    private int i = 0;

    @Override
    public Vertex<String> create() {
        return new Vertex<>((char) (i % 8 + 0x61) + "" + (i++ / 8 + 1));
    }

}
