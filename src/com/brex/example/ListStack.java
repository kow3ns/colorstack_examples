package com.brex.example;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Objects;

public class ListStack<T> implements Stack<T> {

    private final LinkedList<T> list;


    public ListStack(Collection<? extends T> collection) {
        list = new LinkedList<>(collection);
    }

    public ListStack() {
        list = new LinkedList<>();
    }

    @Override
    public void push(T value) {
        list.add(value);
    }

    @Override
    public T pop() {
        return list.pop();
    }

    @Override
    public T peek() {
        return list.peek();
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
        ListStack<?> that = (ListStack<?>) o;
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
        return new ListStack<T>((LinkedList<T>) list.clone());
    }

}
