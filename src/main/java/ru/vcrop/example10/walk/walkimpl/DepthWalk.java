package ru.vcrop.example10.walk.walkimpl;

import ru.vcrop.example10.graph.Vertex;
import ru.vcrop.example10.paths.Path;
import ru.vcrop.example10.walk.VertexVisitor;
import ru.vcrop.example10.walk.VertexVisitorResult;
import ru.vcrop.example10.walk.Walk;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DepthWalk<T> implements Walk<T> {

    private final Path<T> path;

    public DepthWalk(Path<T> path) {
        this.path = path;
    }

    @Override
    public Stream<Path<T>> walk(Vertex<T> from, VertexVisitor<T> visitor) {
        List<Path<T>> result = new ArrayList<>();
        walkImpl(path.push(from), visitor, result);
        return result.stream();
    }

    private VertexVisitorResult walkImpl(Path<T> path, VertexVisitor<T> visitor, List<Path<T>> result) {
        if (path.onVisit(visitor) == VertexVisitorResult.CONTINUE) {
            result.add(path);
            for (Vertex<T> v : path.get().get(path.get().size() - 1).getEdges())
                if (walkImpl(path.push(v), visitor, result) == VertexVisitorResult.TERMINATE)
                    return VertexVisitorResult.TERMINATE;
        }
        return VertexVisitorResult.CONTINUE;
    }

    @Override
    public String toString() {
        return "DepthWalk{}";
    }
}
