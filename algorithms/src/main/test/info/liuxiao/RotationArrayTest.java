package info.liuxiao;

import info.liuxiao.RotationArray;
import org.junit.Assert;
import org.junit.Test;

/**
 * info.liuxiao.RotationArrayTest
 * Created by Sean on 16/1/13.
 */
public class RotationArrayTest {
    private int[] arr = {3, 4, 5, 1, 2};
    private int[] arr2 = {4, 5, 6, 6, 6, 7, 8, 1, 2, 3};
    private int[] arr3 = {1, 2, 3, 4, 5, 6, 7, 9};
    private int[] arr4 = {1, 2, 3, 3, 4, 4, 5, 6, 7};
    private int[] arr5 = {1};
    private int[] arr6 = {3, 5, 6, 6, 6, 7, 8, 1, 2, 3};
    private int[] arr7 = {1, 0, 1, 1, 1};
    private int[] arr8 = {1, 1, 1, 0, 1};

    @Test
    public void testMin() {
        Assert.assertEquals(1, RotationArray.min(arr, 0, arr.length - 1));
        Assert.assertEquals(1, RotationArray.min(arr2, 0, arr2.length - 1));
        Assert.assertEquals(1, RotationArray.min(arr3, 0, arr3.length - 1));
        Assert.assertEquals(1, RotationArray.min(arr4, 0, arr4.length - 1));
        Assert.assertEquals(1, RotationArray.min(arr5, 0, arr5.length - 1));
        Assert.assertEquals(1, RotationArray.min(arr6, 0, arr6.length - 1));
        Assert.assertEquals(0, RotationArray.min(arr7, 0, arr7.length - 1));
        Assert.assertEquals(0, RotationArray.min(arr8, 0, arr8.length - 1));
    }

    @Test
    public void testMin2() {
        Assert.assertEquals(1, RotationArray.min2(arr, 0, arr.length - 1));
        Assert.assertEquals(1, RotationArray.min2(arr2, 0, arr2.length - 1));
        Assert.assertEquals(1, RotationArray.min2(arr3, 0, arr3.length - 1));
        Assert.assertEquals(1, RotationArray.min2(arr4, 0, arr4.length - 1));
        Assert.assertEquals(1, RotationArray.min2(arr5, 0, arr5.length - 1));
        Assert.assertEquals(1, RotationArray.min2(arr6, 0, arr6.length - 1));
        Assert.assertEquals(0, RotationArray.min2(arr7, 0, arr7.length - 1));
        Assert.assertEquals(0, RotationArray.min2(arr8, 0, arr8.length - 1));
    }

}
