import java.util.Scanner;
final class Solution {
    private Solution() {}
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        BinaryST bst = new BinaryST();
        while(sc.hasNextLine()) {
            String[] tokens = sc.nextLine().split(",");
            switch(tokens[0]) {
                case "put": bst.put(new Book(tokens[1], tokens[2], Double.parseDouble(tokens[2+1])), Integer.parseInt(tokens[2+2]));
                break;
                case "get":
                System.out.println(bst.get(new Book(tokens[1],
                    tokens[2], Double.parseDouble(tokens[2 + 1]))));
                break;
            case "max":
                System.out.println(bst.max());
                break;
            case "min":
                System.out.println(bst.min());
                break;
            case "floor":
                System.out.println(bst.floor(new Book(tokens[1],
                    tokens[2], Double.parseDouble(tokens[2 + 1]))));
                break;
            case "ceiling":
                System.out.println(bst.ceiling(new Book(tokens[1],
                    tokens[2], Double.parseDouble(tokens[2 + 1]))));
                break;
            case "select":
                System.out.println(bst.select(Integer.parseInt(tokens[1])));
                break;
            case "deleteMin":
                bst.deleteMin();
                break;
            case "deleteMax":
                bst.deleteMax();
                break;
            case "delete":
                bst.delete(new Book(tokens[1],
                    tokens[2], Double.parseDouble(tokens[2 + 1])));
                break;
            default:
                break;
            }
        }
    }
}