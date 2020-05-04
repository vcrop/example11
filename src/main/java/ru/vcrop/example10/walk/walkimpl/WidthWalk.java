package ru.vcrop.example10.walk.walkimpl;

import ru.vcrop.example10.graph.Vertex;
import ru.vcrop.example10.paths.Path;
import ru.vcrop.example10.walk.VertexVisitor;
import ru.vcrop.example10.walk.Walk;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class WidthWalk<T> implements Walk<T> {

    private final Path<T> path;

    public WidthWalk(Path<T> path) {
        this.path = path;
    }

    @Override
    public Stream<Path<T>> walk(Vertex<T> from, VertexVisitor<T> visitor) {
        List<Path<T>> result = new ArrayList<>();
        List<Path<T>> current = List.of(path.push(from));
        while (!current.isEmpty()) {
            List<Path<T>> next = new ArrayList<>();
            for (Path<T> p : current) {
                switch (p.onVisit(visitor)) {
                    case TERMINATE:
                        return result.stream();
                    case CONTINUE:
                        result.add(p);
                        for (Vertex<T> v : p.get().get(p.get().size() - 1).getEdges())
                            next.add(p.push(v));
                }
            }
            current = next;
        }
        return result.stream();
    }

    @Override
    public String toString() {
        return "WidthWalk{ }";
    }
}
