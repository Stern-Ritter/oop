package ru.gb.list;

import java.util.Collection;

public interface MyList<E> extends Iterable<E> {
    void add(E e);

    void addAll(Collection<? extends E> c);

    void add(int index, E e);

    E set(int index, E element);

    E get(int index);

    boolean remove(E e);

    boolean contains(E e);

    int size();

    boolean isEmpty();

    void clear();
}
