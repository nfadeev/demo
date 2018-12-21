package demo.se.interface_vs_abstract;

public class CounterImpl implements Counter {
    private int count;

    public CounterImpl() {
    }

    public CounterImpl(int count) {
        this.count = count;
    }

    @Override
    public void inc() {
        count++;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public void reset() {
        count = 0;
    }
}
