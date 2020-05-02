package ru.vcrop.example10.walk;

import ru.vcrop.example10.graph.Vertex;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Stream;

public class WidthWalk<T> implements Walk<T> {
    @Override
    public Stream<Vertex<T>> walk(Vertex<T> from, VertexVisitor<? super T> visitor) {
        Set<Vertex<T>> result = new LinkedHashSet<>();
        Set<Vertex<T>> current = Set.of(from);
        while (!current.isEmpty()) {
            Set<Vertex<T>> next = new HashSet<>();
            for (Vertex<T> v : current)
                switch (visitor.onVisit(v)) {
                    case TERMINATE:
                        return result.stream();
                    case CONTINUE:
                        result.add(v);
                        for (Vertex<T> e : v.getEdges())
                            if (!result.contains(e)) next.add(e);
                    case SKIP:
                        break;
                }
            current = next;
        }
        return result.stream();
    }

    @Override
    public String toString() {
        return "WidthWalk{}";
    }
}
