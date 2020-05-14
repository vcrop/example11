package ru.vcrop.example10.graph;

public interface MatrixGraph<T> extends Graph<T>{
    Vertex<T> concrete(int x, int y);
}
