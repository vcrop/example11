package ru.vcrop.example10.paths;

import ru.vcrop.example10.graph.Vertex;
import ru.vcrop.example10.walk.visitors.VertexVisitor;
import ru.vcrop.example10.walk.visitors.VertexVisitorResult;

import java.util.List;

public interface Path<T, A, R> {

    Path<T, A, R> push(Vertex<T> vertex);

    VertexVisitorResult onVisit(VertexVisitor<T,R> visitor);

    R getResult();

    default Vertex<T> tail(){
        return get().get(get().size() - 1);
    }

    List<Vertex<T>> get();

}
