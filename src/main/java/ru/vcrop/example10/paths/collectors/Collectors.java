package ru.vcrop.example10.paths.collectors;

import ru.vcrop.example10.graph.Vertex;
import ru.vcrop.example10.paths.Path;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class Collectors {
    public static Collector<Path<Integer, ?, Map<Vertex<Integer>, Long>>, ?, Map<Vertex<Integer>, Long>> countVisit() {
        return
                Collector.of((Supplier<HashMap<Vertex<Integer>, Long>>) HashMap::new,
                        (a, b) -> a.put(b.tail(), a.getOrDefault(b.tail(), 0L) + 1L),
                        (a, b) -> {
                            a.putAll(b);
                            return a;
                        },
                        a -> a);
    }
}
