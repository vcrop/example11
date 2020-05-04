package ru.vcrop.example10.walk;

import ru.vcrop.example10.graph.Vertex;
import ru.vcrop.example10.paths.Path;

import java.util.stream.Stream;

public interface Walk<T>{
    Stream<Path<T>> walk(Vertex<T> from, VertexVisitor<T> visitor);
}
