package ru.vcrop.example10.walk.visitors;

import ru.vcrop.example10.paths.Path;

public interface PathVisitor<T> {
    default PathVisitor<T> and(PathVisitor<T> visitor) {
        return v -> PathVisitorResult.values()[Math.max(
                this.onVisit(v).ordinal(), visitor.onVisit(v).ordinal()
        )];
    }

    PathVisitorResult onVisit(Path<T> vertex);
}
