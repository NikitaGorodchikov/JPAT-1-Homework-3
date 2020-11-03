import java.util.Iterator;
import java.util.Random;

public class MyIterator implements Iterator<Integer> {
    protected Random random = new Random();
    int max;
    int min;

    public MyIterator(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() {
        int diff = this.max - this.min;
        int i = random.nextInt(diff + 1);
        i += this.min;
        return i;
    }
}
