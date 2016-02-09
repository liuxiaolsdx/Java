package info.liuxiao;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * info.liuxiao.BinarySearchTest
 * Created by Sean on 16/1/4.
 */
public class BinarySearchTest {
    private int[] a = {1, 3, 10, 13, 16, 20, 24, 37, 50, 77};

    @Test(expected = IllegalArgumentException.class)
    public void testBinarySearch() {
        assertTrue(BinarySearch.search(a, 0, a.length - 1, 1));
        assertTrue(BinarySearch.search(a, 0, a.length - 1, 77));
        assertTrue(BinarySearch.search(a, 0, a.length - 1, 16));
        assertFalse(BinarySearch.search(a, 0, a.length - 1, 11));
        assertFalse(BinarySearch.search(null, 0, a.length - 1, 13));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBinarySearch2() {
        assertTrue(BinarySearch.search2(a, 0, a.length - 1, 1));
        assertTrue(BinarySearch.search2(a, 0, a.length - 1, 77));
        assertTrue(BinarySearch.search2(a, 0, a.length - 1, 16));
        assertFalse(BinarySearch.search2(a, 0, a.length - 1, 11));
        assertFalse(BinarySearch.search2(null, 0, a.length - 1, 13));
    }

}
