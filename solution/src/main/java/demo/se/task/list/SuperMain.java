package demo.se.task.list;

/**
 * Created by vid4i on 20.01.2019.
 */
public class SuperMain {
    public static void main(String[] args) {

        // Init my class
        Kavun_Task1 task1 = new Kavun_Task1();

        // tail
        task1.add(1);
        task1.add(5);
        task1.add(10);

        // head
        task1.add(-5);
        task1.add(-1);
        task1.add(-155);
        task1.add(1556);

        System.out.println(task1.get());


    }
}
