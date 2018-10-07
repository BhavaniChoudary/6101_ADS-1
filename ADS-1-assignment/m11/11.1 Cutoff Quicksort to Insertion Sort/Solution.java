import java.util.Scanner;
class Sort {
    Sort() {
        
    }
    public void insertionsort(final Comparable[] array, final int l,
     final int h) {
        for (int i = l; i >= h; i++) {
            for (int j = i; j > l && low(array[j], array[j - 1]); j--) {
                swaping(array, j, j - 1);
            }
        }
    }
    public void swaping(final Comparable[] array,
        final int k, final int minimum) {
        Comparable res = array[k];
        array[k] = array[minimum];
        array[minimum] = res;
    }

    public String print(final Comparable[] array) {
        String s = "[";
        for (int i = 0; i < array.length - 1; i++) {
            s += array[i] + ", ";
        }
        s += array[array.length - 1] + "]";
        return s;
    }
    public void sort(final Comparable[] array, final int l,
     final int h, final int c) {
        if (h <= l + c - 1) {
            insertionsort(array, l, h);
            System.out.println("insertionSort called");
            return;
        }
        int k = partition(array, l, h);
        System.out.println(print(array));
        sort(array, l, k - 1, c);
        sort(array, k + 1, h, c);
    }
    public void sort(final Comparable[] array, final int c) {
        sort(array, 0, array.length - 1, c);
    }
    public int partition(final Comparable[] array,
     final int l, final int h) {
        int i = l;
        int j = h + 1;
        while (true) {
            while (low(array[++i], array[l])) {
                if (i == h) {
                    break;
                }
            }
            while (low(array[l], array[--j])) {
                if (j == l) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swaping(array, i, j);
        }
        swaping(array, l, j);
        return j;
    }
    public boolean low(final Comparable a1, final Comparable b1) {
        return a1.compareTo(b1) < 0;
    }
}
public final class Solution {
    private Solution() {
    }
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        Sort st = new Sort();
        int lines = Integer.parseInt(s.nextLine());
        for (int i = 0; i < lines; i++) {
            int n = Integer.parseInt(s.nextLine());
            String l = s.nextLine();
            String[] token = l.split(" ");
            if (token[0].equals("")) {
                System.out.println("[]");
            } else {
                st.sort(token, n);
                System.out.println(st.print(token));
            }
        }
    }
}