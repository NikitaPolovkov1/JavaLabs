package org.example;

public class Main {
    public static int FindMax(int[][] matrix) {
        int max = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length - i - 1; j++) {
                int element = matrix[i][j];
                if (element > max) {
                    max = element;
                }
            }
        }
        return max;
    }

    public static int FindMin(int[][] matrix) {
        int min = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length - i - 1; j++) {
                int element = matrix[i][j];
                if (element < min) {
                    min = element;
                }
            }
        }
        return min;
    }

    public static double AveregeMinMax(int min, int max)
    {
        return (double) (max + min) / 2;
    }
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        int min = FindMin(matrix);
        int max = FindMax(matrix);
        double average = AveregeMinMax(min, max);

        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
        System.out.println("Average: " + average);
    }
}