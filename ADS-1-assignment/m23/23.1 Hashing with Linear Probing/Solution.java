import java.util.Scanner;
public final class Solution {
    private Solution() {
        //function.
    }
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        LinearProbingHashST<String, Integer> obj
            = new LinearProbingHashST<String, Integer>();
        int n = Integer.parseInt(s.nextLine());
        while (n > 0) {
            String[] tok = s.nextLine().split(" ");
            switch (tok[0]) {
            case "put" :
                obj.put(tok[1], Integer.parseInt(tok[2]));
                break;
            case "get" :
                System.out.println(obj.get(tok[1]));
                break;
            case "display" :
                try {
                    System.out.println(obj.display());
                } catch (Exception ex) {
                    System.out.println("{}");
                }
                break;
            case "delete" :
                obj.delete(tok[1]);
                break;
            default:
                break;
            }
            n--;
        }
    }
}