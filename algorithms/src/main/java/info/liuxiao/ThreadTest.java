package info.liuxiao;

/**
 * sleep()睡眠时,会保持对象锁
 * wait()睡眠时,会释放对象锁.
 * wiat()必须放在synchronized block中，否则会在program runtime时扔出”java.lang.IllegalMonitorStateException“异常。
 * Created by Sean on 16/3/6.
 */
public class ThreadTest implements Runnable{
    int number = 10;

    public void firstFunc() {
        synchronized (this) {
            number += 100;
            System.out.println(number);
        }
    }

    public void secondFunc() throws InterruptedException {
        synchronized (this) {
           Thread.sleep(2000);
            //this.wait(2000);
            number *= 200;
        }
    }

    @Override
    public void run() {
        firstFunc();
    }

    /*
    因为在主线程中调用方法，所以调用的普通方法secondFunc()会先被执行,
    但并不是普通方法执行完毕该对象的线程方法才执行，普通方法执行过程中，该线程的方法也会被执行，
    他们是交替执行的，只是在主线程的普通方法会先被执行而已.
     */
    public static void main(String[] args) throws InterruptedException {
        ThreadTest threadTest = new ThreadTest();
        Thread thread = new Thread(threadTest);
        thread.start();
        threadTest.secondFunc();
        System.out.println("number="+threadTest.number);
    }
}
