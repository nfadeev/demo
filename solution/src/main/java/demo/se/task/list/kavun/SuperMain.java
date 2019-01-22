package demo.se.task.list.kavun;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by vid4i on 20.01.2019.
 */
public class SuperMain {
    public static void main(String[] args) {

        // Init my class with ArrayList
        Kavun_Task1 task1 = new Kavun_Task1(new ArrayList<>());

        // tail
        task1.add(1);
        task1.add(5);
        task1.add(10);

        // head
        task1.add(-5);
        task1.add(-1);
        task1.add(-155);
        task1.add(1556);

        System.out.println("ArrayList implementation "+task1.get());

        // Init via LinkedList
        Kavun_Task1 task2 = new Kavun_Task1(new LinkedList<>());

        // tail
        task2.add(0);
        task2.add(2);
        task2.add(11);

        // head
        task2.add(-1);
        task2.add(-2);
        task2.add(-2);
        task2.add(15);

        System.out.println("LinkedList implementation " + task2.get());

    }
}
