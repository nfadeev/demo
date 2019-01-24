package demo.se;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class SiblingsParamTest {
    @Parameterized.Parameters
    public static List<Object[]> params() {
        return Arrays.asList(new Object[][]{
                {0, 0, 0},
                {1, 1, 1},
                {1, 0, -1},
                {1111000, 10000, 1111},
                {111000, 10000, 1110},
                {2147483647, 2147483646, 2147483476},
                {2147483647, 2147483635, 2147483476},
                {1234567890, 1234567891, 1234567890},
                {1234567890, Integer.MAX_VALUE, 2147398650},
                {123456789, Integer.MAX_VALUE, 987654321},
                {123456789, 900000000, 897654321},
        });
    }

    private final int number;
    private final int limit;
    private final int expected;

    public SiblingsParamTest(int number, int limit, int expected) {
        this.number = number;
        this.limit = limit;
        this.expected = expected;
    }

    @Test
    public void test() {
        Assertions.assertThat(new Siblings().get(number, limit)).isEqualTo(expected);
    }
}