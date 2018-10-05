class LinkedList<E> {
    private class Node {
        E data;
        Node next;
    }
    Node head, tail;
    Node head1 = head;
    int count = 0;
    int size = 0;
    public void addAhead1(E data) {
        Node node = new Node();
        node.data = data;
        node.next = head;
        if (head == null) tail = node;
        head = node;
        size++;
        print();
        head1 = head;
    }
    public void insertAt(int index, E data) {
        try {
            if (index >= 0 && index <= size ) {
                if (index == 0) {
                    addAhead1(data);
                    return;
                }
                if (count == index - 1) {
                    Node node = new Node();
                    node.data = data;
                    node.next = head1.next;
                    head1.next = node;
                    size++;
                    print();
                    head1 = head;
                    // }
                } else {
                    count++;
                    if (head1.next != null) {
                        head1 = head1.next;
                    }
                    insertAt(index, data);
                }
            } else {
                throw new IndexOutOfBoundsException();
            }
        } catch (Exception e) {
            System.out.println("Can't insert at this position.");
            head1 = head;
        }
    }
    public void print() {
        Node head1 = head;
        while (head1 != null && head1.next != null) {
            System.out.print(head1.data + ", ");
            head1 = head1.next;
        }
        System.out.println(head1.data);
        count = 0;
    }
    void reverse() {
        head = reverseHelper(head);
        head1 = head;
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