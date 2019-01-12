package demo.se.utest;

import org.assertj.core.api.Condition;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NodeTest {

    private final int HEAD_NODE_VALUE = 1;

    @Test
    public void onRevertCopyIsReturned() {
        Node<Integer> node = new Node<>(HEAD_NODE_VALUE);
        Node reverted = node.revert();
        assertThat(reverted)
                .isNotNull()
                .isNotSameAs(node);
        assertThat(reverted.getValue())
                .isEqualTo(HEAD_NODE_VALUE)
                .isEqualTo(node.getValue());
    }

    @Test
    public void revertIsWorkingWithTwoNodes() {
        Node<Integer> head = createNode(1, 2, 3, 4, 5, 6, 7);
        assertThat(head.revert()).is(revertedCopyOf(head));
    }

    private Node<Integer> createNode(int... values) {
        Node<Integer> head = null;
        Node<Integer> tail = null;
        for (int i : values) {
            if (head == null) {
                head = new Node<>(i);
                tail = head;
                continue;
            }
            Node<Integer> node = new Node<>(i);
            tail.setNext(node);
            tail = node;
        }
        return head;
    }

    private Condition<? super Node<Integer>> revertedCopyOf(Node<Integer> src) {
        return new Condition<>(new NodeRevertedCopyPredicate<>(src), "reverted copy of %s", src);
    }

}