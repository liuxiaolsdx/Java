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

        //for (int i = 0; i < absExponent; i++) {
        //    result *= base;
        //}
        result = powerWithUnsignedExponet(base, absExponent);
        return exponent < 0 ? 1 / result : result;
    }

    /**
     * 一个数的正整数次方可以用二分法来降低运算时间,从O(n) -> O(logn)
     * 对于a^x,当x为偶数时,即a^(x/2) * a^(x/2);当x为奇数时,即a^[(x-1)/2] * a^[(x-1)/2] * a
     * @param base 底
     * @param exponent 指数
     * @return 结果
     */
    public static double powerWithUnsignedExponet(double base, int exponent) {
        if (exponent == 0)
            return 1;
        if (exponent == 1)//递归结束条件
            return base;

        double result = powerWithUnsignedExponet(base, exponent/2);

        result *= result;

        if (exponent%2 != 0) {
            result *= base;
        }
        return result;
    }
}
