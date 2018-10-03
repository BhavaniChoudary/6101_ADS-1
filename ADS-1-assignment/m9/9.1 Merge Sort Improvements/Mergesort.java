class Mergesort {
    /**
     *It's a default constructor.
     **/
    Mergesort() {

    }
    /**
     *The Time complexity is N.
     * @param array Comparable type.
     * @param lo int type.
     * @param mid int type.
     * @param hi int type.
     */
    private static final int cutoffPoint = 7;
    void mergeSort(final Comparable[] array,
        final Comparable[] auxiliary, final int lo,
        final int mid, final int hi) {
        assert isSorted(array, lo, mid);
        assert isSorted(array, mid + 1, hi);

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                auxiliary[k] = array[j++];
            } else if (j > hi) {
                auxiliary[k] = array[i++];
            } else if (less(array[j], array[i])) {
                auxiliary[k] = array[j++];
            } else {
                auxiliary[k] = array[i++];
            }
    }
}
/**
 *The sort method.
 *The complexity is N.
 * @param array type Comparable.
 * @param lo int.
 * @param hi int.
 **/
    void sort(final Comparable[] array,
        final Comparable[] auxiliary, final int lo,
        final int hi) {
        if (hi <= lo + cutoffPoint) {
            insertionSort(auxiliary, lo, hi);
            System.out.println("Insertion sort method invoked...");
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(auxiliary, array, lo, mid);
        sort(auxiliary, array, mid + 1, hi);

        if (!less(array[mid + 1], array[mid])) {
           for (int i = lo; i <= hi; i++) {
            auxiliary[i] = array[i];
            }
            System.out.println("Array is already sorted. " +
                "So, skipped the call to merge...");
           return;
        }
        mergeSort(array, auxiliary, lo, mid, hi);
    }
    /**
     *The sort method.
     * @param a type Comparable.
     **/
    void sort(final Comparable[] a) {
        Comparable[] aux = a.clone();
        sort(aux, a, 0, a.length - 1);
        assert isSorted(a);
    }
    /**
     * InsertionSort method.
     * The time complexity N^2.
     * @param a type Comparable.
     * @param lo int.
     * @param hi int.
     **/
    void insertionSort(final Comparable[] a, final  int lo,
        final int hi) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j - 1]); j--) {
                exchange(a, j, j - 1);
            }
        }
    }
    /**
     * Exchange method.
     * Time complexity 1.
     * @param a type Comparable.
     * @param i type int.
     * @param j type int.
     **/
    void exchange(final Comparable[] a, final int i, final int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    boolean less(final Comparable a, final Comparable b) {
        return a.compareTo(b) < 0;
    }
    /**
     * isSorted method.
     * Time complexity is 1.
     * @param a type Comparable.
     * @return boolean.
     **/
    boolean isSorted(final Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }
    /**
     * isSorted method.
     * Time complexity is N.
     * @param a Comparable.
     * @param lo int.
     * @param hi int.
     * @return boolean.
     **/
     boolean isSorted(final Comparable[] a,
        final int lo, final int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }
    /**
     * Display method used to display the output.
     * @param a Type object.
     * @return object.
     **/
    Object display(final Object[] a) {
        String s = "[";
        int i;
        for (i = 0; i < a.length - 1; i++) {
            s += a[i] + ", ";
        }
        s = s + a[a.length - 1] + "]";
        return s;
    }
}