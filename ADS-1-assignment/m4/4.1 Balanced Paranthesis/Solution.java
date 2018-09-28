import java.util.Scanner;
/**
 * Stack class.
 */
class Stack {
    private String[] data;
    /**
     * var_description.
     */
    private int top;
    /**
     * Constructs the object.
     *
     * @param      size  The size
     */
    Stack(final int size) {
        data = new String[size];
        top = -1;
    }
    /**
     * function_description.
     *
     * @param      input  The input
     *
     * @return     { description_of_the_return_value }
     */
    public int push(final char input) {
        String val = Character.toString(input);
        if (top == -1) {
            if (val.equals("(") || val.equals("[") || val.equals("{")) {
                top++;
                data[top] = val;
                return 1;
            } else {
                return 0;
            }
        }
        switch (val) {
            case "(":
            if (data[top].equals("(") || data[top].equals("[")
                || data[top].equals("{")) {
                top++;
                data[top] = val;
                return 1;
            }
            return 0;
            case ")":
            if (data[top].equals("(")) {
                pop();
                return 1;
            }
            return 0;
            case "[":
            if (data[top].equals("(") || data[top].equals("[")
                || data[top].equals("{")) {
                top++;
                data[top] = val;
                return 1;
            }
            return 0;
            case "]":
            if (data[top].equals("[")) {
                pop();
                return 1;
            }
            return 0;
            case "{":
            if (data[top].equals("(") || data[top].equals("[")
                || data[top].equals("{")) {
                top++;
                data[top] = val;
                return 1;
            }
            return 0;
            case "}":
            if (data[top].equals("{")) {
                pop();
                return 1;
            }
            return 0;
            default:
        }
        return 0;
    }
    /**
     * function_description.
     */
    public void pop() {
        top--;
    }
    /**
     * Gets the top.
     *
     * @return     The top.
     */
    public int getTop() {
        return top;
    }
    /**
     * Sets the top.
     *
     * @param      i     { parameter_description }
     */
    public void setTop(final int i) {
        top = i;
    }
}
/**
 * item_description.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int lines = s.nextInt();
        s.nextLine();
        int i = 0;
        while (i < lines) {
            String inputs = "";
            inputs = s.nextLine();
            Stack st = new Stack(inputs.length());
            int j = 0, f = 0;
            st.setTop(-1);
            for (j = 0; j < inputs.length(); j++) {
                f = st.push(inputs.charAt(j));
                if (f == 0) {
                    System.out.println("NO");
                    break;
                }
            }
            if (f != 0) {
                if (j == inputs.length() && st.getTop() == -1) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
            i++;
        }
    }
}

