package info.liuxiao;

import java.util.Stack;

/**
 * Singly Linked list
 * Created by Sean on 15/12/29.
 */
public class SinglyLinked<T> {
    //单链表的结点类
    public class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data) {
            this(data, null);
        }

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        public E getData() {
            return data;
        }
    }

    int size = 0;
    transient Node<T> head, tail;//transient 关键字:不需要序列化

    //构造一个空单链表
    public SinglyLinked() {
        head = tail = null;
        size = 0;
    }

    //单链表是否为空
    public boolean isEmpty() {
        return null == this.head;
    }

    //单链表的大小
    public int size() {
        //if (isEmpty()) {
        //    return 0;
        //} else {
        //    int count = 1;
        //    Node<E> current = head;
        //    while (current != tail) {
        //        current = current.next;
        //        count++;
        //    }
        //    return count;
        //}
        return size;
    }

    //为单链表添加头结点
    public void addHead(T item) {
        head = new Node<>(item);
        if (null == tail) {
            tail = head;
            size += 1;
        }
    }

    //为单链表添加尾结点
    public void addTail(T item) {
        Node<T> node = new Node<>(item);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail = node;
            head.next = tail;
            size += 1;
        }
    }

    //在指定位置插入结点
    public void insert(int index, T item) {
        Node<T> newNode = new Node<>(item);
        Node<T> current = this.search(index);
        newNode.next = current.next;
        current.next = newNode;
        size += 1;
    }

    public void deleteHead() throws NullPointerException {
        head = head.next;
        size -= 1;
    }

    public void deleteTail() {
        delete(size);
    }

    //删除指定位置的结点
    public void delete(int index) {
        Node<T> current = this.search(index);
        if (current == head) {
            deleteHead();
        } else {
            Node<T> preNode = this.search(index - 1);
            preNode.next = current.next;
            size -= 1;
        }
    }

    //找到指定位置的结点
    public Node<T> search(int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        return current;
    }

    //在单链表中查找结点中数据等于item的结点
    public Node<T> search(T item) {
        if (isEmpty() || item == null) {
            return null;
        }
        Node<T> current = this.head;
        while (current != this.tail) {
            if (current.data == item) {
                return current;
            } else {
                current = current.next;
            }
        }
        return null;
    }

    //正向打印单链表
    public void printSinglyLinked() {
        if (isEmpty()) {
            System.out.println("singly linked list size: 0");
        } else {
            System.out.println("singly linked list size: " + this.size);
            for (int i = 0; i < size; i++) {
                System.out.println("data:" + search(i + 1).data);
            }
        }
    }

    //反向打印单链表,栈数据结构实现
    public void printListReversingly_Iterativly(){
        if (isEmpty()) {
            System.out.println("singly linked list size: 0");
        } else {
            Node<T> current = head;
            Stack<Node<T>> nodes = new Stack<>();
            while (current != null){
                nodes.push(current);
                current = current.next;
            }
            System.out.println("从尾到头反向打印单链表:");
            while (!nodes.isEmpty()){
                current = nodes.pop();
                System.out.println("data:" + current.data);
            }
        }
    }

    //反向打印单链表,递归实现
    public void printListReversingly_Recursively(Node<T> head){
        if (!isEmpty()) {
            if (null == head)
                return;
            printListReversingly_Recursively(head.next);
            System.out.println("data:" + head.data);
        }
    }

    /**
     * 题目: 给定单向链表的头指针和一个结点指针,定义一个函数在O(1)时间删除该结点.
     */
    /**
     * 索引从1开始
     * Created by Sean on 16/2/8.
     * @param toBeDelete will be deleted
     */
    public void deleteNode(Node<T> toBeDelete) {
        //如果要删除的结点是尾结点
        if (toBeDelete.next == null) {
            deleteTail();
            return;
        }
        //如果单链表中只有一个结点
        if (size == 1) {
            head = null;
            size -= 1;
            return;
        }
        toBeDelete.data = toBeDelete.next.data;
        toBeDelete.next = toBeDelete.next.next;
        size -= 1;

    }

    /**
     * 题目15:链表中倒数第K个结点
     * 输入一个链表,输出该链表中倒数第K个结点.为了符合大多数人到习惯,本题从1开始计数,即链表到尾结点是倒数第1个结点.
     * 例如一个链表有6个几点,从头结点开始它们的值依次是1,2,3,4,5,6这个链表的倒数第3个结点是值为4的结点.
     */
    /**
     * (无size成员变量,所以需要从头遍历整个链表先求出链表的大小n,然后再去求第n-k+1.时间复杂度最坏会到O(n^2))
     * 如果采用两个指针,则只需遍历一次.
     * 1. 指针1从头开始前进k-1,指针2在链表头保持不动.
     * 2. 从第k步开始,第二个指针也开始从链表头开始遍历.
     * 因为这两个指针的距离保持在k-1,当指针1到链表最后时,指针2指向的正好是这个链表的倒数第k个结点.
     */
    /**
     * 注:此函数不用此类的部分成员变量和函数
     * @param k 倒数第k个结点
     */
    public Node findKthToTail(int k) {
        if (k < 1) {
            throw new RuntimeException("K must more than 0!");
        }

        if (head == null) {
            return null;
        }

        Node preIndex = head;
        Node nextIndex = head;

        for (int i = 0; i < k - 1; i++) {

            preIndex = preIndex.next;
            //如果k大于链表的长度,则抛出异常.
            if (preIndex == null) {
                //throw new RuntimeException("K is more than likedList size.");
                return null;//for convenient test
            }
        }
        while (preIndex.next != null) {
            preIndex = preIndex.next;
            nextIndex = nextIndex.next;
        }
        return nextIndex;
    }

    /**
     * 题目16: 反转链表
     * 定义一个函数,输入一个链表的头结点,反转该链表并输出反转后链表的头结点.
     */
}
