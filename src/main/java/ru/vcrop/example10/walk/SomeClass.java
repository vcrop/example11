package ru.vcrop.example10.walk;

import ru.vcrop.example10.paths.Path;
import ru.vcrop.example10.walk.visitors.VertexVisitor;
import ru.vcrop.example10.walk.visitors.VertexVisitorResult;

import java.util.stream.Collector;

public class SomeClass<T, R> {

    private final VertexVisitor<T> visitor;
    private final CollectorImpl<Path<T>, ?, R> collectorImpl;

    public SomeClass(VertexVisitor<T> visitor, Collector<Path<T>, ?, R> collector) {
        this.visitor = visitor;
        this.collectorImpl = new CollectorImpl<>(collector);
    }

    public VertexVisitorResult visit(Path<T> path) {
        collectorImpl.accumulate(path);
        return visitor.onVisit(path);
    }

    public R getResult() {
        return collectorImpl.getResult();
    }

    private static class CollectorImpl<T, A, R> {
        final Collector<T, A, R> collector;
        final A accumulator;

        private CollectorImpl(Collector<T, A, R> collector) {
            this.collector = collector;
            this.accumulator = collector.supplier().get();
        }

        void accumulate(T t) {
            collector.accumulator().accept(accumulator, t);
        }

        R getResult() {
            return collector.finisher().apply(accumulator);
        }
    }
}
