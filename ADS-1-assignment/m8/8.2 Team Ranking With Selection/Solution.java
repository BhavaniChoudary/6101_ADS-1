import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for tournament.
 */
class Tournament implements Comparable {
    /**
     * String type of tName.
     */
    private String tName;
    /**
     * winner of type int.
     */
    private int winner;
    /**
     * losser of type int.
     */
    private int losser;
    /**
     * draw of type int.
     */
    private int draw;
    /**
     * Constructs the object.
     * Time complexity is 1.
     */
    Tournament() {
        //constructor not used.
    }
    /**
     * Constructs the object.
     *
     * @param      n     n of type String.
     * @param      w     w of type int.
     * @param      l     l of type int.
     * @param      d     d of type int.
     */
    Tournament(final String n, final int w, final int l, final int d) {
        this.tName = n;
        this.winner = w;
        this.losser = l;
        this.draw = d;
    }
    /**
     * Gets the losser.
     * Time complexity is 1.
     *
     * @return     The losser.
     */
    public int getLosser() {
        return this.losser;
    }
    /**
     * Gets the draw.
     * Time complexity is 1.
     *
     * @return     The draw.
     */
    public int getDraw() {
        return this.draw;
    }
    /**
     * Compares the objects.
     *
     * @param      ob    Object type ob.
     *
     * @return     returns 1 if true or else -1.
     * Time complexity is 1.
     */
    public int compareTo(final Object ob) {
        //System.out.println("i am compareto");
        Tournament t = (Tournament) ob;
        if (this.getWinner() > t.getWinner()) {
            return 1;
        } else if (this.getWinner() < t.getWinner()) {
            return -1;
        }
        if (this.getLosser() < t.getLosser()) {
            return 1;
        } else if (this.getLosser() > t.getLosser()) {
            return -1;
        }
        if (this.getDraw() > t.getDraw()) {
            return 1;
        } else if (this.getDraw() < t.getDraw()) {
            return -1;
        }
        return 0;
    }
    /**
     * used to get name.
     * Time complexity is 1.
     *
     * @return     return the testname.
     */
    public String getname() {
        return this.tName;
    }
    /**
     * Gets the winner.
     * Time complexity is 1.
     *
     * @return     The winner.
     */
    public int getWinner() {
        return this.winner;
    }
}
/**
 * Class for Selection sort.
 */
class SelectionSort {
    /**
     * tArray of type Tournament.
     */
    private Tournament[] tArray;
    /**
     * size of type int.
     */
    private int size;
    /**
     * Constructs the object.
     * Time complexity is 1.
     */
    SelectionSort() {
        this.size = 0;
        final int ten = 10;
        this.tArray = new Tournament[ten];
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     * Time complexity is N.
     */
    public String toString() {
        int res = 0;
        String string = "";
        for (res = 0; res < size - 1; res++) {
            string += tArray[res].getname() + ",";
        }
        string += tArray[res].getname();
        return string;
    }
    /**
     * Adds.
     *
     * @param      g     G of type Tournament.
     * Time complexity is 1.
     */
    public void add(final Tournament g) {
        if (size == tArray.length) {
            resize();
        }
        tArray[size++] = g;
    }
    /**
     * Sorting using selection.
     * Time complexity is N^2.
     */
    public void selectionsort() {
        for (int i = 0; i < size; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++) {
                if (tArray[j].compareTo(tArray[min]) == 1) {
                    min = j;
                }
            }
            swapping(tArray, i, min);
        }
    }
    /**
     * This is used to return the size.
     * Time complexity is 1.
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
        return size;
    }
    /**
     * This is used to resize the lenth of an array.
     * Time complexity is N.
     */
    public void resize() {
        tArray = Arrays.copyOf(tArray, 2 * tArray.length);
    }
    /**
     * this is used to swap the position of the variables when it is small.
     * The time complexity for resize() is 1.
     *
     *
     * @param      arr   The arr
     * @param      i      Integer i.
     * @param      j     Integer j.
     */
    public void swapping(final Comparable[] arr, final int i, final int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
/**
 * Solution class.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        // constructor not used.
    }
    /**
     * Client program.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        final int three = 3;
        Scanner s = new Scanner(System.in);
        SelectionSort ss = new SelectionSort();
        while (s.hasNext()) {
            String[] token = s.nextLine().split(",");
            ss.add(new Tournament(token[0],
                Integer.parseInt(token[1]),
                Integer.parseInt(token[2]),
                Integer.parseInt(token[three])));
        }
        ss.selectionsort();
        System.out.println(ss);
    }
}


