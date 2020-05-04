package ru.vcrop.example10.walk;

import ru.vcrop.example10.paths.Path;

public interface VertexVisitor<T> {
    default VertexVisitor<T> and(VertexVisitor<T> visitor) {
        return p ->
            VertexVisitorResult.values()[Math.max(this.onVisit(p).ordinal(), visitor.onVisit(p).ordinal())];
    }
    VertexVisitorResult onVisit(Path<T> path);
}
