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
    private A value;
    private final Collector<T, A, R> collector;

    private BasePathImpl(Path<T, A, R> path, A v, Collector<T, A, R> collector, Vertex<T> vertex) {
        this.collector = collector;
        this.vertexList = new ArrayList<>(path.get());
        this.vertexList.add(vertex);
        if (collector != null) collector.accumulator().accept(v, vertex.getValue());
    }

    public BasePathImpl(Collector<T, A, R> collector) {
        this.collector = collector;
        if (collector != null) value = collector.supplier().get();
        vertexList = new ArrayList<>();
    }

    public BasePathImpl() {
        this(null);
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
        if (collector == null) throw new UnsupportedOperationException();
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
