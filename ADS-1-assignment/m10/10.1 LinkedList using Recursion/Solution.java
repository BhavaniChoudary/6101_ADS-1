import java.util.Scanner;
public final class Solution {
    private Solution() {

    }
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedList li = new LinkedList();
        while (sc.hasNext()) {
            String str1 = sc.nextLine();
            String[] arr1 = str1.split(" ");
            switch (arr1[0]) {
            case "insertAt":
        li.insertAt(Integer.parseInt(arr1[1]), Integer.parseInt(arr1[2]));
                break;
            case "reverse":
                try {
                    li.reverse();
                } catch (Exception e) {
                    System.out.println("No elements to reverse.");
                }
                break;
            default:
                break;
            }
        }
    }
}



