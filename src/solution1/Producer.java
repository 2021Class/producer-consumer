package solution1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer {
    private static AtomicInteger itemCount = new AtomicInteger(1);

    private BlockingQueue<String> bQueue;

    public Producer (BlockingQueue bQueue) {
        this.bQueue = bQueue;
    }

    public void produce(int produceCount) {
        new Thread(() -> {
            for (int i = 0; i < produceCount; i++) {
                String item;
                try {
                    item = "Item: " + itemCount.getAndIncrement();
                    bQueue.put(item);
                    System.out.println("Producer " + Thread.currentThread().getName() + " produced " + item);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
