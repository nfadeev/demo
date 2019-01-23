package demo.se.task.list;

/**
 *
 */
public interface Task2_NumberSortingAccumulator {
    /**
     * <p>Input</p>
     * store negative numbers in head of list, positive numbers - in tail
     *
     * @param value a number
     */
    void add(int value);

    /**
     * Input:1,2,4,3,-1,0,4,5
     * <p>Output:</p><p>ASC: -1,0,1,2,3,4,4,5</p> DESC: 5,4,4,3,2,1,0,-1
     *
     * @return stored result as String
     */
    default String get() {
        return get(SortType.ASC);
    }

    String get(SortType type);

    enum SortType {
        ASC,
        DESC
    }
}
