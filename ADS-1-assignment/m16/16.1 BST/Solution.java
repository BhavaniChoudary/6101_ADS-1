import java.util.Scanner;
/**
 * Class for book.
 */
class Book {
    /**
     * name.
     */
    private String name;
    /**
     * author.
     */
    private String author;
    /**
     * price.
     */
    private Double price;
    /**
     * Constructs the object.
     *
     * @param      n     { parameter_description }
     * @param      a     { parameter_description }
     * @param      p     { parameter_description }
     */
    Book(final String n, final String a, final Double p) {
        this.name = n;
        this.author = a;
        this.price = p;
    }
    /**
     * get name.
     *
     * @return     { description_of_the_return_value }
     */
    String getname() {
        return this.name;
    }
    /**
     * get suthor.
     *
     * @return     { description_of_the_return_value }
     */
    String getauthor() {
        return this.author;
    }
    /**
     * get price.
     *
     * @return     { description_of_the_return_value }
     */
    Double getprice() {
        return this.price;
    }
    /**
     * compare.
     *
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     */
    int compareTo(final Book that) {
        if (this.name.compareTo(that.name) > 0) {
            return 1;
        } else if (this.name.compareTo(that.name) < 0) {
            return -1;
        } else {
            if (this.author.compareTo(that.author) > 0) {
                return 1;
            } else if (this.author.compareTo(that.author) < 0) {
                return -1;
            } else {
                if (this.price.compareTo(that.price) > 0) {
                    return 1;
                } else if (this.price.compareTo(that.price) < 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
    }
}
/**
 * Class for binary search tree.
 */
class BST {
    class Node {
        private Book key;
        private Integer value;
        private Node left;
        private Node right;        
        Node(final Book k, final Integer v) {
            this.key = k;
            this.value = v;
            this.left = null;
            this.right = null;
        }
    }
    private Node root;
    BST() {
        root = null;
    }
    public void put(final Book key, final Integer value) {
        root = put(root, key, value);
    }
    private Node put(final Node x, final Book key, final Integer value) {
        if (x == null) {
            return new Node(key, value);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else if (cmp > 0) {
            x.right = put(x.right, key, value);
        } else {
            x.value = value;
        }
        return x;
    }
    public Integer get(final Book key) {
        return get(root, key);
    }
    private Integer get(final Node x, final Book key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return get(x.left, key);
        } else if (cmp > 0) {
            return get(x.right, key);
        }
        return x.value;
    }
}
final class Solution {

    private Solution() {
        //function.
    }
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        BST bst = new BST();
        while (sc.hasNextLine()) {
            String[] tokens = sc.nextLine().split(",");
            switch (tokens[0]) {
            case "put":
                bst.put(new Book(tokens[1], tokens[2],
                 Double.parseDouble(tokens[2 + 1])),
                  Integer.parseInt(tokens[2 + 2]));
                break;
            case "get":
                System.out.println(bst.get(new Book(tokens[1],
                 tokens[2], Double.parseDouble(tokens[2 + 1]))));
                break;
            default:
                break;
            }
        }
    }
}