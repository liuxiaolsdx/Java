package info.liuxiao.problems;


import org.junit.Assert;
import org.junit.Test;

/**
 * StackPushPopOrderTest
 * Created by Sean on 16/2/29.
 */
public class StackPushPopOrderTest {
    @Test
    public void testIsPopOrder() {
        int[] org1 = {1, 2, 3, 4, 5};
        int[] org2 = {2};
        int[] pop1 = {2};
        int[] pop2 = {4, 5, 3, 2, 1};
        int[] pop3 = {4, 3, 5, 1, 2};
        Assert.assertFalse(StackPushPopOrder.isPopOrder(org1, pop1));
        Assert.assertTrue(StackPushPopOrder.isPopOrder(org2, pop1));
        Assert.assertFalse(StackPushPopOrder.isPopOrder(org2, pop2));
        Assert.assertTrue(StackPushPopOrder.isPopOrder(org1, pop2));
        Assert.assertFalse(StackPushPopOrder.isPopOrder(org1, pop3));
        Assert.assertFalse(StackPushPopOrder.isPopOrder(null, null));
    }
}
