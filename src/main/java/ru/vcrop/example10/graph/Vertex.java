package ru.vcrop.example10.graph;

import java.util.HashSet;
import java.util.Set;

public class Vertex<T> {
    T value;

    Set<Vertex<T>> edges = new HashSet<>();

    public Vertex(T value) {
        this.value = value;
    }

    public boolean addEdge(Vertex<T> vertex) {
        return edges.add(vertex);
    }

    public T getValue() {
        return value;
    }

    public Set<Vertex<T>> getEdges() {
        return edges;
    }

    @Override
    public String toString() {
        return "Vertex{" + "value=" + value + '}';
    }
}
