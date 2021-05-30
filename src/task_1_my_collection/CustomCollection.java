package task_1_my_collection;

import java.util.ArrayList;

public class CustomCollection<T> {

    private ArrayList<T> list;

    public CustomCollection() {
        this.list = new ArrayList<>(20);
    }

    public CustomCollection(int listSize) {
        this.list = new ArrayList<>(listSize);
    }

    public int size() {
        return this.list.size();
    }

    public void add(T item) {
        this.list.add(item);
    }

    public void remove(int index) {
        this.list.remove(index);
    }

    public T getIndex(int index) {
        return this.list.get(index);
    }

    public boolean contains(T index) {
        return this.list.contains(index);
    }

    public void removeCollection() {
        this.list.clear();
    }

    @Override
    public String toString() {
        return "My custom collection: " + list;
    }

}
