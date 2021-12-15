package solution2;

import java.util.LinkedList;

public class BlockingContainer<T> {
    private final int limit;
    private LinkedList<T> list = new LinkedList<>();

    public BlockingContainer(int limit) {
        this.limit = limit;
    }

    public void put(T item) {
        synchronized (this.list) {
            while (this.list.size() == this.limit) {
                try {
                    this.list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.list.add(item);
            this.list.notifyAll();
        }
    }

    public T take() {
        T item;
        synchronized (this.list) {
            while (this.list.isEmpty()) {
                try {
                    this.list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            item = this.list.getFirst();
            this.list.removeFirst();
            this.list.notifyAll();
        }
        return item;
    }

    public int getLimit() {
        return limit;
    }

    public int getSize() {
        return this.list.size();
    }
}
