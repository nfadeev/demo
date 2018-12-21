package demo.se.interface_vs_abstract;

public interface HasCount {
    int count = 0;

    default int getCount() {
        return count;
    }
}
