package ru.vcrop.example10.walk.walkImpl;

import ru.vcrop.example10.graph.Vertex;
import ru.vcrop.example10.paths.Path;
import ru.vcrop.example10.walk.BehaviorClass;
import ru.vcrop.example10.walk.Walk;
import ru.vcrop.example10.walk.visitors.PathVisitorResult;

public class DepthWalk<T, R> implements Walk<T, R> {

    private final Path<T> path;
    private final BehaviorClass<T, R> behaviorClass;

    public DepthWalk(Path<T> path, BehaviorClass<T, R> behaviorClass) {
        this.path = path;
        this.behaviorClass = behaviorClass;
    }

    @Override
    public R walk(Vertex<T> from) {
        walkImpl(path.push(from));
        return behaviorClass.getResult();
    }

    private PathVisitorResult walkImpl(Path<T> from) {
        PathVisitorResult pathVisitorResult = behaviorClass.visit(from);
        if (pathVisitorResult == PathVisitorResult.CONTINUE) {
            for (Vertex<T> v : from.tail().getEdges())
                if (walkImpl(from.push(v)) == PathVisitorResult.TERMINATE)
                    return PathVisitorResult.TERMINATE;
        }
        return pathVisitorResult;
    }

    @Override
    public String toString() {
        return "DepthWalk{}";
    }

}
