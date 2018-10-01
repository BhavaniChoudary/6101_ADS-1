import java.util.*;
class Steque {
    private class Node {
        int data;
        Node next;
    }
    Node front, next, rear;
    int size = 0;
    public void push(int data) {
        Node node = new Node();
        node.data = data;
        node.next = front;
        if (front == null) {
            rear = node;
        }
        front = node;
        size++;
    }
    public void enqueue(int data) {
        if (front == null || rear == null) {
            push(data);
        } else {
            Node node = new Node();
            node.data = data;
            rear.next = node;
            rear = node;
        }
        size++;
    }
    public void pop() {
        if (front == null) {
        } else {
            try {
                front = front.next;
            } catch (Exception E) {
            }
        }
        size--;
    }
    /**
     * prints the elements in the linked list considering frontf as the starting psotion.
     * Worst case: O(N)
     * Best case: O(N)
     * Average case: O(N)
     */
    public void print() {
        Node tfront = front;
        try{
        while (tfront != null && tfront.next != null) {
            System.out.print(tfront.data + ", ");
            tfront = tfront.next;
        }
        System.out.println(tfront.data);
} catch(Exception e) {
        System.out.println("Steque is empty.");
    }
}
}