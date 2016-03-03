package info.liuxiao.problems;

import org.junit.Assert;
import org.junit.Test;

/**
 * MathTest
 * Created by Sean on 16/2/2.
 */
public class MathTest {

    @Test
    public void testPower() {
        Assert.assertTrue(Math.abs(SMath.power(0, 0) - 0) < 0.0000001);
        Assert.assertTrue(Math.abs(SMath.power(0, 5) - 0) < 0.0000001);
        Assert.assertTrue(Math.abs(SMath.power(5, 0) - 1) < 0.0000001);
        Assert.assertTrue(Math.abs(SMath.power(2, 3) - 8) < 0.0000001);
        Assert.assertTrue(Math.abs(SMath.power(-2, 3) - (-8)) < 0.0000001);
        Assert.assertTrue(Math.abs(SMath.power(2, -3) - 0.125) < 0.0000001);
        Assert.assertTrue(Math.abs(SMath.power(-2, -3) - (-0.125)) < 0.0000001);
        Assert.assertTrue(Math.abs(SMath.power(2.2, 3) - 10.648) < 0.0000001);
    }
}
