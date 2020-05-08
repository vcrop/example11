package ru.vcrop.example10.graph.matrixImpl.someExample;

import ru.vcrop.example10.graph.Matrix;

public class HorseTurnMatrix implements Matrix {

    public int[][] get() {
        int[][] direction = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
        int[][] result = new int[64][64];
        for (int v = 0; v < 8; v++)
            for (int h = 0; h < 8; h++)
                for (int[] d : direction) {
                    int h1 = h + d[0];
                    int v1 = v + d[1];
                    if (h1 > -1 && h1 < 8 && v1 > -1 && v1 < 8)
                        result[(v << 3) + h][(v1 << 3) + h1] = 1;
                }
        return result;
    }
}
