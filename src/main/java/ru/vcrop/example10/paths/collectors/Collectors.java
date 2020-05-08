package ru.vcrop.example10.paths.collectors;

import ru.vcrop.example10.graph.Vertex;
import ru.vcrop.example10.paths.Path;

import java.util.Set;
import java.util.function.*;
import java.util.stream.Collector;

import static java.util.stream.Collector.of;

public final class Collectors {
    public static <T, A, R> Collector<Path<T>, ?, R> pathsTo(Vertex<T> vertex, Collector<Path<T>, A, R> collector) {
        return filter(p -> p.tail() == vertex, collector);
    }

    public static <T, A, R> Collector<Path<T>, ?, R> filter(Predicate<Path<T>> predicate, Collector<Path<T>, A, R> collector) {
        return new Collector<Path<T>, A, R>() {
            @Override
            public Supplier<A> supplier() {
                return collector.supplier();
            }

            @Override
            public BiConsumer<A, Path<T>> accumulator() {
                return (a, p) -> {
                    if (predicate.test(p)) collector.accumulator().accept(a, p);
                };
            }

            @Override
            public BinaryOperator<A> combiner() {
                return collector.combiner();
            }

            @Override
            public Function<A, R> finisher() {
                return collector.finisher();
            }

            @Override
            public Set<Characteristics> characteristics() {
                return collector.characteristics();
            }
        };

    }
}
