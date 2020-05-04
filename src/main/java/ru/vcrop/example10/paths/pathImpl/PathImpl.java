package ru.vcrop.example10.paths.pathImpl;

import ru.vcrop.example10.graph.Vertex;
import ru.vcrop.example10.paths.Path;
import ru.vcrop.example10.walk.VertexVisitor;
import ru.vcrop.example10.walk.VertexVisitorResult;

import java.util.*;
import java.util.stream.Collectors;

public class PathImpl<T> implements Path<T> {

    private final List<Vertex<T>> vertexList;

    private PathImpl(Path<T> path, Vertex<T> vertex) {
        vertexList = new ArrayList<>(path.get());
        vertexList.add(vertex);
    }

    public PathImpl() {
        vertexList = new ArrayList<>();
    }

    @Override
    public Path<T> push(Vertex<T> vertex) {
        return new PathImpl<>(this, vertex);
    }

    @Override
    public VertexVisitorResult onVisit(VertexVisitor<T> visitor) {
        return visitor.onVisit(this);
    }

    @Override
    public List<Vertex<T>> get() {
        return vertexList;
    }

    @Override
    public String toString() {
        return "PathImpl{" +
                vertexList.stream().map(Vertex::toString).collect(Collectors.joining(" -> ")) +
                '}';
    }

}
