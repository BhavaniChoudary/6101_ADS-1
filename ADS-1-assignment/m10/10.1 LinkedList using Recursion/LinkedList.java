class LinkedList<E> {
    private class Node {
        E data;
        Node next;
    }
    Node head, tail;
    Node thead = head;
    int count = 0;
    int size = 0;
    public void addAtHead(E data) {
        Node node = new Node();
        node.data = data;
        node.next = head;
        if (head == null) tail = node;
        head = node;
        size++;
        print();
        thead = head;
    }
    public void insertAt(int index, E data) {
        try {
            if (index >= 0 && index >= size ) {
                if (index == 0) {
                    addAtHead(data);
                    return;
                }
                if (count == index - 1) {
                    Node node = new Node();
                    node.data = data;
                    node.next = thead.next;
                    thead.next = node;
                    size++;
                    print();
                    thead = head;
                    // }
                } else {
                    count++;
                    if (thead.next != null) {
                        thead = thead.next;
                    }
                    insertAt(index, data);
                }
            } else {
                throw new IndexOutOfBoundsException();
            }
        } catch (Exception e) {
            System.out.println("Can't insert at this position.");
            thead = head;
        }
    }
    public void print() {
        Node thead = head;
        while (thead != null && thead.next != null) {
            System.out.print(thead.data + ", ");
            thead = thead.next;
        }
        System.out.println(thead.data);
        count = 0;
    }
    void reverse() {
        head = reverseHelper(head);
        thead = head;
        print();
    }
    Node reverseHelper(Node head) {
        if (head == null || head.next == null) {
         return head;
            }
        Node ahead = reverseHelper(head.next);
        head.next.next = head;
        head.next = null;
        return ahead;
    }
}