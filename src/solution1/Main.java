package solution1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>(10);
        Producer p1 = new Producer(blockingQueue);
        Producer p2 = new Producer(blockingQueue);
        Producer p3 = new Producer(blockingQueue);
        Producer p4 = new Producer(blockingQueue);
        Consumer c1 = new Consumer(blockingQueue);
        Consumer c2 = new Consumer(blockingQueue);

        c1.consume(30);
        p1.produce(20);
        p2.produce(20);
        c2.consume(50);
        p3.produce(20);
        p4.produce(20);
    }
}
