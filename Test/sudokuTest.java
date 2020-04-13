import com.company.sudoku;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class sudokuTest {
    static int t0[][] = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
    };

    //t1[1], t[*][5], block[0][6]
    static int t1[][] = {
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {1, 2, 3, 4, 5, 5, 4, 5, 6},
            {1, 2, 3, 4, 5, 4, 1, 2, 3},
            {1, 2, 3, 4, 5, 3, 7, 8, 9},
            {1, 2, 3, 4, 5, 2, 7, 8, 9},
            {1, 2, 3, 4, 5, 1, 7, 8, 9},
            {1, 2, 3, 4, 5, 9, 7, 8, 9},
            {1, 2, 3, 4, 5, 8, 7, 8, 9},
            {1, 2, 3, 4, 5, 7, 7, 8, 9},
    };

    //
    static int t3[][] = {
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {1, 0, 3, 4, 5, 6, 7, 8, 9},//diff num with 0
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
    };

    static int t4[][] = {
            {2, 0, 0, 0, 0, 0, 5, 3, 1},
            {0, 3, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 4, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 4},
            {0, 0, 0, 0, 0, 0, 0, 0, 2},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
    };

    static int t5[][] = {
            {2, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 3, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 4, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {5, 0, 0, 0, 0, 0, 0, 0, 0},
            {3, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 4, 2, 0},
    };

    static int t6[][] = {
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

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        //empty
    }

    @Test
    void testInitial() {
        sudoku su = new sudoku();
        assert (Arrays.deepEquals(su.state, t0));

        su = new sudoku(t1);
        assert (Arrays.deepEquals(su.state, t1));

        int arr[][] = {{3,}, {4,}};
        su = new sudoku(arr);
        assert (Arrays.deepEquals(su.state, t0));

        arr = new int[][]{{2, 3}, {4, 5}};
        su = new sudoku(arr);
        assert (Arrays.deepEquals(su.state, t0));
    }

    @Test
    void testTranspose() {
        sudoku su = new sudoku();
        assert (Arrays.deepEquals(su.transpose(t4), t5));
        assert (Arrays.deepEquals(su.transpose(t5), t4));
        assert (Arrays.deepEquals(su.transpose(t0), t0));
        assert (Arrays.deepEquals(su.transpose(su.transpose(t1)), t1));
    }

    @Test
    void testCheckLine() {
        sudoku su = new sudoku();
        su.checkLine(t1[0]);
        su.checkLine(t0[0]);
        assert (su.checkLine(t1[0]));
        assertFalse(su.checkLine(t5[0]));
        assertFalse(su.checkLine(t3[1]));
    }

    @Test
    void testCheckBox() {
        sudoku su = new sudoku(t1);
        assert (su.checkBox(0, 6));
    }

    @Test
    void testCheckall() {
        sudoku su = new sudoku(t6);
        assert (su.isCompleted());
    }

}