package old;

import java.util.EmptyStackException;

public class Stack<E> {

    int DEFAULT_CAPACITY = 13;
    private E[] stack;
    private int size;

    public Stack () {
        stack = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void push(E e) {
        //make sure that the array is not full
        //put the e in the array and increment size

        if(stack.length == size) {
            resize();
        }

        stack[size] = e;

        size++;
    }

    public E pop() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }

        E curr = stack[size - 1];
        size--;

        return curr;
    }

    private void resize() {
        E[] newStack = (E[]) new Object[stack.length * 2];

        for (int i = 0; i < stack.length; i++) {
            newStack[i] = stack[i];
        }

        stack = newStack;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E peek() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[size - 1];
    }
}
