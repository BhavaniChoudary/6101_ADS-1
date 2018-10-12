import java.util.Scanner;
/**
 * Class for Taxinum.
 */
class Taxinum implements Comparable<Taxinum> {
    /**
     * Integer number1.
     */
    private int number1;
    /**
     * Integer number2.
     */
    private int number2;

    /**
     * Integer sum.
     */
    private int sum;
    /**
     * Constructs the object.
     * Time complexity is 1.
     *
     * @param      number11  The number 1
     * @param      number22  The number 2
     */
    Taxinum(final int number11, final int number22) {
        this.sum = number11 * number11 * number11 +
        number22 * number22 * number22;
        this.number1 = number11;
        this.number2 = number22;
    }
    /**
     * get method for number1.
     * Time complexity is 1.
     *
     * @return     { description_of_the_return_value }
     */
    public int getnumber1() {
        return this.number1;
    }
    /**
     * get method for number2.
     * Time complexity is 1.
     *
     * @return     { description_of_the_return_value }
     */
    public int getnumber2() {
        return this.number2;
    }
    /**
     * get method for sum.
     * Time complexity is 1.
     *
     * @return     { description_of_the_return_value }
     */
    public int getsum() {
        return this.sum;
    }
    /**
     * compareTo.
     * Time complexity is 1.
     *
     * @param      t     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final Taxinum t) {
        if (this.sum < t.sum) {
            return -1;
        } else if (this.sum > t.sum) {
            return +1;
        }
        return 0;
    }
    /**
     * Returns a string representation of the object.
     * Time complexity is 1.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return sum + " = " + number1 + "^3" + " + " + number2 + "^3";
    }
}
/**
 * Solution class.
 */
public final class Solution {
    /**
     * Constructs the object.
     * Time complexity is 1.
     */
    private Solution() {
        // constructor not used.
    }
    /**
     * Main function description.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        final int num = 600;
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int res = 0;
        int temp = -1;
        MinPQ<Taxinum> p = new MinPQ<Taxinum>();
        for (int i = 0; i <= num; i++) {
            p.insert(new Taxinum(i, i));
        }
        while (!p.isEmpty()) {
            Taxinum sn = p.delMin();
            if (temp == sn.getsum()) {
                res++;
            } else {
                res = 0;
            }
            if (res == m - 1) {
                n--;
                if (n == 0) {
                    System.out.println(sn.getsum());
                    break;
                }
            }
            temp = sn.getsum();
            if (sn.getnumber2() < num) {
                p.insert(new Taxinum(sn.getnumber1(), sn.getnumber2() + 1));
            }
        }
    }
}
