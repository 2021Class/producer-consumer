package solution2;

public class Consumer implements Runnable{
    private final BlockingContainer<Integer> bContainer;
    private int consumeCount;

    public Consumer(BlockingContainer bContainer, int consumeCount) {
        this.bContainer = bContainer;
        this.consumeCount = consumeCount;
    }

    @Override
    public void run() {
        for (int i = this.consumeCount; i > 0; i--) {
            int item = this.bContainer.take();
            System.out.println("Consumer " + Thread.currentThread().getName() + " consumed " + item);
        }
    }
}
