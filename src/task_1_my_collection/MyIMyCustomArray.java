package task_1_my_collection;

import java.util.*;

public class MyIMyCustomArray<E> implements IMyCustomArray, Iterable<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private int currentIndex = -1;
    private int size;
    Object[] initArray = new Object[DEFAULT_CAPACITY];

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(Object elem) {
        if (size == initArray.length - 1)
            resize(initArray.length + 1);
        initArray[size++] = elem;
        return true;
    }

    @Override
    public Object get(int index) {
        return initArray[index];
    }

    @Override
    public boolean remove(int index) {
        boolean result = false;
        if (index >= 0) {
            for (int i = index; i < size; i++)
                initArray[i] = initArray[i + 1];
            initArray[size] = null;
            result = true;
        }
        return result;
    }

    @Override
    public boolean contains(Object elem) {
        boolean result = false;
        for (Object item : initArray) {
            if (elem.equals(item)) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean removeCollection() {
        Object[] newArray = new Object[size];
        initArray = newArray;
        return false;
    }

    @Override
    public void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(initArray, 0, newArray, 0, size);
        initArray = newArray;
    }

    @Override
    public void add(int index, Object elem) {
        Object[] newArray = new Object[size + 1];
        System.arraycopy(initArray, 0, newArray, 0, index);
        System.arraycopy(initArray, index, newArray, index + 1, size - index);
        initArray = newArray;
        initArray[index] = elem;
        size++;
    }

    @Override
    public Iterator<E> iterator() {
        return new OwnIterator<>();
    }

    private class OwnIterator<E> implements Iterator<E> {
        private int index = 0;

        private OwnIterator() {
        }

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public E next() {
            return (E) initArray[index++];
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(initArray);
    }
}
