package demo.se.interface_vs_abstract;

public class AbstractCounterImpl extends AbstractCounter {
    @Override
    public void inc() {
        count++;
    }

    @Override
    public void reset() {
        count++;
    }

    @Override
    public int getCount() {
        return count;
    }
}
