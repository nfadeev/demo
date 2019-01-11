package demo.se.utest;

public class Node<T> {
    private final T value;
    private Node next;

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> revert() {
        Node<T> pointer = this;
        Node<T> reverted = new Node<>(pointer.value);
        while (pointer.next != null) {
            pointer = pointer.getNext();
            Node<T> tail = reverted;
            reverted = new Node<>(pointer.value);
            reverted.next = tail;
        }
        return reverted;
    }
}
