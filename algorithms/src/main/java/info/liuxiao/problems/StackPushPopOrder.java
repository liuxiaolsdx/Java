package info.liuxiao.problems;

import java.util.Stack;

/**
 * StackPushPopOrder
 * Created by Sean on 16/2/24.
 */
public class StackPushPopOrder {
    /**
     * 题目22:栈的压入、弹出序列
     * 输入两个整数序列,第一个序列表示栈的压入顺序,请判断第二个序列是否为该栈的弹出顺序.假设压入栈的所有数字均不相等.
     * 例如序列1,2,3,4,5是某栈的压栈的序列,序列4,5,3,2,1是该压栈序列对应的一个弹出序列,
     * 但4,3,5,1,2就不可能是该压栈序列的弹出序列.
     */

    /**
     * 遍历第二个序列,设当前值为pop, pop的值要么为第一序列的栈顶,要么在未压入栈的序列中.
     * 否则返回false.
     * @param org 压入栈的序列
     * @param pop 需要判断的栈
     * @return true: yes
     */
    public static boolean isPopOrder(int[] org, int[] pop) {
        boolean isPopOrder = false;

        if (org != null && pop != null) {

            Stack<Integer> stack = new Stack<>();
            int i = 0;
            int j = 0;

            for(; i < pop.length; i++) {
                while (stack.isEmpty() || pop[i] != stack.peek()) {
                    if (j == org.length) {
                        break;
                    }
                    stack.push(org[j]);
                    j++;
                }
                //此if用于判断内循环是由j == org.length退出还是pop[i] == stack.peek()退出
                if (pop[i] != stack.peek()) {
                    break;
                }
                stack.pop();//说明栈顶值和pop[i]相等,抛掉此值(即这两个值互相消除),并继续遍历pop序列下一个
            }
            if (i == pop.length && stack.isEmpty()) {
                isPopOrder = true;
            }
        }
        return isPopOrder;
    }
}
