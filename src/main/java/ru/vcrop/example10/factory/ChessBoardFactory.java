package ru.vcrop.example10.factory;

import ru.vcrop.example10.graph.Vertex;

public class ChessBoardFactory implements VertexFactory<String>{
    private char h = '\u0060';
    private int v = 1;

    @Override
    public Vertex<String> create() {
        return new Vertex<>(h < 'h' ? ((h = (char) (h + 1)) + "" + v) : ((h = 'a') + "" + (v = v + 1)));
    }

}
