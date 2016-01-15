package info.liuxiao;

import java.util.LinkedList;
import java.util.Queue;

/**
 * stack with two queue
 * Created by Sean on 16/1/7.
 */
public class SStack<T> {
    private Queue<T> queue1;
    private Queue<T> queue2;

    public SStack() {
        this.queue1 = new LinkedList<>();
        this.queue2 = new LinkedList<>();
    }

    public boolean push(T node) {
        return queue1.add(node);
    }

    public T pop() {
        int que1size = queue1.size();
        int que2size = queue2.size();

        if (que1size != 0) {
            for (int i = 1; i < que1size; i++) {
                queue2.add(queue1.poll());
            }
            return queue1.poll();
        } else {//queue1 is empty

            if (que2size == 0) {
                return null;//the stack is empty
            } else {
                for (int i = 1; i < que2size; i++) {
                    queue1.add(queue2.poll());
                }
                return queue2.poll();
            }

        }

    }
}
