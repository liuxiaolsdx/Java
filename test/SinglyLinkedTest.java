/**
 * Created by Sean on 15/12/29.
 */

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SinglyLinkedTest {
    SinglyLinked<Integer> sl;
    @Before
    public void setUp(){
        sl = new SinglyLinked<>();
        sl.addHead(1);
        sl.addTail(4);
        sl.insert(1,2);
        sl.insert(2,3);
    }
    @Test
    public void testPrintSinglyLinked(){
        assertNotNull(sl);
        sl.printSinglyLinked();
        System.out.println("删除第二个结点后的单链表:");
        sl.delete(2);
        sl.printSinglyLinked();
    }
    @Test
    public void testPrintListReversingly_Iterativly(){
        sl.printListReversingly_Iterativly();
    }
    @Test
    public void testPrintListReversingly_Recursively(){
        sl.printListReversingly_Recursively(sl.head);
    }
}
