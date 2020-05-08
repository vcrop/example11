package ru.vcrop.example10.walk.visitors;

import ru.vcrop.example10.paths.Path;

public interface VertexVisitor<T> {

    VertexVisitorResult onVisit(Path<T> vertex);
}
