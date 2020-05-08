package ru.vcrop.example10.walk.visitors;

import ru.vcrop.example10.graph.Vertex;
import ru.vcrop.example10.paths.Path;

import java.util.List;

public final class VertexVisitors {

    public static <T> VertexVisitor<T> findFirst(Vertex<T> vertex) {
        return p -> p.tail() == vertex ? VertexVisitorResult.TERMINATE : VertexVisitorResult.CONTINUE;
    }

}
