package ru.vcrop.example10.walk.visitors;

import ru.vcrop.example10.graph.Vertex;
import ru.vcrop.example10.paths.Path;

import java.util.HashSet;
import java.util.Set;

public class VertexVisitors {
    public static <T,R> VertexVisitor<T,R> fullWalk() {
        return new VertexVisitor<>() {
            final Set<Vertex<T>> visited = new HashSet<>();
            @Override
            public VertexVisitorResult onVisit(Path<T,?,R> path) {
                if (visited.contains(path.tail()))
                    return VertexVisitorResult.SKIP;
                visited.add(path.tail());
                return VertexVisitorResult.CONTINUE;
            }
        };
    }

    public static <T,R> VertexVisitor<T,R> find(Vertex<T> vertex) {
        return ((VertexVisitor<T,R>) (path ->
                path.tail() == vertex ? VertexVisitorResult.TERMINATE : VertexVisitorResult.CONTINUE))
                .and(VertexVisitors.doNotCross());

    }

    public static <T,R> VertexVisitor<T,R> findPathLength(int length) {
        return path ->
                path.get().size() == length ? VertexVisitorResult.TERMINATE : VertexVisitorResult.CONTINUE;
    }

    public static <T,R> VertexVisitor<T,R> doNotCross() {
        return path ->
                Set.copyOf(path.get()).size() != path.get().size() ? VertexVisitorResult.SKIP : VertexVisitorResult.CONTINUE;

    }

}
