package ru.vcrop.example10.paths;

import ru.vcrop.example10.graph.Vertex;

import java.util.List;

public interface Path<T> {

    Path<T> push(Vertex<T> vertex);

    default Vertex<T> tail(){
        return get().get(get().size() - 1);
    }

    default T reduce() {
        throw new UnsupportedOperationException();
    }

    List<Vertex<T>> get();

}
