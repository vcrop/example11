package ru.vcrop.example10.walk;

import ru.vcrop.example10.graph.Vertex;

import java.util.stream.Stream;

public interface Walk<T> {
    Stream<Vertex<T>> walk(Vertex<T> from, VertexVisitor<? super T> visitor);
}
