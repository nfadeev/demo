package demo.se.task;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class IntegerTest {
    @Parameterized.Parameters(name = "Parse string {0}, expected {1}")
    public static List<Object[]> params() {
        return Arrays.asList(new Object[][]{
                {"1", 1},
                {"2", 2},
                {"101", 101},
        });
    }

    private final String input;
    private final int expected;

    public IntegerTest(String input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void testParse() {
        Assertions.assertThat(Integer.parseInt(input)).isEqualTo(expected);
    }

    @Test
    public void print() {
        System.out.println(input);
    }
}
