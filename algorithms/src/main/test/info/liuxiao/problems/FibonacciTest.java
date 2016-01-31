package info.liuxiao.problems;

/**
 * FibonacciTest
 * Created by Sean on 16/1/31.
 */

import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciTest {
    private Fibonacci fib = new Fibonacci();

    @Test
    public void testFibonacci() {
        assertEquals(0, fib.fibonacci(0));
        assertEquals(1, fib.fibonacci(1));
        assertEquals(1, fib.fibonacci(2));
        assertEquals(8, fib.fibonacci(6));
        assertEquals(55, fib.fibonacci(10));

    }

    @Test
    public void testFibonacci2() {
        assertEquals(0, fib.fibonacci2(0));
        assertEquals(1, fib.fibonacci2(1));
        assertEquals(1, fib.fibonacci2(2));
        assertEquals(8, fib.fibonacci2(6));
        assertEquals(55, fib.fibonacci2(10));

    }

}
