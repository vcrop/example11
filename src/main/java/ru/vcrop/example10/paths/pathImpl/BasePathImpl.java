package ru.vcrop.example10.paths.pathImpl;

import ru.vcrop.example10.graph.Vertex;
import ru.vcrop.example10.paths.Path;
import ru.vcrop.example10.walk.visitors.VertexVisitor;
import ru.vcrop.example10.walk.visitors.VertexVisitorResult;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class BasePathImpl<T, A, R> implements Path<T, A, R> {

    private final List<Vertex<T>> vertexList;
    private final A value;
    private final Collector<Path<T, ?, R>, A, R> collector;

    private BasePathImpl(Path<T, A, R> path, A v, Collector<Path<T, ?, R>, A, R>  collector, Vertex<T> vertex) {
        this.collector = collector;
        this.value = v;
        this.vertexList = new ArrayList<>(path.get());
        this.vertexList.add(vertex);
        collector.accumulator().accept(v, this);
    }

    public BasePathImpl(Collector<Path<T, ?, R>, A, R>  collector) {
        this.collector = collector;
        value = collector.supplier().get();
        vertexList = new ArrayList<>();
    }

    @Override
    public Path<T, A, R> push(Vertex<T> vertex) {
        return new BasePathImpl<>(this, value, collector, vertex);
    }

    @Override
    public VertexVisitorResult onVisit(VertexVisitor<T, R> visitor) {
        return visitor.onVisit(this);
    }

    @Override
    public R getResult() {
        return collector.finisher().apply(value);
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
