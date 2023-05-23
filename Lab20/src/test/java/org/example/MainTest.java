package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    @Test
    void findMax() {
        assertEquals(4, Main.FindMax(matrix));
    }

    @Test
    void findMin() {
        assertEquals(1, Main.FindMin(matrix));
    }

    @Test
    void averegeMinMax() {
        assertEquals(3.5, Main.AveregeMinMax(6, 1));
    }

    @Test
    void main() {
    }
}