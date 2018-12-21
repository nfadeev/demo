package demo.se.interface_vs_abstract;

public abstract class AbstractCounter {
    protected int count;

    protected abstract void inc();

    abstract void reset();

    public abstract int getCount();
}
