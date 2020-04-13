package com.company;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * logical interactions of sudoku
 *
 * @author Xiangxin Kong
 * @version 1.0
 */
public class sudoku {
    final static int size = 9;
    public int[][] state = new int[size][size];
    int filled;
    int empty;

    /**
     * Initialize the sudoku with 2d array
     */
    public sudoku(int[][] x) {
        if (x == null || x[0] == null || x.length != size || x[0].length != size) {
            return;
        }
        state = x;
        empty = 0;
        for (int i = 0; i < size; i += 3) {
            for (int c = 0; c < size; c += 3) {
                if (state[i][c] == 0) empty++;
            }
        }
        filled = size * size - empty;
    }

    public sudoku() {
        empty = 0;
        filled = size * size;
    }

    /**
     * Check if the sudoku is completed
     */
    public boolean isCompleted() {
        for (int i = 0; i < size; i += 3) {
            for (int c = 0; c < size; c += 3) {
                if (!checkBox(i, c)) return false;
            }
        }
        return checkLines(state) && checkLines(transpose(state));
    }

    /**
     * Check if the lines are completed
     */
    public boolean checkLines(int[][] x) {
        for (int i = 0; i < size; i++) {
            if (!checkLine(x[i])) return false;
        }
        return true;
    }

    /**
     * check if array x is qualified
     */
    public boolean checkLine(int[] x) {
        Set lineNum = new HashSet();
        for (int value : x) lineNum.add(value);
        return size == lineNum.size() && !lineNum.contains(0);
    }

    public boolean checkBox(int x, int y) {
        Set<Integer> squareNum = new HashSet();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                squareNum.add(state[i + x][j + y]);
            }
        }
        return size == squareNum.size() && !squareNum.contains(0);
    }

    /**
     * take the transpose of the matrix
     */
    public static int[][] transpose(int[][] x) {
        int[][] c = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                c[i][j] = x[j][i];
            }
        }
        return c;
    }
}
