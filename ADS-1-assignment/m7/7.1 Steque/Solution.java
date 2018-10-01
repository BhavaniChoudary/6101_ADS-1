import java.util.*;
class Steque {
	private class Node {
		int data;
		Node next;
	}
	Node head, next, tail;
	public void push(int data) {
	// Node node = new Node();
	// node.data = data;
	// node.next = head;
	// if (head == null) {
	// tail = node;
	// }
	// head = node;
	Node node = new Node();
	node.data = data;
	node.next = head;
	if (head == null) tail = node;
	head = node;
	print();
}
public void enqueue(int data) {
	Node node = new Node();
	if (head == null) {
	push(data);
	} else {
		node.data = data;
		tail.next = node;
		node.next = null;
		tail = node;
	}
	print();
}
public void pop() { 
	if (head == null) {
		System.out.println("Steque is empty");
	} else {
		head = head.next;
		print();
	}
}
public void print() {
	Node thead = head;
	// while (thead != null) {
	// System.out.print(thead.data);
	// thead = thead.next;
	// }
	while (thead != null && thead.next != null) {
		System.out.print(thead.data + ", ");
		thead = thead.next;
	}
	System.out.println(thead.data);
}
}
class Solution {
	public static void main(String[] args) {
		Steque li = new Steque();
		li.push(1);
		//System.out.println("asdjhfgjshadfg");
		li.push(2);
		li.push(5);
		li.enqueue(3);
		li.pop();
		li.enqueue(4);
		li.pop();
		li.pop();
		li.pop();
		li.pop();
		// li.pop();
	}
}