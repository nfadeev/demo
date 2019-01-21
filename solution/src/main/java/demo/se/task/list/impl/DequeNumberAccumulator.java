package demo.se.task.list.impl;

import demo.se.task.list.Task1_NumberAccumulator;

import java.util.Deque;

public class DequeNumberAccumulator implements Task1_NumberAccumulator {
    private final Deque<Integer> deque;

    public DequeNumberAccumulator(Deque<Integer> deque) {
        this.deque = deque;
    }

    @Override
    public void add(int value) {
        if (value < 0) {
            deque.addFirst(value);
        } else {
            deque.addLast(value);
        }
    }

    @Override
    public String get() {
        StringBuilder builder = new StringBuilder();
        deque.forEach(value -> builder.append(value).append(","));
        if (builder.length() > 0) {
            builder.delete(builder.length() - 1, builder.length());
        }
        return builder.toString();
    }
}
