package demo.se;

import java.util.ArrayList;

public class Siblings {
    public int get(int value, int limit) {
        if (value <= 11) {
            return (value <= limit) ? value : -1;
        }
        ArrayList<Integer> sortedDigits = getSortedDescDigits(value);

        int result = 0;
        for (int i = 0; i < sortedDigits.size(); i++) {
            result = result * 10 + sortedDigits.get(i);
        }
        return result;
    }

    private ArrayList<Integer> getSortedDescDigits(int value) {
        ArrayList<Integer> digits = new ArrayList<>();
        int i = value;
        while (i >= 10) {
            digits.add(i % 10);
            i /= 10;
        }
        digits.add(i);
        digits.sort((i1, i2) -> -Integer.compare(i1, i2));
        return digits;
    }
}
