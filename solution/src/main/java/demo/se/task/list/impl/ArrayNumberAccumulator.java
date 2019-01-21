package demo.se.task.list.impl;

import demo.se.task.list.Task1_NumberAccumulator;

public class ArrayNumberAccumulator implements Task1_NumberAccumulator {
    private int[] numbers = new int[10];
    private int headIndex = -1;
    private int tailIndex = numbers.length;

    @Override
    public void add(int value) {
        if (value < 0) {
            addToHead(value);
        } else {
            addToTail(value);
        }

    }

    private void addToHead(int value) {
        headIndex++;
        if (headIndex == tailIndex) {
            grow(headIndex - 1, tailIndex);
        }
        numbers[headIndex] = value;
    }

    private void addToTail(int value) {
        tailIndex--;
        if (headIndex == tailIndex) {
            grow(headIndex, tailIndex + 1);
            tailIndex--;
        }
        numbers[tailIndex] = value;
    }

    private void grow(int headIndex, int tailIndex) {
        int minCapacity = numbers.length + 1;
        if (minCapacity < numbers.length) {
            throw new OutOfMemoryError();
        }
        int newCapacity = numbers.length * 2;
        if (newCapacity < minCapacity) {
            newCapacity = Integer.MAX_VALUE;
        }
        int[] newNumbers = new int[newCapacity];
        int tailSize = numbers.length - tailIndex;
        int newTailIndex = newCapacity - tailSize;
        this.tailIndex = newTailIndex;
        if (headIndex >= 0) {
            System.arraycopy(numbers, 0, newNumbers, 0, headIndex + 1);
        }

        if (tailIndex < numbers.length) {
            System.arraycopy(numbers, tailIndex, newNumbers, newTailIndex, tailSize);
        }
        this.numbers = newNumbers;
    }

    @Override
    public String get() {
        StringBuilder builder = new StringBuilder();
        for (int i = headIndex; i >= 0; i--) {
            builder.append(numbers[i]).append(",");
        }
        for (int i = numbers.length - 1; i >= tailIndex; i--) {
            builder.append(numbers[i]).append(",");
        }
        if (builder.length() > 0) {
            builder.delete(builder.length() - 1, builder.length());
        }
        return builder.toString();
    }
}
