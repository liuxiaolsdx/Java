package info.liuxiao;

import java.util.Stack;

/**
 * Created by Sean on 15/12/29.
 */
public class SinglyLinked<T> {
    //单链表的结点类
    public class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this(data, null);
        }

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    int size = 0;
    transient Node<T> head, tail;

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
        if (isEmpty()) {
            return 0;
        } else {
            int count = 1;
            Node<T> current = head;
            while (current != tail) {
                current = current.next;
                count++;
            }
            return count;
        }
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
}
