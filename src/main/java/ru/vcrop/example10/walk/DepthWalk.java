package ru.vcrop.example10.walk;

import ru.vcrop.example10.graph.Vertex;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Stream;

public class DepthWalk<T> implements Walk<T> {

    VertexVisitor<? super T> visitor;

    @Override
    public Stream<Vertex<T>> walk(Vertex<T> from, VertexVisitor<? super T> visitor) {
        this.visitor = visitor;
        Set<Vertex<T>> result = new LinkedHashSet<>();
        walkImpl(from, result);
        return result.stream();
    }

    private VertexVisitorResult walkImpl(Vertex<T> from, Set<Vertex<T>> v) {
        VertexVisitorResult result = visitor.onVisit(from);
        if (result == VertexVisitorResult.CONTINUE) {
            v.add(from);
            for (Vertex<T> r : from.getEdges())
                if (!v.contains(r))
                    if (walkImpl(r, v) == VertexVisitorResult.TERMINATE) return VertexVisitorResult.TERMINATE;
        }
        return result;
    }

    @Override
    public String toString() {
        return "DepthWalk{}";
    }
}
