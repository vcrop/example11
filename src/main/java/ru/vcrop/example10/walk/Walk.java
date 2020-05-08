package ru.vcrop.example10.walk;

import ru.vcrop.example10.graph.Vertex;

public interface Walk<T, R> {
    R walk(Vertex<T> from);
}
