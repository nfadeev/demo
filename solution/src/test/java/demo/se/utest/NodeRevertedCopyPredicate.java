package demo.se.utest;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.function.Predicate;

public class NodeRevertedCopyPredicate<T> implements Predicate<Node<T>> {
    private final Node<T> src;

    public NodeRevertedCopyPredicate(Node<T> src) {
        this.src = src;
    }

    @Override
    public boolean test(Node<T> reverted) {
        Deque<T> srcStack = getValuesStack(src);

        Node<T> node = reverted;
        do {
            if (srcStack.isEmpty() || !Objects.equals(srcStack.pollLast(), node.getValue())) {
                return false;
            }
        } while ((node = node.getNext()) != null);
        return srcStack.isEmpty();
    }

    private Deque<T> getValuesStack(Node<T> src) {
        ArrayDeque<T> stack = new ArrayDeque<>();
        Node<T> pointer = src;
        do {
            stack.add(pointer.getValue());
        } while ((pointer = pointer.getNext()) != null);
        return stack;
    }
}
