package ru.vcrop.example10.paths;

import ru.vcrop.example10.graph.Vertex;
import ru.vcrop.example10.walk.VertexVisitor;
import ru.vcrop.example10.walk.VertexVisitorResult;

import java.util.List;

public interface Path<T> {

    Path<T> push(Vertex<T> vertex);
    VertexVisitorResult onVisit(VertexVisitor<T> visitor);
    default boolean contains(Vertex<T> vertex) {
        return get().contains(vertex);
    }
    default int size() {
        return get().size();
    }
    List<Vertex<T>> get();

}
