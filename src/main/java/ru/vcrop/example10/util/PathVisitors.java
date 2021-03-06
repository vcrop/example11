package ru.vcrop.example10.util;

import ru.vcrop.example10.graph.Vertex;
import ru.vcrop.example10.walk.visitors.PathVisitor;
import ru.vcrop.example10.walk.visitors.PathVisitorResult;

import java.util.Set;


public final class PathVisitors {

    public static <T> PathVisitor<T> noCross() {
        return p -> Set.copyOf(p.get()).size() != p.get().size() ? PathVisitorResult.SKIP : PathVisitorResult.CONTINUE;
    }

    public static <T, R> PathVisitor<T> findFirst(Vertex<T> vertex) {
        return p -> p.tail() == vertex ? PathVisitorResult.TERMINATE : PathVisitorResult.CONTINUE;
    }

}
