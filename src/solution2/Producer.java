package solution2;

import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable{
    private static AtomicInteger itemCount = new AtomicInteger(1);

    private final BlockingContainer<Integer> bContainer;
    private int produceCount;

    public Producer(BlockingContainer bContainer, int produceCount) {
        this.bContainer = bContainer;
        this.produceCount = produceCount;
    }

    @Override
    public void run() {
        for (int i = this.produceCount; i > 0; i--) {
            int item = itemCount.getAndIncrement();
            this.bContainer.put(item);
            System.out.println("Producer " + Thread.currentThread().getName() + " produced " + item);
        }
    }
}
