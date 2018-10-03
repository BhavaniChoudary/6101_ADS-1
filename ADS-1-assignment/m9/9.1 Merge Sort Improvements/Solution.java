import java.util.Scanner;
/**.
 *This is a class Solution.
 */
 final class Solution {
    /**.
     * It's a default constructor.
     */
    private Solution() {

    }
    /**.
     * Main Method
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Mergesort merge = new Mergesort();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] lines = line.split(",");
            merge.sort(lines);
            System.out.println(merge.display(lines));
            System.out.println();
        }
    }
 }