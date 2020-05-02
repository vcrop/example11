package ru.vcrop.example10.walk;

import ru.vcrop.example10.graph.Vertex;

import java.util.stream.Stream;

public interface Walk<T> {
    default Stream<Vertex<T>> walk(Vertex<T> from) {
        return walk(from, v -> VertexVisitorResult.CONTINUE);
    }
    Stream<Vertex<T>> walk(Vertex<T> from, VertexVisitor<T> visitor);
}
