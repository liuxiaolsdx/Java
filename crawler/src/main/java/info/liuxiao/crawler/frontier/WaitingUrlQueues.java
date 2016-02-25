package info.liuxiao.crawler.frontier;

import java.util.LinkedList;

/**
 * 存放等待访问的url队列
 * Created by Sean on 16/2/25.
 */
public class WaitingUrlQueues {
    //频繁增加和删除
    private static LinkedList<String> waitingUrlQueues = new LinkedList<>();

    public static void add(String url) {
        waitingUrlQueues.add(url);
    }

    //获得url
    public static String poll() {
        return waitingUrlQueues.poll();
    }

    public static boolean remove(String url) {
        return waitingUrlQueues.remove(url);
    }

    public static boolean contains(String url) {
        return waitingUrlQueues.contains(url);
    }

    public static int size() {
        return waitingUrlQueues.size();
    }

    public static boolean isEmpty() {
        return waitingUrlQueues.isEmpty();
    }
}
