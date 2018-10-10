import java.util.Scanner;
/**
 * Class for solution.
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
     * Client program.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();

        MinPQ<Float> min = new MinPQ<Float>(num);
        MaxPQ<Float> max = new MaxPQ<Float>(num);

        Float med = 0.0f;
        for (int i = 0; i < num; i++) {
            Float value = s.nextFloat();
            if (med < value) {
                min.insert(value);
            } else {
                max.insert(value);
            }

            if (min.size() - max.size() > 1) {
                max.insert(min.delMin());

            }
            if (max.size() - min.size() > 1) {
                min.insert(max.delMax());
            }

            if (min.size() == max.size()) {
                med = (min.min() + max.max()) / 2;
                System.out.println(med);
            }

            if (max.size() > min.size()) {
                med = max.max();
                System.out.println(med);
            }

            if (min.size() > max.size()) {
                med = min.min();
                System.out.println(med);
            }

        }

    }
}