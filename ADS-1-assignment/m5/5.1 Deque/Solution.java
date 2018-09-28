import java.util.Scanner;
/**
 * Class for solution.
 */
class Solution {
    private Solution() {
    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque dq = new Deque();
        int count = sc.nextInt();
        sc.nextLine();
        while (count > 0) {
            count--;
            String[] line = sc.nextLine().split(" ");
            switch (line[0]) {
            case "pushLeft":
                dq.pushLeft(Integer.parseInt(line[1]));
                break;

            case "pushRight":
                dq.pushRight(Integer.parseInt(line[1]));
                break;
            case "size":
                System.out.println(dq.getSize());
                break;
            case "popLeft":
                dq.popLeft();
                break;
            case "popRight":
                dq.popRight();
                break;
            default:

            }
        }
    }
}

