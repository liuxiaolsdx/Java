package info.liuxiao.problems;

import org.junit.Assert;
import org.junit.Test;

/**
 * StackWithMinTest
 * Created by Sean on 16/2/24.
 */
public class StackWithMinTest {
    @Test
    public void testMin() {
        StackWithMin<Integer> stack = new StackWithMin<>();
        stack.push(3);
        Assert.assertEquals((Integer) 3, stack.min());
        stack.push(4);
        Assert.assertEquals((Integer) 3, stack.min());
        stack.push(2);
        Assert.assertEquals((Integer) 2, stack.min());
        stack.pop();
        Assert.assertEquals((Integer) 3, stack.min());
        stack.pop();
        Assert.assertEquals((Integer) 3, stack.min());
        stack.push(0);
        Assert.assertEquals((Integer) 0, stack.min());
    }
}
