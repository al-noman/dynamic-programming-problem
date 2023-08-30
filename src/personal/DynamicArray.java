package personal;

import static java.lang.System.arraycopy;

@SuppressWarnings("Unchecked")
public class DynamicArray<T> {
    private T[] array;
    private int length;
    private int capacity;

    public DynamicArray() {
        this.array = (T[]) new Object[1];
        this.capacity = 1;
        this.length = 0;
    }

    public DynamicArray(int size) {
        this.array = (T[]) new Object[size];
        this.length = size;
        this.capacity = size;
    }

    public T getAt(int index) {
        if (index < 0 || index >= length) throw new ArrayIndexOutOfBoundsException();
        return array[index];
    }

    public T[] get() {
        return array;
    }

    public int getLength() {
        return length;
    }

    public T[] addAtIndex(int index, T element) {
        if (index < 0 || index >= length) throw new ArrayIndexOutOfBoundsException();
        if (index == 0) return prepend(element);

        capacity = ++length;
        var newArray = (T[]) new Object[capacity];
        arraycopy(array, 0, newArray, 0, index);
        newArray[index] = element;
        arraycopy(array, index, newArray, index+1, length-index-1);
        array = newArray;
        return array;
    }

    public T[] prepend(T element) {
        var newArray = (T[]) new Object[++length];
        newArray[0] = element;
        arraycopy(array, 0, newArray, 1, length-1);
        array = newArray;
        capacity = length;
        return array;
    }

    public T[] append(T element) {
        if ((length + 1) > capacity) {
            capacity = length * 2;
            var newArray = (T[]) new Object[capacity];
            arraycopy(array, 0, newArray, 0, length);
            newArray[length++] = element;
            array = newArray;
            return array;
        }
        array[length++] = element;
        return array;
    }

    @SafeVarargs
    public final void add(T... elements) {
        for (T item: elements) {
            append(item);
        }
    }

    public T[] removeAtIndex(int index) {
        if (index < 0 || index >= length) throw new ArrayIndexOutOfBoundsException();

        capacity = --length;
        arraycopy(array, index+1, array, index, length-index);
        array[length] = null;
        return array;
    }

    public T[] removeFirst() { return removeAtIndex(0); }

    public T[] removeLast() { return removeAtIndex(length - 1); }

    public T[] remove() { return removeLast(); }
}
