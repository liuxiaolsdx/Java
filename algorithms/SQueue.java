import java.util.Stack;

/**
 * Create a Queue by two Stack
 * Created by Sean on 16/1/3.
 */
public class SQueue<T> {
    private Stack<T> stack1;
    private Stack<T> stack2;

    public SQueue(){
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public void appendTail (T node){
        stack1.push(node);
    }

    public T deleteHead () {
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                T node = stack1.pop();
                stack2.push(node);
            }
        }
        //If the stack2 is also empty, which indicate the queue is empty
        if (stack2.isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        SQueue<Integer> queue = new SQueue<>();
        queue.appendTail(1);
        queue.appendTail(2);
        queue.appendTail(3);
        System.out.println(queue.deleteHead());
    }
}
