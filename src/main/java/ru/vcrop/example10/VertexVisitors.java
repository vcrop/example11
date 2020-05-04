package ru.vcrop.example10;

import ru.vcrop.example10.graph.Vertex;
import ru.vcrop.example10.paths.Path;
import ru.vcrop.example10.walk.VertexVisitor;
import ru.vcrop.example10.walk.VertexVisitorResult;

import java.util.HashSet;
import java.util.Set;

public class VertexVisitors {
    public static <T> VertexVisitor<T> fullWalk() {
        return new VertexVisitor<>() {
            final Set<Vertex<T>> visited = new HashSet<>();
            @Override
            public VertexVisitorResult onVisit(Path<T> path) {
                if (visited.contains(path.get().get(path.get().size() - 1)))
                    return VertexVisitorResult.SKIP;
                visited.add(path.get().get(path.get().size() - 1));
                return VertexVisitorResult.CONTINUE;
            }
        };
    }
    public static <T> VertexVisitor<T> find(Vertex<T> vertex) {
        return new VertexVisitor<T>() {
            boolean find = false;
            @Override
            public VertexVisitorResult onVisit(Path<T> path) {
                if (find) return VertexVisitorResult.TERMINATE;
                if (path.get().get(path.get().size() - 1) == vertex) find = true;
                return VertexVisitorResult.CONTINUE;
            }
        };
    }
}
