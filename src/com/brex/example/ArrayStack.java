package com.brex.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/**
 * ArrayStack implements a stack using an ArrayList. This collection is the Java implementation of the Dynamic Array
 * data structure. When compared to a LinkedList implementation, this implementation provides for better spatial
 * locality and fewer memory allocation at the cost of storage efficiency.
 *
 * @param <T>
 */
public class ArrayStack<T> implements Stack<T> {

    private final ArrayList<T> list;

    private int lastIndex() {
        return list.size() - 1;
    }

    public ArrayStack(int initialCapacity) {
        list = new ArrayList<>(initialCapacity);
    }

    public ArrayStack(Collection<? extends T> collection) {
        list = new ArrayList<>(collection);
    }

    public ArrayStack() {
        list = new ArrayList<>();
    }

    @Override
    public void push(T value) {
        list.add(value);
    }

    @Override
    public T pop() {
        T value = peek();
        if (value != null) {
            list.remove(lastIndex());
        }
        return value;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return list.get(lastIndex());
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayStack<?> that = (ArrayStack<?>) o;
        return list.equals(that.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }

    @Override
    public String toString() {
        return "ArrayStack{" +
                "list=" + list +
                '}';
    }

    @Override
    public Object clone() {
        return new ArrayStack<T>((ArrayList<T>) list.clone());
    }
}
