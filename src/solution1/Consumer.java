package solution1;

import java.util.concurrent.BlockingQueue;

public class Consumer {
    private BlockingQueue<String> bQueue;

    public Consumer(BlockingQueue bQueue) {
        this.bQueue = bQueue;
    }

    public void consume(int consumeCount) {
        new Thread(() -> {
            for (int i = 0; i < consumeCount; i++) {
                String item;
                try {
                    item = bQueue.take();
                    System.out.println("Consumer " + Thread.currentThread().getName() + " consumed " + item);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
