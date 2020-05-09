package ru.vcrop.example10.paths.pathImpl;

import ru.vcrop.example10.graph.Vertex;
import ru.vcrop.example10.paths.Path;

import java.util.*;
import java.util.stream.Collectors;

public class BasePathImpl<T> implements Path<T> {

    private final List<Vertex<T>> vertexList;

    protected BasePathImpl(Path<T> path, Vertex<T> vertex) {
        this.vertexList = new ArrayList<>(path.get());
        this.vertexList.add(vertex);
    }

    public BasePathImpl() {
        this.vertexList = List.of();
    }

    @Override
    public Path<T> push(Vertex<T> vertex) {
        return new BasePathImpl<>(this, vertex);
    }

    @Override
    public List<Vertex<T>> get() {
        return vertexList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BasePathImpl<?> basePath = (BasePathImpl<?>) o;

        return vertexList != null ? vertexList.equals(basePath.vertexList) : basePath.vertexList == null;
    }

    @Override
    public int hashCode() {
        return vertexList != null ? vertexList.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "BasePathImpl{" +
                vertexList.stream().map(Vertex::toString).collect(Collectors.joining(" -> ")) +
                '}';
    }

}
