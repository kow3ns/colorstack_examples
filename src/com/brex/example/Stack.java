package com.brex.example;

/**
 * Stack implements a LIFO (Last In First Out) collection. push(T) is used to insert values at the back of the stack.
 * pop(T) is used to remove values from the back of the stack. The interface provides for efficient inspection of the
 * last element in the Stack as well as the size of the stack.
 * @param <T>
 */
public interface Stack<T> {

    /**
     * push adds a value to the back of the Stack.
     * precondition - None
     * postcondition - value is copied to the last position of the Stack by reference. The size of the stack is
     * increased by one.
     *
     * @param value The T that will be placed on the Stack.
     */
    void push(T value);

    /**
     * pop removes and returns the value at the back of the Stack.
     * precondition - isEmpty() must be false.
     * postcondition - The value at the back of the Stack has been removed. The Stacks size is decreased by one.
     *
     * @return The value that was previously at the back of the Stack or null if isEmpty was true prior to invocation.
     */
    T pop();

    /**
     * peek returns a reference to the value at the back of the Stack.
     * precondition - isEmpty() must be false.
     * postcondition - The Stack is unmodified.
     *
     * @return The value that is currently at the back of the Stack or null if isEmpty is true.
     */
    T peek();

    /**
     * size returns the number of values in the Stack.
     * precondition - None.
     * postcondition - The Stack is unmodified.
     *
     * @return The number of values at the back of the Stack.
     */
    int size();

    /**
     * isEmpty returns true if the Stack contains no values.
     * precondition - None.
     * postcondition - The Stack is unmodified.
     *
     * @return True if the Stack contains no values. Otherwise false.
     */
    boolean isEmpty();
}
