package demo.se.interface_vs_abstract;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.Assumptions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assumptions.assumeThat;

public class CounterTest {
    @Test
    public void it_should_works() {
        Counter counter = new CounterImpl();
        assumeThat(counter.getCount()).isEqualTo(0);

        assertThat(counter.incAndGet()).isEqualTo(1);
    }

    @Test
    public void array() {
        Counter[] src = new Counter[]{new CounterImpl()};
        Counter[] dst = new Counter[1];
        assumeThat(src.length).isEqualTo(1);
        assumeThat(src[0]).isNotNull();
        assumeThat(dst[0]).isNull();

//        System.arraycopy(src, 0, dst, 0, src.length);

        for (int i = 0; i < src.length; i++) {
            dst[i] = new CounterImpl(src[i].getCount());
        }

        assertThat(dst[0]).isNotNull();
        assertThat(dst[0].getCount()).isEqualTo(0);
        src[0].inc();
        assertThat(dst[0].getCount()).isEqualTo(0);

        int[] i1 = new int[] {0};
        int[] i2 = new int[] {1};
        System.out.println(i1[0]);
        System.out.println(i2[0]);
        System.out.println("------");
        System.arraycopy(i1, 0, i2, 0, 1);
        i1[0] = 5;
        System.out.println(i1[0]);
        System.out.println(i2[0]);
    }
}