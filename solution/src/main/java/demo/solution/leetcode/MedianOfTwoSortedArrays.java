package demo.solution.leetcode;

public class MedianOfTwoSortedArrays {
    private final int[] array1;
    private final int[] array2;
    private final long totalLength;
    private int index1;
    private int index2;
    private int nextStep;
    private int balancingDirection;
    private Logger logger = (m, a1, a2, i1, i2) -> {
    };

    public MedianOfTwoSortedArrays(int[] arrayOne, int[] arrayTwo) {
        this.array1 = arrayOne;
        this.array2 = arrayTwo;
        this.totalLength = (long) arrayOne.length + arrayTwo.length;
    }

    public double findMedian() {
        setIndexesToTheMiddle();
        while (!isBalanced()) {
            balance();
        }
        return calculate();
    }

    private void setIndexesToTheMiddle() {
        index1 = array1.length / 2;
        index2 = (int) (totalLength / 2 - index1);
        nextStep = (int) (totalLength / 2);
        log("Initial state: indexes at the middle");
    }

    private boolean isBalanced() {
        balancingDirection = getBalancingDirection();
        return balancingDirection == 0;
    }

    private int getBalancingDirection() {
        if (shouldIndex1MoveLeft()) {
            return -1;
        }
        if (shouldIndex1MoveRight()) {
            return 1;
        }
        return 0;
    }

    private boolean shouldIndex1MoveLeft() {
        return (isIndexAbleToMoveLeft(index1)
                && isIndexAbleToMoveRight(index2, array2)
                && array1[index1 - 1] > array2[index2]);
    }

    private boolean shouldIndex1MoveRight() {
        return isIndexAbleToMoveLeft(index2)
                && isIndexAbleToMoveRight(index1, array1)
                && array1[index1] < array2[index2 - 1];
    }

    private boolean isIndexAbleToMoveLeft(int index) {
        return index > 0;
    }

    private boolean isIndexAbleToMoveRight(int index, int[] array) {
        return index < array.length;
    }

    private void balance() {
        int step = balancingDirection * getStep();
        index1 += step;
        index2 -= step;
        log("balance, step = " + step);
    }

    private int getStep() {
        if (nextStep < 2) {
            return 1;
        }
        int step = Math.min(nextStep, getMaxPosibleStep());
        nextStep = step / 2;
        return step;
    }

    private int getMaxPosibleStep() {
        return balancingDirection < 0 ? Math.min(index1, array2.length - index2) : Math.min(index2, array1.length - index1);
    }

    private double calculate() {
        if (totalLength == 0) {
            return 0;
        }
        return isTotalLenghtEven() ? calculateForEven() : calculateForOdd();
    }

    private boolean isTotalLenghtEven() {
        return totalLength % 2 == 0;
    }

    private double calculateForEven() {
        return ((double) getMaxValueOnTheLeft() + getMinValueOnTheRight()) / 2;
    }

    private int getMaxValueOnTheLeft() {
        if (index1 == 0) {
            return array2[index2 - 1];
        }
        if (index2 == 0) {
            return array1[index1 - 1];
        }
        return Math.max(array1[index1 - 1], array2[index2 - 1]);
    }

    private int getMinValueOnTheRight() {
        if (index1 == array1.length) {
            return array2[index2];
        }
        if (index2 == array2.length) {
            return array1[index1];
        }
        return Math.min(array1[index1], array2[index2]);
    }

    private double calculateForOdd() {
        if (index1 == array1.length) {
            return array2[index2];
        } else if (index2 == array2.length) {
            return array1[index1];
        }
        return Math.min(array1[index1], array2[index2]);
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    private void log(String message) {
        logger.log(message, array1, array2, index1, index2);
    }

    static interface Logger {
        void log(String message, int[] array1, int[] array2, int index1, int index2);
    }
}
