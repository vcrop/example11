package ru.vcrop.example10.paths;

import ru.vcrop.example10.graph.Graph;
import ru.vcrop.example10.graph.Vertex;

import java.util.*;

public class ShortestPathImpl<T> implements Path<T>{
    final Vertex<T> from, to;
    final Graph<T> graph;
    private Map<Integer, Set<Vertex<T>>> map = new HashMap<>();
    private int depth = 0;

    public ShortestPathImpl(Vertex<T> from, Vertex<T> to, Graph<T> graph) {
        this.from = from;
        this.to = to;
        this.graph = graph;
    }

    @Override
    public List<Vertex<T>> get() {
        return null;
    }

}
