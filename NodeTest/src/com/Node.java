package com;

public class Node <E> {
    Node<E> prev;
    Node<E> next;
    E element;

    public Node(Node prev, Node next, E element) {
        this.prev = prev;
        this.next = next;
        this.element = element;
    }

    @Override
    public String toString() {
        return "["+element+"]";
    }


}
