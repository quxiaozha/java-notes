package com.quxun.algorithms;

/**
 * Description:
 * Created by quxiaozha on 2018-9-26 16:27.
 */
public interface ILink<E> {
    void add(E data);

    int size();

    E get(int index);

    boolean isEmpty();

    boolean contains(E data);

    void set(int index, E data);

    void remove(E data);

    void clean();

    Object[] toArray();
}
