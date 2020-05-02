package ru.vcrop.example10.walk;

import ru.vcrop.example10.graph.Vertex;

public interface VertexVisitor<T> {
    VertexVisitor<Object> fullVisit = v -> VertexVisitorResult.CONTINUE;
    VertexVisitorResult onVisit(Vertex<? extends T> v);
}
