import java.util.Scanner;
class Taxinum implements Comparable<Taxinum> {
	private int number1;
	private int number2;
	private int sum;
	Taxinum(final int number1, final int number2) {
        this.sum = number1 * number1 * number1 + number2 * number2 * number2;
        this.number1 = number1;
        this.number2 = number2;
    }
    public int getnumber1() {
        return this.number1;
    }
    public int getnumber2() {
        return this.number2;
    }
    public int getsum() {
        return this.sum;
    }
    public int compareTo(final Taxinum t) {
        if (this.sum < t.sum) {
            return -1;
        } else if (this.sum > t.sum) {
            return +1;
        }
        return 0;
    }
    public String toString() {
        return sum + " = " + number1 + "^3" + " + " + number2 + "^3";
    }
}
public final class Solution {
	private Solution() {
		//constructor not used.
	}
	public static void main(String[] args) {
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