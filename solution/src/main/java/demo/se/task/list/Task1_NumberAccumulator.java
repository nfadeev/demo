package demo.se.task.list;

/**
 * Implementation should store negative numbers in head of list, positive numbers - in tail
 * <p>
 * Input: 0 -> 1 -> 2 -> 3
 * <br>
 * Output: "0,1,2,3"
 * </p>
 * <p>
 * Input: 0 -> 1 -> 2 -> 3 -> -1
 * <br>
 * Output: "-1,0,1,2,3"
 * </p>
 * <p>
 * Input: -10 -> 10 -> 1 -> -5 -> 0
 * <br>
 * Output: "-5,-10,10,1,0"
 * </p>
 */
public interface Task1_NumberAccumulator {
    /**
     * <p>Input</p>
     * store negative numbers in head of list, positive numbers - in tail
     *
     * @param value a number
     */
    void add(int value);

    /**
     * Output
     *
     * @return stored result as String
     */
    String get();
}
