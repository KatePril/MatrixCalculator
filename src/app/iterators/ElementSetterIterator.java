package app.iterators;

public interface ElementSetterIterator<E> {
    boolean hasNext();
    void setNext(E value);
}
