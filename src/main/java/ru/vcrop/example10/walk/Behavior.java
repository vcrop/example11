package ru.vcrop.example10.walk;

import ru.vcrop.example10.paths.Path;
import ru.vcrop.example10.walk.visitors.PathVisitorResult;

public interface Behavior<T, R> {
    PathVisitorResult visit(Path<T> path);
    R getResult();
}
