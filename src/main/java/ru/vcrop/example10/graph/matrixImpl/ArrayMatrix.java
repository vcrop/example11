package ru.vcrop.example10.graph.matrixImpl;

import ru.vcrop.example10.graph.Matrix;
import ru.vcrop.example10.util.BaseDirections;

import java.util.EnumSet;

public class ArrayMatrix implements Matrix {

    private final int[][] array;
    private final int width, height;
    private final EnumSet<BaseDirections> directions;

    public ArrayMatrix(int width, int height, EnumSet<BaseDirections> directions) {
        this.width = width;
        this.height = height;
        this.directions = directions;
        array = new int[height * width][width * height];
    }

    public int[][] get() {
        for (int v = 0; v < height; v++)
            for (int h = 0; h < width; h++)
                for (BaseDirections d : directions) {
                    int h1 = h + d.getDelta()[1];
                    int v1 = v + d.getDelta()[0];
                    if (h1 > -1 && h1 < width && v1 > -1 && v1 < height)
                        array[v * width + h][v1 * width + h1] = 1;
                }
        return array;
    }
}
