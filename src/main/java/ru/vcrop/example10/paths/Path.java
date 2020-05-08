package ru.vcrop.example10.paths;

import ru.vcrop.example10.graph.Vertex;
import ru.vcrop.example10.walk.visitors.VertexVisitor;
import ru.vcrop.example10.walk.visitors.VertexVisitorResult;

import java.util.List;

public interface Path<T> {

    Path<T> push(Vertex<T> vertex);

    default Vertex<T> tail(){
        return get().get(get().size() - 1);
    }

    List<Vertex<T>> get();

}
