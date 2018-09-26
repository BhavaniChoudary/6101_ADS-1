import java.util.Scanner;
import java.util.Arrays;
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
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = s.nextInt();
        }
        Arrays.sort(numbers);
        int count = 0;
        int j;
        int k;
        for (int i = 0; i < size - 2; i++) {
            j = i + 1;
            k = size - 1;
            while (j < k) {
                if (numbers[i] + numbers[j] + numbers[k] == 0) {
                    count++;
                    j++;
                    k--;
                } else if (numbers[i] + numbers[j] + numbers[k] <    0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        System.out.println(count);
    }
}

