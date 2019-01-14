package demo.se.collections.list;

import java.util.Iterator;

public class UniDirectionalLinkedList<E> implements Iterable<E> {

    private Node<E> head;

    public UniDirectionalLinkedList<E> revert() {
        return this;
    }

    public void add(E element) {
        if (head == null) {
            head = new Node<>(element);
            return;
        }
        Node<E> tail = getTail();
        tail.next = new Node<>(element);
    }

    private Node<E> getTail() {
        Node<E> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        return tail;
    }

    @Override
    public Iterator<E> iterator() {
        return new NodeIterator<E>(head);
    }

    static class NodeIterator<E> implements Iterator<E> {
        private Node<E> node;

        NodeIterator(Node<E> node) {
            this.node = node;
        }

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public E next() {
            E value = node.element;
            node = node.next;
            return value;
        }
    }

    static class Node<E> {
        Node(E element) {
            this.element = element;
        }

        private E element;
        private Node<E> next;
    }
}
