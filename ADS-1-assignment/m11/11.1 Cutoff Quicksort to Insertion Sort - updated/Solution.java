import java.util.Scanner;
/**
 * Class for sort.
 */
class Sort {
    /**.
     * Constructs the object.
     * Time complexity is 1.
     */
    Sort() {
        /**.
         * { Constructor }.
         */
    }
    /**.
     * { Insertion sort }
     * time complexity for this method is O(N^2).
     * @param      array  The arguments
     * @param      l  The arguments
     * @param      h  The arguments
     */
    public void insertionsort(final Comparable[] array, final int l,
     final int h) {
        for (int i = l; i <= h; i++) {
            for (int j = i; j > l && low(array[j], array[j - 1]); j--) {
                swaping(array, j, j - 1);
            }
        }
    }
     /**
     *It swaps the elements only once
     * { used to swap }.
     * time complexity of this method is O(1)
     *
     * @param      array  The arguments
     * @param      k  The arguments
     * @param      minimum  The arguments
     */
    public void swaping(final Comparable[] array,
        final int k, final int minimum) {
        Comparable res = array[k];
        array[k] = array[minimum];
        array[minimum] = res;
    }

    /**.
     * Returns a string representation of the object.
     * time complexity of this method is O(N). It iterates through
     * the array to print all the objects in array.
     * @param      array   The arr
     *
     * @return     String representation of the object.
     */
    public String print(final Comparable[] array) {
        String s = "[";
        for (int i = 0; i < array.length - 1; i++) {
            s += array[i] + ", ";
        }
        s += array[array.length - 1] + "]";
        return s;
    }

    /**.
     * usd to sort.
     * time complexity is O(log N).
     *
     * @param      array  The arguments
     * @param      l  The arguments
     * @param      h  The arguments
     * @param      c  The arguments
     */
    public void sort(final Comparable[] array, final int l,
     final int h, final int c) {
        if (h <= l + c - 1) {
            insertionsort(array, l, h);
            System.out.println("insertionSort called");
            return;
        }
        int k = partition(array, l, h);
        System.out.println(print(array));
        sort(array, l, k - 1, c);
        sort(array, k + 1, h, c);
    }
    /**
     * time complexity is O(1).
     * { function_description }
     *
     * @param      array   The array
     * @param      c  The cut off
     */
    public void sort(final Comparable[] array, final int c) {
        sort(array, 0, array.length - 1, c);
    }
    /**
     * time complexity is O(N)
     * partition.
     *
     * @param      array   The arr
     * @param      l   The low
     * @param      h  The high
     *
     * @return     { returns a array. }
     */
    public int partition(final Comparable[] array,
     final int l, final int h) {
        int i = l;
        int j = h + 1;
        while (true) {
            while (low(array[++i], array[l])) {
                if (i == h) {
                    break;
                }
            }
            while (low(array[l], array[--j])) {
                if (j == l) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swaping(array, i, j);
        }
        swaping(array, l, j);
        return j;
    }

    /**.
     * { less }.
     * time complexity is O(1).
     *
     * @param      a1     { parameter_description }
     * @param      b1     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public boolean low(final Comparable a1, final Comparable b1) {
        return a1.compareTo(b1) < 0;
    }
}
/**
 * Solution class.
 */
public final class Solution {
    /**.
     * Constructs the object.
     * Time complexity is 1.
     */
    private Solution() {
        /**.
         * Contructor.
         */
    }
    /**.
     * Client program.
     *
     * @param      args  The arguments
     */
    // time complexity for the main method is N
    // Because there is one while loop.
    // while loop iterates until it has next line i.e N times.
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        Sort st = new Sort();
        int lines = Integer.parseInt(s.nextLine());
        for (int i = 0; i < lines; i++) {
            int n = Integer.parseInt(s.nextLine());
            String l = s.nextLine();
            String[] token = l.split(" ");
            if (token[0].equals("")) {
                System.out.println("[]");
            } else {
                st.sort(token, n);
                System.out.println(st.print(token));
            }
        }
    }
}
