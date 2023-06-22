package old;

import java.util.NoSuchElementException;

public class Queue<E> {

    Node<E> first;
    Node<E> last;
    int size;

    public Queue() {
        first = null;
        last = null;
        size = 0;
    }

    public void enqueue(E e) {
        Node<E> newNode = new Node(e);
        if(size == 0) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    public E dequeue() {
        if(size == 0) {
            throw new NoSuchElementException();
        }

        Node<E> temp = first;
        first = first.next;
        temp.next = null;

        size--;

        return temp.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E peek() {
        return first.data;
    }

    public int size() {
        return size;
    }

    private class Node<E>{

        Node<E> next;
        E data;

        public Node(E e) {
            data = e;

        }
    }

}
