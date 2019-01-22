package demo.se.task.list.kavun;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by vid4i on 21.01.2019.
 */
public class Kavun_Task1Test {

    private Kavun_Task1 task1;

    @Before
    public void precond() {
        task1 = new Kavun_Task1(new ArrayList<>());
    }

    @Test
    public void addMultipleValues() {

        //-10 -> 10 -> 1 -> -5 -> 0
        //"-5,-10,10,1,0"

        task1.add(-10);
        task1.add(10);
        task1.add(1);
        task1.add(-5);
        task1.add(0);

        assertEquals("-5,-10,10,1,0", task1.get());
    }

    @Test
    public void add_initConstructorWithNull() {

        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> {
            new Kavun_Task1(null);
        });
    }

    @Test
    public void getEmptyString() {
        assertEquals("", task1.get());
    }

}