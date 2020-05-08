package ru.vcrop.example10.walk.walkImpl;

import ru.vcrop.example10.graph.Vertex;
import ru.vcrop.example10.paths.Path;
import ru.vcrop.example10.walk.SomeClass;
import ru.vcrop.example10.walk.Walk;
import ru.vcrop.example10.walk.visitors.VertexVisitorResult;

public class DepthWalk<T, R> implements Walk<T, R> {

    private final Path<T> path;
    private final SomeClass<T,R> someClass;

    public DepthWalk(Path<T> path, SomeClass<T,R> someClass) {
        this.path = path;
        this.someClass = someClass;
    }

    @Override
    public R walk(Vertex<T> from) {
        walkImpl(path.push(from));
        return someClass.getResult();
    }

    private VertexVisitorResult walkImpl(Path<T> from) {
        VertexVisitorResult vertexVisitorResult = someClass.visit(from);
        if (vertexVisitorResult == VertexVisitorResult.CONTINUE) {
            for (Vertex<T> v : from.tail().getEdges())
                if (walkImpl(from.push(v)) == VertexVisitorResult.TERMINATE) break;
        }
        return vertexVisitorResult;
    }

    @Override
    public String toString() {
        return "DepthWalk{}";
    }

}
