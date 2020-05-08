package ru.vcrop.example10.walk.walkImpl;

import ru.vcrop.example10.graph.Vertex;
import ru.vcrop.example10.paths.Path;
import ru.vcrop.example10.walk.visitors.VertexVisitor;
import ru.vcrop.example10.walk.Walk;

public class DepthWalk<T,R> implements Walk<T,R> {

    private final Path<T,?,R> path;

    public DepthWalk(Path<T,?,R> path) {
        this.path = path;
    }

    @Override
    public Path<T,?,R> walk(Vertex<T> from, VertexVisitor<T,R> visitor) {
        Path<T, ?, R> result = walkImpl(path.push(from), visitor);
        return result == null ? path : result;
    }

    protected Path<T,?,R> walkImpl(Path<T,?,R> path, VertexVisitor<T,R> visitor) {
        switch (path.onVisit(visitor)) {
            case TERMINATE:
                return path;
            case CONTINUE:
                for (Vertex<T> v : path.get().get(path.get().size() - 1).getEdges()) {
                    Path<T,?,R> p = walkImpl(path.push(v), visitor);
                    if (p != null) return p;
                }
            case SKIP:
                return null;
        }
        return path;
    }

    @Override
    public String toString() {
        return "DepthWalk{}";
    }
}
