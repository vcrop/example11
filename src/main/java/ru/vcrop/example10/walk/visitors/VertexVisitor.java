package ru.vcrop.example10.walk.visitors;

import ru.vcrop.example10.paths.Path;

public interface VertexVisitor<T,R> {
    default VertexVisitor<T,R> post() {
        final VertexVisitor<T,R> instance = this;
        return new VertexVisitor<>() {
            VertexVisitorResult vertexVisitorResult = null;

            @Override
            public VertexVisitorResult onVisit(Path<T,?,R> path) {
                return vertexVisitorResult == VertexVisitorResult.TERMINATE ? VertexVisitorResult.TERMINATE :
                        (vertexVisitorResult = instance.onVisit(path)) == VertexVisitorResult.TERMINATE ?
                                VertexVisitorResult.CONTINUE :
                                vertexVisitorResult;
            }
        };
    }

    default VertexVisitor<T,R> and(VertexVisitor<T,R> visitor) {
        return p ->
                VertexVisitorResult.values()[Math.max(this.onVisit(p).ordinal(), visitor.onVisit(p).ordinal())];
    }

    VertexVisitorResult onVisit(Path<T,?,R> path);
}
