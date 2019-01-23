package demo.se;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Siblings {
    public int get(int value, int limit) {
        if (value <= 11) {
            return (value <= limit) ? value : -1;
        }
        ArrayList<Integer> numberDigits = getDigits(value);
        numberDigits.sort((i1, i2) -> -Integer.compare(i1, i2));


        int result = getMaxValue(numberDigits);
        if (result <= limit) {
            return result;
        }
        result = getMinValue(numberDigits);
        System.out.println("minValue = " + result);
        if (result > limit) {
            return -1;
        }
        return findMaxSibling(numberDigits, limit);
    }

    private int findMaxSibling(List<Integer> numberDigits, int limit) {
        int maxSibling = 0;
        numberDigits = new LinkedList<>(numberDigits);
        ArrayList<Integer> limitDigits = getDigits(limit);
        for (int i = limitDigits.size() - 1; i >= 0; i--) {
            for (int j = 0; j < numberDigits.size(); j++) {
                if (limitDigits.get(i) >= numberDigits.get(j)) {
                    maxSibling = maxSibling * 10 + numberDigits.remove(j);
                    break;
                }
            }
        }
        return maxSibling;
    }

    private int getMaxValue(ArrayList<Integer> sortedDigits) {
        if (couldBeIntegerOwerflow(sortedDigits)) {
            return findMaxSibling(sortedDigits, Integer.MAX_VALUE);
        }
        int result = 0;
        for (Integer i : sortedDigits) {
            result = result * 10 + i;
        }
        return result;
    }

    private boolean couldBeIntegerOwerflow(ArrayList<Integer> sortedDigits) {
        return sortedDigits.size() == 10 && sortedDigits.get(0) > 1;
    }

    private int getMinValue(ArrayList<Integer> digits) {
        int result = 0;
        for (int i = digits.size() - 1; i >= 0; i--) {
            result = result * 10 + digits.get(i);
        }
        return result;
    }

    private ArrayList<Integer> getDigits(int value) {
        ArrayList<Integer> digits = new ArrayList<>();
        int i = value;
        while (i >= 10) {
            digits.add(i % 10);
            i /= 10;
        }
        digits.add(i);
        return digits;
    }
}
