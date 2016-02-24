package info.liuxiao.crawler.frontier;

import java.util.HashSet;

/**
 * 存放已经访问了的url
 * Created by Sean on 16/2/25.
 */
public class OutUrlQueues {
    private static HashSet<String> outQueues = new HashSet<>();
    //被static修饰的成员变量和成员方法独立于该类的任何对象。也就是说，它不依赖类特定的实例，被类的所有实例共享。

    public static void add(String url) {
        outQueues.add(url);
    }
    //删除一个已访问的url
    public static boolean remove(String url) {
        return outQueues.remove(url);
    }
    //已访问的队列中是否存在此url
    public static boolean contains(String url) {
        return outQueues.contains(url);
    }
    //已访问的队列的大小
    public static int size() {
        return outQueues.size();
    }
}
