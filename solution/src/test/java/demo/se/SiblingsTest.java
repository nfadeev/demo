package demo.se;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class SiblingsTest {

    private Siblings siblings;

    @Before
    public void setUp() {
        siblings = new Siblings();
    }

    @Test
    public void zero() {
        int value = 0;
        int limit = 0;
        Assertions.assertThat(siblings.get(value, limit)).isEqualTo(0);
    }

    @Test
    public void one() {
        int value = 1;
        int limit = 1;
        Assertions.assertThat(siblings.get(value, limit)).isEqualTo(1);
    }

    @Test
    public void limit() {
        int value = 1;
        int limit = 0;
        Assertions.assertThat(siblings.get(value, limit)).isEqualTo(-1);
    }

    @Test
    public void twelve() {
        int value = 12;
        int limit = 100;
        Assertions.assertThat(siblings.get(value, limit)).isEqualTo(21);
    }

    @Test
    public void twelveLimitedWith15() {
        int value = 12;
        int limit = 15;
        Assertions.assertThat(siblings.get(value, limit)).isEqualTo(12);
    }

    @Test
    public void tenLimitedWith5() {
        int value = 10;
        int limit = 5;
        Assertions.assertThat(siblings.get(value, limit)).isEqualTo(1);
    }

    @Test
    public void maxInt() {
        int value = Integer.MAX_VALUE;
        int limit = Integer.MAX_VALUE;
        Assertions.assertThat(siblings.get(value, limit)).isEqualTo(Integer.MAX_VALUE);
    }

    @Test
    public void billionLimitedWith15() {
        int value = 1000000000;
        int limit = 15;
        Assertions.assertThat(siblings.get(value, limit)).isEqualTo(10);
    }

    @Test
    public void test() {
        System.out.println(siblings.get(1111000, 10000));
    }
}