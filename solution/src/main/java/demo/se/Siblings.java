package demo.se;

import java.util.Arrays;
import java.util.TreeMap;

public class Siblings {
    public int get(int number, int limit) {
        if (number < 10) {
            return (number <= limit) ? number : -1;
        }
        int[] numberDigits = getSortedDigits(number);

        int maxNumber = getMaxNumber(numberDigits);
        if (maxNumber <= limit) {
            return maxNumber;
        }
        if (getMinNumber(numberDigits) > limit) {
            return -1;
        }
        return new MaxSiblingFinder(numberDigits, limit).find();
    }

    private int[] getSortedDigits(int number) {
        int[] numberDigits = getDigits(number);
        Arrays.sort(numberDigits);
        return numberDigits;
    }

    private int getMaxNumber(int[] sortedDigits) {
        if (couldBeIntegerOverflow(sortedDigits)) {
            return new MaxSiblingFinder(sortedDigits, Integer.MAX_VALUE).find();
        }
        int result = 0;
        for (int i = sortedDigits.length - 1; i >= 0; i--) {
            result = result * 10 + sortedDigits[i];
        }
        return result;
    }

    private boolean couldBeIntegerOverflow(int[] sortedDigits) {
        return sortedDigits.length == 10 && sortedDigits[sortedDigits.length - 1] > 1;
    }

    private int getMinNumber(int[] digits) {
        return digitsToNumber(digits);
    }

    private static int digitsToNumber(int[] digits) {
        int result = 0;
        for (int d : digits) {
            result = result * 10 + d;
        }
        return result;
    }

    private static int[] getDigits(int number) {
        int[] digits = new int[getDigitsCount(number)];
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }
        return digits;
    }

    private static int getDigitsCount(int number) {
        int count = 1;
        while (number > 9) {
            number /= 10;
            count++;
        }
        return count;
    }

    private static class MaxSiblingFinder {
        private final TreeMap<Integer, Integer> digitMap = new TreeMap<>();
        private int[] result;
        private int[] limitDigits;

        MaxSiblingFinder(int[] numberDigits, int limit) {
            this.limitDigits = getDigits(limit);
            for (int digit : numberDigits) {
                addDigit(digit);
            }
        }

        int find() {
            result = new int[limitDigits.length];
            int i = 0;
            while (i < result.length) {
                int d = getFloorDigit(limitDigits[i]);
                if (d == -1) {
                    i = decrease(i);
                    fillRemainingInMaxOrder(i);
                    break;
                }
                result[i] = d;
                if (d < limitDigits[i]) {
                    fillRemainingInMaxOrder(++i);
                    break;
                }
                i++;
            }
            return digitsToNumber(result);
        }

        private int decrease(int index) {
            do {
                index--;
                int d = result[index];
                addDigit(d);
                if (d != 0 && (d = getFloorDigit(--d)) != -1) {
                    result[index] = d;
                    index++;
                    break;
                }
            } while (index > 0);
            return index;
        }

        private void fillRemainingInMaxOrder(int index) {
            for (int i = index; i < result.length; i++) {
                result[i] = getFloorDigit(9);
            }
        }

        private void addDigit(int digit) {
            digitMap.compute(digit, (key, value) -> value == null ? 1 : ++value);
        }

        private int getFloorDigit(int digit) {
            Integer d = digitMap.floorKey(digit);
            if (d == null) {
                return -1;
            }
            digitMap.computeIfPresent(d, (key, value) -> --value == 0 ? null : value);
            return d;
        }
    }
}
