package info.liuxiao.problems;

/**
 * SMath
 * Created by Sean on 16/2/2.
 */
public class SMath {
    /**
     * 题目:实现数值的整数次方.
     */
    public static double power(double base, int exponent) {
        double result = 1.0;
        if (Math.abs(base - 0.0) < 0.0000001) {//note: base maybe equal 0 when exponent is negative.
            return 0.0;
        }

        int absExponent = exponent < 0 ? -exponent : exponent;

        for (int i = 0; i < absExponent; i++) {
            result *= base;
        }
        return exponent < 0 ? 1 / result : result;
    }
}
