package info.liuxiao;

import info.liuxiao.SQueue;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * info.liuxiao.SQueueTest
 * Created by Sean on 16/1/3.
 */
public class SQueueTest {
    SQueue<Integer> queue = new SQueue<>();

    @Before
    public void setUp() {
        queue.appendTail(1);
        queue.appendTail(2);
        queue.appendTail(3);
    }

    @Test
    public void testAppendTail() {
        assertNotNull(queue);
    }

    @Test
    public void testDeleteHead() {
        assertEquals((Integer) 1, queue.deleteHead());
        assertEquals((Integer) 2, queue.deleteHead());
        assertEquals((Integer) 3, queue.deleteHead());
    }
}
