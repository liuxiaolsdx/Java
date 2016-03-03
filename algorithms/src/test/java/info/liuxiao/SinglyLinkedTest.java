package info.liuxiao;
/**
 * SinglyLinked Test
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
        System.out.println("从尾到头反向打印单链表:");
        sl.printListReversingly_Recursively(sl.head);
    }

    @Test
    public void testDeleteNode() {
        sl.deleteNode(sl.search(1));
        System.out.println("删除头结点后的单链表:");
        sl.printSinglyLinked();
    }

    @Test
    public void testDeleteNode2() {
        sl.deleteNode(sl.search(4));
        System.out.println("删除尾结点后的单链表:");
        sl.printSinglyLinked();
    }

    @Test
    public void testDeleteNode3() {
        sl.deleteNode(sl.search(4));
        System.out.println("删除第二个结点后的单链表:");
        sl.printSinglyLinked();
    }

    @Test
    public void testFindKthToTail() {
        assertEquals(1, sl.findKthToTail(4).getData());
        assertEquals(3, sl.findKthToTail(2).getData());
        assertEquals(4, sl.findKthToTail(1).getData());
        assertNull(sl.findKthToTail(5));
        assertNull(sl.findKthToTail(10));
    }

    @Test
    public void testReverseList() {
        sl.reverseList();
        sl.printSinglyLinked();
    }
}
