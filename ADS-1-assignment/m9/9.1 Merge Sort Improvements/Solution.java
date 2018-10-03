import java.util.Scanner;
 final class Solution {
    private Solution() {

    }
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