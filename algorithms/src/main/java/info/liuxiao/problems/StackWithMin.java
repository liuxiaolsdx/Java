package info.liuxiao.problems;

import java.util.Comparator;
import java.util.Stack;

/**
 * StackWithMin
 * Created by Sean on 16/2/23.
 */
public class StackWithMin<T extends Comparator<T>> {
    /**
     * 题目21: 包含min函数的栈
     * 定义栈的数据结构,请在该类型中实现一个能够得到栈的最小元素的min函数.
     * 在该栈中,调用min、push及pop的时间复杂度都是O(1).
     *
     * 笔记:当想减小时间复杂度,可以从增加空间复杂度来思考.
     */
    /**
     * 解法:增加一个辅助栈,存放每次压入元素时,此状态时候的最小值.
     * 即每次往栈里压入新元素,将辅助栈栈顶元素(之前最小值)与新元素比较,最小的也同时压入辅助栈.
     */
    private Stack<T> dataStack;
    private Stack<T> minStack;

    public StackWithMin() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

}
