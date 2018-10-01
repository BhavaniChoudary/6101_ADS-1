import java.util.*;
class Steque {
    private class Node {
        int data;
        Node next;
    }
    Node head, next, tail;
    int size = 0;
    public void push(int data) {
        Node node = new Node();
        node.data = data;
        node.next = head;
        if (head == null) {
            tail = node;
        }
        head = node;
        size++;
    }
    public void enqueue(int data) {
        if (head == null || tail == null) {
            push(data);
        } else {
            Node node = new Node();
            node.data = data;
            tail.next = node;
            tail = node;
        }
        size++;
    }
    public void pop() {
        if (head == null) {
        } else {
            try {
                head = head.next;
            } catch (Exception E) {
            }
        }
        size--;
    }
    /**
     * prints the elements in the linked list considering headf as the starting psotion.
     * Worst case: O(N)
     * Best case: O(N)
     * Average case: O(N)
     */
    public void print() {
        Node thead = head;
        try{
        while (thead != null && thead.next != null) {
            System.out.print(thead.data + " ");
            thead = thead.next;
        }
        System.out.println(thead.data);
} catch(Exception e) {
        System.out.println("Steque is empty.");
    }
}
}