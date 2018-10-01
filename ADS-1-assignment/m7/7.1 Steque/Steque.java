import java.util.*;
/**
 * Class for steque.
 */
class Steque {
    /**
     * Class for node.
     */
    private class Node {
        int data;
        Node next;
    }
    Node front, next, rear;
    int size = 0;
    /**
     * push method is used to push the elements into linked list from the 
     * left side we can consider it as the top of the stack.
     * Worst case: O(1)
     * Best case: O(1)
     * Average case: O(1)
     *
     * @param      data  The data
     */
    public void push(int data) {
        Node node = new Node();
        node.data = data;
        node.next = front;
        if (front == null) {
            rear = node;
        }
        front = node;
        //print();
        size++;
    }
    /**
     * enqueue is used to push the elements into linked list from the back 
     * end.
     * Worst case: O(1)
     * Best case: O(1)
     * Average case: O(1)
     *
     * @param      data  The data
     */
    public void enqueue(int data) {
        if (front == null || rear == null) {
            push(data);
        } else {
            Node node = new Node();
            node.data = data;
            rear.next = node;
            rear = node;
            //print();
        }
        size++;
    }
    /**
     * it removes the element from the linked list and prints the remaining
     * elements.
     * Worst case: O(1)
     * Best case: O(1)
     * Average case: O(1)
     */
    public void pop() {
        if (front == null) {
            //System.out.println("Steque is empty.");
        } else {
            try {
                front = front.next;
                //print();
            } catch (Exception E) {
                //System.out.println("Steque is empty.");
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