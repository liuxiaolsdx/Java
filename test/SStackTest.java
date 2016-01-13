import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * SStack Test
 * Created by Sean on 16/1/7.
 */
public class SStackTest {
    SStack<Integer> sStack = new SStack<>();

    @Before
    public void setsStack() {
        sStack.push(1);
        sStack.push(2);
        sStack.push(3);
    }

    @Test
    public void testPush() {
        Assert.assertNotNull(sStack);
    }

    @Test
    public void testPop() {
        Assert.assertEquals((Integer) 3, sStack.pop());
        Assert.assertEquals((Integer) 2, sStack.pop());
        Assert.assertEquals((Integer) 1, sStack.pop());
    }

    @Test
    public void testPopAndPush() {
        Assert.assertEquals((Integer) 3, sStack.pop());
        sStack.push(4);
        Assert.assertEquals((Integer) 4, sStack.pop());
        Assert.assertEquals((Integer) 2, sStack.pop());
        Assert.assertEquals((Integer) 1, sStack.pop());
    }
}
