//import java.util.Scanner;
/**
 * item_description.
 */
final class Deque {
    /**
     * var_description.
     */
    private int size;
    /**
     * var_description.
     */
    private int[] stackArr;
    /**
     * var_description.
     */
    private int maxsize;
    /**
     * Constructs the object.
     */
    Deque() {
        maxsize = 10000;
        size = 0;
        stackArr = new int[maxsize];
    }
    /**
     * Pushes a left.
     *
     * @param      num   The number
     */
    void pushLeft(final int num) {
        int temp;
        for (int i = size + 1; i > 0; i--) {
            temp = stackArr[i - 1];
            stackArr[i] = temp;
        }
        stackArr[0] = num;
        size++;
        printStack();
    }
    /**
     * Pushes a right.
     *
     * @param      num   The number
     */
    void pushRight(final int num) {
        stackArr[size] = num;
        size++;
        printStack();

    }
    /**
     * function_description.
     */
    void popLeft() {

        if (size == 0) {
            System.out.println("Deck is empty");
        } else {
            int value = stackArr[0];
            for (int i = 0; i < size - 1; i++) {
                stackArr[i] = stackArr[i + 1];
            }
            size--;
            printStack();
        }
    }
    /**
     * function_description.
     */
    void popRight() {
        if (size == 0) {
            System.out.println("Deck is empty");
        } else {
            size--;
            printStack();
        }
    }
    /**
     * Gets the size.
     *
     * @return     The size.
     */
    int getSize() {
        return size;
    }
    /**
     * function_description.
     */
    void printStack() {
        if (size == 0) {
            System.out.println("[]");
        }
        for (int i = 0; i < size; i++) {
            if (i == 0 && size == 1) {
                System.out.print("[" + stackArr[i] + "]\n");
            } else if (i == 0 && size != 1) {
                System.out.print("[" + stackArr[i] + ", ");

            } else if (i == size - 1) {
                System.out.print(stackArr[i] + "]\n");
            } else {
                System.out.print(stackArr[i] + ", ");
            }
        }
    }
}