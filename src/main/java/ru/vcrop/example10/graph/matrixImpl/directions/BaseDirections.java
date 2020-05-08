package ru.vcrop.example10.graph.matrixImpl.directions;

public enum BaseDirections {
    UP(new int[]{1, 0}),
    DOWN(new int[]{-1, 0}),
    LEFT(new int[]{0, -1}),
    RIGHT(new int[]{0, 1}),
    LEFT_UP(new int[]{1, -1}),
    LEFT_DOWN(new int[]{-1, -1}),
    RIGHT_UP(new int[]{1, 1}),
    RIGHT_DOWN(new int[]{-1, 1});
    private final int[] delta;

    BaseDirections(int[] delta) {
        this.delta = delta;
    }

    public int[] getDelta() {
        return delta;
    }
}
