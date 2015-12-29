/**
 * Created by Sean on 15/12/29.
 */

import org.junit.Test;
import static org.junit.Assert.*;

public class SinglyLinkedTest {

    @Test
    public void test(){
        SinglyLinked<Integer> sl = new SinglyLinked<>();
        sl.addHead(1);
        sl.addTail(4);
        sl.insert(1,2);
        sl.insert(2,3);
        sl.printSinglyLinked();
        assertNotNull(sl);
        System.out.println("删除第二个结点后的单链表:");
        sl.delete(2);
        sl.printSinglyLinked();
    }
}
