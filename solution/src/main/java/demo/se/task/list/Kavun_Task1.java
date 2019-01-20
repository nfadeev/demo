package demo.se.task.list;

import java.util.ArrayList;
import java.util.List;

public class Kavun_Task1 implements Task1_NumberAccumulator {

    // Init of ArrayList
    private List<Integer> list1 = new ArrayList<>();

    // methods implementation
    public void add(int value) {

        if (value >= 0) {
            // add object into the tail
            list1.add(value);
        } else {
            // add object into the head of collection
            list1.add(0, value);
        }
    }

    public String get() {

        // 1st option
        String result = "";

        for (int i = 0; i < list1.size(); i++) {
            result = result + list1.get(i).toString();
            if (i < list1.size() - 1) {
                result = result + ",";
            }
        }

        // 2nd option
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < list1.size(); i++) {
            builder.append(list1.get(i).toString());
            if (i < list1.size() - 1) {
                builder.append(",");
            }
        }

        return builder.toString();
    }

    ;


}
