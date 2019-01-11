package demo.se.utest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Predicate;

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
        assertThat(head.revert()).matches(getRevertedPredicate(head));
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

    private Predicate<? super Node<Integer>> getRevertedPredicate(Node<Integer> src) {
        return (reverted) -> {
            ArrayList<Integer> srcValues = getValuesList(src);
            ArrayList<Integer> revertedValues = getValuesList(reverted);

            System.out.println(srcValues);
            System.out.println(revertedValues);
            if (srcValues.size() != revertedValues.size()) {
                return false;
            }
            for (int i = 0, j = srcValues.size() - 1; i < srcValues.size(); i++, j--) {
                if (!Objects.equals(srcValues.get(i), revertedValues.get(j))) {
                    System.out.println(i + ", " + j);
                    return false;
                }
            }
            return true;
        };
    }

    private ArrayList<Integer> getValuesList(Node<Integer> src) {
        ArrayList<Integer> srcValues = new ArrayList<>();
        Node<Integer> pointer = src;
        do {
            srcValues.add(pointer.getValue());
        } while ((pointer = pointer.getNext()) != null);
        return srcValues;
    }


}