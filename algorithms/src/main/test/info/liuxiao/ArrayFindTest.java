package info.liuxiao;

/**
 * Created by Sean on 15/12/26.
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayFindTest {
    private int[][] A = {{1, 2, 8, 9},
            {2, 4, 9, 12},
            {4, 7, 10, 13},
            {6, 8, 11, 15}};

    @Test
    public void findTest() {
        assertTrue(ArrayFind.find(A, A.length, A[0].length, 1));
        assertTrue(ArrayFind.find(A, A.length, A[0].length, 15));
        assertTrue(ArrayFind.find(A, A.length, A[0].length, 7));

        assertFalse(ArrayFind.find(A, A.length, A[0].length, 20));
        assertFalse(ArrayFind.find(A, A.length, A[0].length, 0));
        assertFalse(ArrayFind.find(A, A.length, A[0].length, 5));

        int[][] B = null;
        assertFalse(ArrayFind.find(B, 0, 0, 7));
    }
}
