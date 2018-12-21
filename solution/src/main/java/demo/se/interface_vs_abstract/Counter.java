package demo.se.interface_vs_abstract;

public interface Counter extends HasCount {
    void inc();

    void reset();

    @Override
    int getCount();

    default int incAndGet() {
        inc();
        return getCount();
    }
}
