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
	public void setData(int d) {
		data = d;
	}
	public int getData() {
		return data;
	}
	public void setLink(Node n) {
		link = n;
	}
	public Node getLink() {
		return link;
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
	/**
	 * function_description.
	 *
	 * @param      number  The number
	 *
	 * @return     { description_of_the_return_value }
	 */
	public static StackLinkedList numberToDigits(final String number) {
		StackLinkedList link1 = new StackLinkedList();
		String[] list = number.split("");
		for (int i = 0; i < list.length; i++) {
            link1.listPush(Integer.parseInt(list[i]));
        }
		return link1;
	}
	/**
	 * function_description.
	 *
	 * @param      list  The list
	 *
	 * @return     { description_of_the_return_value }
	 */
	public static String digitsToNumber(final StackLinkedList list) {
		String str = "";
		str = list.display();
		StringBuilder st = new StringBuilder();
		st.append(str);
		str = "" + st.reverse();
		return str;
	}
	/**
	 * Adds large numbers.
	 *
	 * @param      list1  The list 1
	 * @param      list2  The list 2
	 *
	 * @return     { description_of_the_return_value }
	 */
	public static StackLinkedList addLargeNumbers(final StackLinkedList list1, final StackLinkedList list2) {
		StackLinkedList res = new StackLinkedList();
		return res;
	}
}
/**
 * Class for solution.
 */
public class Solution {
	/**
	 * Main function description.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String p = sc.nextLine();
		String q = sc.nextLine();
		switch (input) {
		case "numberToDigits":
			StackLinkedList pDigits = AddLargeNumbers.
			numberToDigits(p);
			StackLinkedList qDigits = AddLargeNumbers.
			numberToDigits(q);
			System.out.println(AddLargeNumbers.
				digitsToNumber(pDigits));
			System.out.println(AddLargeNumbers.
				digitsToNumber(qDigits));
			break;

		case "addLargeNumbers":
			pDigits = AddLargeNumbers.numberToDigits(p);
			qDigits = AddLargeNumbers.numberToDigits(q);
			StackLinkedList result = AddLargeNumbers.
			addLargeNumbers(pDigits, qDigits);
			System.out.println(AddLargeNumbers.
				digitsToNumber(result));
			break;
		default:
		break;
		}
	}

}