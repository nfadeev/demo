package demo.se;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Ignore;
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
    @Ignore
    public void twelveLimitedWith15() {
        int value = 12;
        int limit = 15;
        Assertions.assertThat(siblings.get(value, limit)).isEqualTo(12);
    }
}