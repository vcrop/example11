package ru.vcrop.example10.graph;

import java.util.Set;
import java.util.function.Predicate;

public interface Graph<T> {
    Predicate<Object> ALL_VERTEX = a -> true;

    default Set<Vertex<T>> vertexes() {
        return vertexes(ALL_VERTEX);
    }

    Set<Vertex<T>> vertexes(Predicate<? super Vertex<T>> predicate);

}
