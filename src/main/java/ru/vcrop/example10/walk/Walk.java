package ru.vcrop.example10.walk;

import ru.vcrop.example10.graph.Vertex;
import ru.vcrop.example10.paths.Path;
import ru.vcrop.example10.walk.visitors.VertexVisitor;

public interface Walk<T,R>{
    Path<T,?,R> walk(Vertex<T> from, VertexVisitor<T,R> visitor);
}
