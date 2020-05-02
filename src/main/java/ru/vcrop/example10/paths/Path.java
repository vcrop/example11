package ru.vcrop.example10.paths;

import ru.vcrop.example10.graph.Vertex;
import ru.vcrop.example10.walk.VertexVisitor;
import ru.vcrop.example10.walk.VertexVisitorResult;

import java.util.List;

public interface Path<T>{
    List<Vertex<T>> get();
}
