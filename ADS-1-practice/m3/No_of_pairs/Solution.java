import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for solution.
 */
class Solution {
	/**
	 * item_description.
	 */
	static int arr[];
	/**
	 * Constructs the object.
	 */
	Solution() {

	}
	/**
	 * function_description.
	 *
	 * @param      args  The arguments
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i = 0;
		arr = new int[n];
		while (i<n) {
			arr[i] = sc.nextInt();
			i++;
		}
		Arrays.sort(arr);
		noofpairs(arr);
	}
	/**
	 * function_description.
	 *
	 * @param      arr1  The arr 1
	 */
	public static void noofpairs(int[] arr1) {
		int count = 0;
		int k = 1;
		int total = 0;
		for (int j = 0; j < arr1.length - 1; j++) {
			if (arr1[j] == arr1[j + 1]) {
				count += k;
				k++;
			} else if (arr1[j] != arr1[j + 1]) {
				k = 1;
				total += count;
				count = 0;
			}
		}
		System.out.println(total + count);
	}
}