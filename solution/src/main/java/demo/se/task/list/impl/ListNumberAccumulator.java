package demo.se.task.list.impl;

import demo.se.task.list.Task1_NumberAccumulator;

import java.util.List;

public class ListNumberAccumulator implements Task1_NumberAccumulator {
    private final List<Integer> numbers;

    public ListNumberAccumulator(List<Integer> list) {
        this.numbers = list;
    }

    @Override
    public void add(int value) {
        if (value < 0) {
            numbers.add(0, value);
        } else {
            numbers.add(value);
        }
    }


    @Override
    public String get() {
        StringBuilder builder = new StringBuilder();
        numbers.forEach(value -> builder.append(value).append(","));
        if (builder.length() > 0) {
            builder.delete(builder.length() - 1, builder.length());
        }
        return builder.toString();
    }
}
