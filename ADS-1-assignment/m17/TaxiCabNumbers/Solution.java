import java.util.Scanner;
/**
 * Class for taxi number.
 */
class Taxinum implements Comparable<Taxinum> {
    /**
     * integer number1 var_description.
     */
    private int number1;
    /**
     * integer number2 var_description.
     */
    private int number2;
    /**
     * integer sum var_description.
     */
    private int sum;
    /**
     * Constructs the object.
     *
     * @param      number1  The number 1
     * @param      number2  The number 2
     */
    Taxinum(final int number1, final int number2) {
        this.sum = number1 * number1 * number1 + number2 * number2 * number2;
        this.number1 = number1;
        this.number2 = number2;
    }
    /**
     * get method for num1.
     * Time complexity is 1.
     *
     * @return     { description_of_the_return_value }
     */
    public int getnumber1() {
        return this.number1;
    }
    /**
     * get method for num2.
     * Time complexity is 1.
     *
     * @return     { description_of_the_return_value }
     */

    public int getnumber2() {
        return this.number2;
    }
    /**
     * get sum.
     * Time complexity is 1.
     *
     * @return     { description_of_the_return_value }
     */

    public int getsum() {
        return this.sum;
    }
    /**
     * compares.
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
        //constructor not used.
    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        final int number = 600;
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int res = 0;
        int temp = -1;
        MinPQ<Taxinum> p = new MinPQ<Taxinum>();
        for (int i = 0; i <= number; i++) {
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
            if (sn.getnumber2() < number) {
                p.insert(new Taxinum(sn.getnumber1(), sn.getnumber2() + 1));
            }
        }
    }
}
