import java.util.Scanner;
/**
 * Class for stock.
 */
class Stock {
    /**
     * name.
     */
    private String name;
    /**
     * change.
     */
    private double change;
    /**
     * Constructs the object.
     *
     * @param      name    The name
     * @param      change  The change
     */
    Stock(final String name, final double change) {
        this.name = name;
        this.change = change;
    }
    /**
     * get name function_description.
     *
     * @return     { description_of_the_return_value }
     */
    String getname() {
        return this.name;
    }
    /**
     * get change function_description.
     *
     * @return     { description_of_the_return_value }
     */
    double getchange() {
        return this.change;
    }
}
/**
 * Class for addstock.
 */
class addstock {
    Stock[] stack;
    int size;
    /**
     * Constructs the object.
     *
     * @param      n     { parameter_description }
     */
    addstock(int n) {
        stack = new Stock[n*6];
        size = 0;
    }
    /**
     * adds.
     *
     * @param      s     { parameter_description }
     */
    public void add(Stock s) {
        stack[size++] = s;
    }
}
/**
 * Class for sorting.
 */
class sorting {
    public void sort(Stock[] st, int low, int high) {
        for (int i = low; i < high; i++) {
            for (int j = i; j < high; j++) {
                if (st[i].getchange() < st[j].getchange())  {
                    swap(st[i], st[j]);
                }
            }
        }
    }
    /**
     * swaps the values.
     *
     * @param      s1    The s 1
     * @param      s2    The s 2
     */
    public void swap(Stock s1, Stock s2) {
        Stock temp = s1;
        s2 = s1;
        s1 = temp;
    }
}
/**
 * Solution class.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //constructor not used.
    }
    /**
     * Main function_description.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        addstock as = new addstock(n * 6);
        sc.nextLine();
        // for (int i = 0; i < 0; i++) {
        //  for (int j = 0; j < n; j++) {
        //      String[] input = sc.nextLine().split(",");
        //  }
        // }
        for (int i = 0; i < n * 6; i++) {
            String[] tokens = sc.nextLine().split(",");
        }
        //as.sort(n);
    }
}
