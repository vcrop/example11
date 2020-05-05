package ru.vcrop.example10.graph.matrixImpl;

public class HorseTurnMatrix {

    public int[][] get() {
        int[][] direction = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
        int[][] result = new int[64][64];
        for (int v = 0; v < 8; v++)
            for (int h = 0; h < 8; h++)
                for (int[] d : direction)
                    if (h + d[0] > -1 && h + d[0] < 8 && v + d[1] > -1 && v + d[1] < 8)
                        result[h + v * 8][h + v * 8 + d[0] + d[1] * 8] = 1;
        return result;
    }
}
