import java.util.*;
//import java.lang.StringBuilder;
/**
 * Class for node.
 */
class Node {
    /**
     * var_description.
     */
    private int data;
    /**
     * var_description.
     */
    private Node link;
    /**
     * Constructs the object.
     */
    public Node() {
        link = null;
        data = 0;
    }
    /**
     * Constructs the object.
     *
     * @param      d     { parameter_description }
     * @param      n     { parameter_description }
     */
    public Node(final int d, final Node n) {
        data = d;
        link = n;
    }
    /**
     * Sets the data.
     *
     * @param      d     { parameter_description }
     */
    public void setData(final int d) {
        data = d;
    }
    /**
     * Gets the data.
     *
     * @return     The data.
     */
    public int getData() {
        return data;
    }
    /**
     * Sets the link.
     *
     * @param      n     { parameter_description }
     */
    public void setLink(final Node n) {
        link = n;
    }
    /**
     * Gets the link.
     *
     * @return     The link.
     */
    public Node getLink() {
        return link;
    }
}
/**
 * List of stack linklist.
 */
class StackLinkedList {
    /**
     * var_description.
     */
    private Node top;
    /**
     * var_description.
     */
    private int size;
    /**
     * Constructs the object.
     */
    public StackLinkedList() {
        top = null;
        size = 0;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return top == null;
    }
    /**
     * Gets the size.
     *
     * @return     The size.
     */
    public int getSize() {
        return size;
    }
    /**
     * pushs element.
     *
     * @param      data  The data
     */
    public void listPush(final int data) {
        Node nptr = new Node(data, null);
        if (top == null) {
            top = nptr;
        }
        else {
            nptr.setLink(top);
            top = nptr;
        }
        size++;
    }
    /**
     * pops the element.
     *
     * @return     { description_of_the_return_value }
     */
    public int listPop() {
        Node ptr = top;
        top = ptr.getLink();
        size--;
        return ptr.getData();
    }
    /**
     * displays elements.
     *
     * @return     { description_of_the_return_value }
     */
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
/**
 * Class for add large numbers.
 */
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
    public static StackLinkedList addLargeNumbers(final
        StackLinkedList list1, final StackLinkedList list2) {
        StackLinkedList res = new StackLinkedList();
        return res;
    }
}
/**
 * Class for solution.
 */
final public class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
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

