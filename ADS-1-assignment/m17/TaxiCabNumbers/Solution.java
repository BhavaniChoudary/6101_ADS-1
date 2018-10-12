import java.util.Scanner;
/**
 * Class for taxi number.
 */
class Taxinum implements Comparable<Taxinum> {
    /**
     * integer num11 var_description.
     */
    private int num11;
    /**
     * integer num22 var_description.
     */
    private int num22;
    /**
     * integer sum var_description.
     */
    private int sum;
    /**
     * Constructs the object.
     *
     * @param      num11  The number 1
     * @param      num22  The number 2
     */
    Taxinum(final int num11, final int num22) {
        this.sum = num11 * num11 * num11 + num22 * num22 * num22;
        this.num11 = num11;
        this.num22 = num22;
    }
    /**
     * get method for num1.
     * Time complexity is 1.
     *
     * @return     { description_of_the_return_value }
     */
    public int getnum11() {
        return this.num11;
    }
    /**
     * get method for num2.
     * Time complexity is 1.
     *
     * @return     { description_of_the_return_value }
     */

    public int getnum22() {
        return this.num22;
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
        return sum + " = " + num11 + "^3" + " + " + num22 + "^3";
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
            if (sn.getnum22() < number) {
                p.insert(new Taxinum(sn.getnum11(), sn.getnum22() + 1));
            }
        }
    }
}
