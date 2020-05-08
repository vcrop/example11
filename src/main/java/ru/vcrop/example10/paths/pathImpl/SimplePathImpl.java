package ru.vcrop.example10.paths.pathImpl;

import ru.vcrop.example10.paths.Path;

import java.util.stream.Collector;

public class SimplePathImpl<T> extends BasePathImpl<T,Void,Void>{

    public SimplePathImpl() {
        this(Collector.of(() -> null, (a, b) -> {}, (a, b) -> a, a -> a));
    }

    private SimplePathImpl(Collector<Path<T, ?, Void>, Void, Void> collector) {
        super(collector);
    }

    @Override
    public Void getResult() {
        throw new UnsupportedOperationException();
    }
}
