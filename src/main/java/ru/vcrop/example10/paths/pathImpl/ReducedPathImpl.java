package ru.vcrop.example10.paths.pathImpl;

import ru.vcrop.example10.graph.Vertex;
import ru.vcrop.example10.paths.Path;

import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ReducedPathImpl<T> extends BasePathImpl<T>{

    private final T result;
    private final BinaryOperator<T> reducer;

    protected ReducedPathImpl(Path<T> path, Vertex<T> vertex, BinaryOperator<T> reducer, T result) {
        super(path, vertex);
        this.result = result;
        this.reducer = reducer;
    }

    public ReducedPathImpl(Supplier<T> supplier, BinaryOperator<T> reducer) {
        this.result = supplier.get();
        this.reducer = reducer;
    }

    @Override
    public Path<T> push(Vertex<T> vertex) {
        return new ReducedPathImpl<>(this, vertex, reducer, reducer.apply(result, vertex.getValue()));
    }

    public T getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "ReducedPathImpl(withResult = " + result + "){" +
                get().stream().map(Vertex::toString).collect(Collectors.joining(" -> ")) +
                '}';
    }
}
