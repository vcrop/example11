package ru.vcrop.example10.paths.pathimpl;

import ru.vcrop.example10.graph.*;
import ru.vcrop.example10.paths.Path;
import ru.vcrop.example10.walk.*;
import ru.vcrop.example10.walk.walkimpl.*;

import java.util.List;

public class ShortestPathImpl<T> implements Path<T> {
    final Vertex<T> from, to;
    final Graph<T> graph;
    private final Walk<T> WALK = new WidthWalk<>();
    private final VertexVisitor<T> VERTEX_VISITOR = new VertexVisitor<T>() {
        @Override
        public VertexVisitorResult onVisit(Vertex<T> v) {
            return null;
        }
    };

    public ShortestPathImpl(Vertex<T> from, Vertex<T> to, Graph<T> graph) {
        this.from = from;
        this.to = to;
        this.graph = graph;
    }
    @Override
    public List<Vertex<T>> get() {
        return null;
    }

}
