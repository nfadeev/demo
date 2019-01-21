package demo.solution.leetcode;

import demo.solution.leetcode.MedianOfTwoSortedArrays.Logger;
import demo.test.util.TestUtil;
import org.hamcrest.core.IsEqual;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Collection;

import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class MedianOfTwoSortedArraysTest {
    private int[] array1;
    private int[] array2;
    private double expectedResult;
    private String description;

    @Parameters(name = "{0}")
    public static Collection<Object[]> getData() {
        return TestUtil.loadTestData("median-of-two-sorted-arrays.json", TestData.class,
                data -> new Object[] {data.description, data.array1, data.array2, data.expected});
    }

    public MedianOfTwoSortedArraysTest(String description, int[] array1, int[] array2, double expectedResult) {
        this.description = description;
        this.array1 = array1;
        this.array2 = array2;
        this.expectedResult = expectedResult;
    }

    @Test
    public void test() {
        System.out.println(TestUtil.decorateHeader(description));
        MedianOfTwoSortedArrays medianFinder = new MedianOfTwoSortedArrays(array1, array2);
        medianFinder.setLogger(getLogger());
        double actualResult = medianFinder.findMedian();
        System.out.println("actual/expected result -> " + actualResult + "/" + expectedResult);
        assertThat(actualResult, IsEqual.equalTo(expectedResult));
    }

    private Logger getLogger() {
        return (message, array1, array2, index1, index2) -> {
            System.out.println(message);
            StringBuilder builder = new StringBuilder();
            log(builder, array1, index1, Math.max(index2 - index1, 0));
            builder.append('\n');
            log(builder, array2, index2, Math.max(index1 - index2, 0));
            System.out.println(builder.toString());
        };
    }

    private void log(StringBuilder builder, int[] array, int index, int offset) {
        builder.append('[');
        String separator = "|";
        for (int i = 0; i < offset; i++) {
            builder.append("    ");
        }
        for (int i = 0; i < array.length; i++) {
            if (i == index) {
                builder.append(separator);
            }
            builder.append(String.format("%1$3s", array[i])).append(',');
        }
        if (array.length > 0) {
            builder.delete(builder.length() - 1, builder.length());
        }
        if (index == array.length) {
            if (array.length > 0) {
                builder.append(' ');
            }
            builder.append(separator);
        }
        builder.append(']');
    }

    static class TestData {
        private String description;
        private int[] array1;
        private int[] array2;
        private double expected;

        public String getDescription() {
            return description;
        }

        public int[] getArray1() {
            return array1;
        }

        public int[] getArray2() {
            return array2;
        }

        public double getExpected() {
            return expected;
        }
    }
}
