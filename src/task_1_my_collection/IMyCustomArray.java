package task_1_my_collection;

public interface IMyCustomArray<E> {

    public boolean add(Object elem);

    public E get(int index);

    public boolean remove(int index);

    public boolean contains(Object elem);

    public boolean removeCollection();

    public int size();

    public void resize(int newLength);

    public void add(int index, E elem);


}