import java.util.Scanner;
class SymbolTable<Key extends Comparable<Key>, Value> {
	private Key[] keys;
	private Value[] values;
	private int size;
	SymbolTable(final int n) {
		keys = (Key[]) new Comparable[n];
		values = (Value[]) new Object[n];
		size = 0;
	}
	void put(final Key key, final Value value) {
		if (value == null) {
			delete(key);
			return;
		}
		int i = rank(key);
		if(i < size && keys[i].compareTo(key) == 0) {
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
	boolean contains(final Key key) {
        return get(key) != null;
    }
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
    Key max() {
        return keys[size - 1];
    }
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
    void keys() {
        for (int i = 0; i < size; i++) {
            if (values[i] != null) {
                System.out.println(keys[i] + " " + values[i]);
            }
        }
    }
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