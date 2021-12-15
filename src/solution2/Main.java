package solution2;

public class Main {
    public static void main(String[] args) {
        BlockingContainer<Integer> bc = new BlockingContainer<>(10);
        Producer p1 = new Producer(bc, 20);
        Producer p2 = new Producer(bc, 10);
        Producer p3 = new Producer(bc, 30);
        Producer p4 = new Producer(bc, 20);
        Consumer c1 = new Consumer(bc, 50);
        Consumer c2 = new Consumer(bc, 30);

        Thread t1 = new Thread(p1);
        t1.setName("p1");
        Thread t2 = new Thread(p2);
        t2.setName("p2");
        Thread t3 = new Thread(p3);
        t3.setName("p3");
        Thread t4 = new Thread(p4);
        t4.setName("p4");
        Thread t5 = new Thread(c1);
        t5.setName("c1");
        Thread t6 = new Thread(c2);
        t6.setName("c2");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }
}
