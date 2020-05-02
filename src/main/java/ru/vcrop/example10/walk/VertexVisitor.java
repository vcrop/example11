package ru.vcrop.example10.walk;

import ru.vcrop.example10.graph.Vertex;

public interface VertexVisitor<T> {
    VertexVisitorResult onVisit(Vertex<T> v);
}
