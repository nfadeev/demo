package demo.se.task.list.impl;

import demo.se.task.list.Task1_NumberAccumulator;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;
import java.util.zip.ZipInputStream;

@RunWith(Parameterized.class)
public class ListNumberAccumulatorTest {

    private static Supplier<Task1_NumberAccumulator> instanceSupplier;

    @Parameterized.Parameters
    public static List<Object[]> params() throws IOException {
        return loadTestDataFromFile();
    }

    private final List<Integer> inputList;
    private final String expected;
    private Task1_NumberAccumulator accumulator;

    public ListNumberAccumulatorTest(List<Integer> inputList, String expected) {
        this.inputList = inputList;
        this.expected = expected;
    }

    @Before
    public void setUp() throws Exception {
        accumulator = instanceSupplier.get();
    }

    @Test(timeout = 1000)
    public void testAccumulator() {
        inputList.forEach(accumulator::add);
        Assertions.assertThat(accumulator.get()).isEqualTo(expected);
    }

    @BeforeClass
    public static void load() {
        String implementation = System.getProperty("accumulator.implementation", "array");
        switch (implementation) {
            case "array":
                instanceSupplier = ArrayNumberAccumulator::new;
                break;
            case "linked-list":
                instanceSupplier = () -> new ListNumberAccumulator(new LinkedList<>());
                break;
            case "array-list":
                instanceSupplier = () -> new ListNumberAccumulator(new ArrayList<>());
                break;
            case "array-deque":
                instanceSupplier = () -> new DequeNumberAccumulator(new ArrayDeque<>());
                break;
        }
    }

    private static ArrayList<Object[]> loadTestDataFromFile() throws IOException {
        String testDataFileName = System.getProperty("test.data", "basic-test-1.csv");
        BufferedReader reader = getReader(testDataFileName);
        ArrayList<Object[]> list = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            String[] values = line.split(";");
            if (values.length == 0) {
                list.add(new Object[]{new ArrayList<Integer>(), ""});
                continue;
            }
            String[] numbers = values[0].split(",");
            ArrayList<Integer> inputList = new ArrayList<>();
            for (String number : numbers) {
                inputList.add(Integer.parseInt(number));
            }
            String expected = values[1];
            list.add(new Object[]{inputList, expected});
        }
        return list;
    }

    private static BufferedReader getReader(String testDataFileName) throws IOException {
        InputStream stream = ListNumberAccumulatorTest.class.getClassLoader().getResourceAsStream(testDataFileName);
        if (testDataFileName.endsWith(".csv")) {
            return new BufferedReader(new InputStreamReader(stream));
        }
        ZipInputStream zip = new ZipInputStream(stream);
        zip.getNextEntry();
        return new BufferedReader(new InputStreamReader(zip));
    }
}