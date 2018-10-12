import java.util.Scanner;
/**
 * Class for symbol table.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class SymbolTable<Key extends Comparable<Key>, Value> {
    /**
     * array for keys.
     */
    private Key[] keys;
    /**
     * array for values.
     */
    private Value[] values;
    /**
     * var size description.
     */
    private int size;
    /**
     * Constructs the object.
     *
     * @param      n     { parameter_description }
     */
    SymbolTable(final int n) {
        keys = (Key[]) new Comparable[n];
        values = (Value[]) new Object[n];
        size = 0;
    }
    /**
     * inserts key and a value in the arrays.
     *
     * @param      key    The key
     * @param      value  The value
     */
    void put(final Key key, final Value value) {
        if (value == null) {
            delete(key);
            return;
        }
        int i = rank(key);
        if (i < size && keys[i].compareTo(key) == 0) {
            values[i] = value;
            return;
        }
        for (int j = size; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = key;
        values[i] = value;
        size++;
    }
    /**
     * shows if key is in symboltable.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    boolean contains(final Key key) {
        return get(key) != null;
    }
    /**
     * return value paired with Key.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    Value get(final Key key) {
        if (size == 0) {
            return null;
        }
        int i = rank(key);
        if (i < size && keys[i].compareTo(key) == 0) {
            return values[i];
        }
        return null;
    }
    /**
     * returns no.of keys less than key.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    int rank(final Key key) {
        int low = 0, high = size - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                high = mid - 1;
            } else if (cmp > 0) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return low;
    }
    /**
     * gives largest key.
     *
     * @return     { description_of_the_return_value }
     */
    Key max() {
        return keys[size - 1];
    }
    /**
     * deletes.
     *
     * @param      key   The key
     */
    void delete(final Key key) {
        if (size == 0) {
            return;
        }
        int i = rank(key);
        if (i == size || keys[i].compareTo(key) != 0) {
            return;
        }
        int j;
        for (j = i; j < size - 1; j++) {
            keys[j] = keys[j + 1];
            values[j] = values[j + 1];
        }
        size--;
        keys[j] = null;
        values[j] = null;
    }
    /**
     * deletes smallest key.
     */
    void deleteMin() {
        delete(keys[0]);
    }
    /**
     * returns all keys in sorted order.
     */
    void keys() {
        for (int i = 0; i < size; i++) {
            if (values[i] != null) {
                System.out.println(keys[i] + " " + values[i]);
            }
        }
    }
    /**
     * return largest key less than or equal to key.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    Key floor(final Key key) {
        int i = rank(key);
        if (i < size && key.compareTo(keys[i]) == 0) {
            return keys[i];
        }
        if (i == 0) {
            return null;
        }
        return keys[i - 1];
    }
}
/**
 * Solution class.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * Main function_description.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        SymbolTable<String, Integer> st = new
            SymbolTable<String, Integer>(input.length);
        for (int i = 0; i < input.length; i++) {
            st.put(input[i], i);
        }
        while (sc.hasNextLine()) {
            String[] operation = sc.nextLine().split(" ");
            switch (operation[0]) {
            case "contains":
                System.out.println(st.contains(operation[1]));
                break;
            case "get":
                System.out.println(st.get(operation[1]));
                break;
            case "max":
                System.out.println(st.max());
                break;
            case "floor":
                System.out.println(st.floor(operation[1]));
                break;
            case "rank":
                System.out.println(st.rank(operation[1]));
                break;
            case "deleteMin":
                st.deleteMin();
                break;
            case "keys":
                st.keys();
                break;
            default:
                break;
            }
        }
    }
}

