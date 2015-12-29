/**
 * Created by Sean on 15/12/26.
 */

public class BulbSwitcher {
    /*
    There are n bulbs that are initially off.
    You first turn on all the bulbs.
    Then, you turn off every second bulb.
    On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on).
    For the nth round, you only toggle the last bulb.
    Find how many bulbs are on after n rounds.
    题目:
    有n盏初始处于关闭状态的灯泡。
    你首先打开所有的灯泡。
    然后，熄灭所有序号为2的倍数的灯泡。
    第三轮，切换所有序号为3的倍数的灯泡（开着的就关掉，关着的就打开）。
    第n轮，你只切换最后一只灯泡。计算n轮之后还有几盏灯泡亮着。
     */

    /*
    我们知道，每当灯泡会改变状态，也就是 toggle 时，是因为它出现在了某个数的整数倍上。
    对于第1个灯泡：1*1，会改变1次状态，即 off -> on
    对于第2个灯泡：1*2，2*1，会改变2次状态，即 off -> on -> off
    对于第3个灯泡：1*3，3*1，会改变2次状态，即 off -> on ->off
    对于第4个灯泡：1*4，2*2，4*1，会改变3次状态，即 off -> on -> off -> on

    除了完全平方数,其它数的因子都是成对出现的.
    所以求n个灯泡,n轮后还亮着的灯泡数的问题,转换为求0~n中有几个完全平方数.
     */

    public int buldSwitch(int n) {
        return (int) Math.sqrt(n);
    }
}
