import java.util.*;
import java.lang.StringBuilder;

class Node {
	protected int data;
	protected Node link;

	public Node() {
		link = null;
		data = 0;
	}
	public Node(int d, Node n) {
		data = d;
		link = n;
	}
	public void setLink(Node n) {
		link = n;
	}
	public void setData(int d) {
		data = d;
	}
	public Node getLink() {
		return link;
	}	public int getData() {
		return data;
	}
}

class StackLinkedList {
	protected Node top ;
	protected int size ;

	public StackLinkedList() {
		top = null;
		size = 0;
	}
	public boolean isEmpty() {
		return top == null;
	}
	public int getSize() {
		return size;
	}
	public void listPush(int data) {
		Node nptr = new Node (data, null);
		if (top == null)
			top = nptr;
		else {
			nptr.setLink(top);
			top = nptr;
		}
		size++ ;
	}
	public int listPop() {
		Node ptr = top;
		top = ptr.getLink();
		size-- ;
		return ptr.getData();
	}
	public String display() {
		String str = "";
		Node ptr = top;
		while (ptr != null) {
			str += "" + ptr.getData();
			ptr = ptr.getLink();
		}
		return str;
	}
}

class AddLargeNumbers {

	public static StackLinkedList numberToDigits(String number) {
		StackLinkedList li = new StackLinkedList();
		String[] list = number.split("");
		for (int i = 0; i < list.length; i++) {
            li.listPush(Integer.parseInt(list[i]));
        }
		return li;
	}

	public static String digitsToNumber(StackLinkedList list) {
		String str = "";
		str = list.display();
		StringBuilder st = new StringBuilder();
		st.append(str);
		str=""+st.reverse();
		return str;
	}

	public static StackLinkedList addLargeNumbers(StackLinkedList list1, StackLinkedList list2) {
		StackLinkedList ans = new StackLinkedList();
		return ans;
	}
}

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String p = sc.nextLine();
		String q = sc.nextLine();
		switch (input) {
		case "numberToDigits":
			StackLinkedList pDigits = AddLargeNumbers.numberToDigits(p);
			StackLinkedList qDigits = AddLargeNumbers.numberToDigits(q);
			System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
			System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
			break;

		case "addLargeNumbers":
			pDigits = AddLargeNumbers.numberToDigits(p);
			qDigits = AddLargeNumbers.numberToDigits(q);
			StackLinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
			System.out.println(AddLargeNumbers.digitsToNumber(result));
			break;
		}
	}

}