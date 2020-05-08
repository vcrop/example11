package ru.vcrop.example10.graph;

import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public interface Graph<T> {
    Predicate<Object> ALL_VERTEX = a -> true;

    Set<Vertex<T>> vertexes();

    default Set<Vertex<T>> vertexes(Predicate<? super Vertex<T>> predicate) {
        return vertexes().stream().filter(predicate).collect(Collectors.toSet());
    }

}
