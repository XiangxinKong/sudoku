package com.company;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Generate random incompleted sudoku matrix
 * Achived by shuffling a completed sudoku, and randomly remove some numbers
 *
 * @author Xiangxin Kong
 * @version 1.0
 */
public class sudokuGenerator {
    static int size = 9;//size of sudoku
    final static int[][] solvedMatrix = {//solved, completed sudoku
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {4, 5, 6, 7, 8, 9, 1, 2, 3},
            {7, 8, 9, 1, 2, 3, 4, 5, 6},
            {8, 9, 1, 2, 3, 4, 5, 6, 7},
            {2, 3, 4, 5, 6, 7, 8, 9, 1},
            {5, 6, 7, 8, 9, 1, 2, 3, 4},
            {3, 4, 5, 6, 7, 8, 9, 1, 2},
            {6, 7, 8, 9, 1, 2, 3, 4, 5},
            {9, 1, 2, 3, 4, 5, 6, 7, 8},
    };

    /**
     * Generate random incompleted sudoku matrix
     *
     * @param zeros number of empty spots
     * @return incompleted sudoku matrix
     */
    static sudoku gnerate(int zeros) {
        int[][] newMatrix = randomShuffle(solvedMatrix);
        randomFillZero(newMatrix, zeros);
        return new sudoku(newMatrix);
    }

    /**
     * @param m matrix to be shuffled
     */
    static private int[][] randomShuffle(int[][] m) {
        for (int i = 0; i < size; i += 3) {
            randomShuffle3Rows(m, i);
        }
        m = sudoku.transpose(m);
        for (int i = 0; i < size; i += 3) {
            randomShuffle3Rows(m, i);
        }
        return m;
    }

    /**
     * remove some numbers, make it incompleted
     *
     * @param m       matrix to be process
     * @param zeroNum number of numbers to be removed
     */
    static private void randomFillZero(int[][] m, int zeroNum) {
        int x, y, i = 0;
        while (i < zeroNum) {
            x = (int) (Math.random() * size);//[0,size-1]
            y = (int) (Math.random() * size);
            if (m[x][y] == 0) continue;
            m[x][y] = 0;
            i++;
        }
    }

    /**
     * random Shuffle 3 conjacent rows, to preserve the correctness of sudoku
     *
     * @param k start index of 3 rows
     */
    static private void randomShuffle3Rows(int[][] m, int k) {
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = k; i < k + 3; i++) {
            list.add(m[i]);
        }
        Collections.shuffle(list);
        for (int i = 0; i < 3; i++) {
            m[i + k] = list.get(i);
        }
    }
}
