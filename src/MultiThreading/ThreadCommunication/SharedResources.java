package MultiThreading.ThreadCommunication;

class SharedQueue {

    private final Queue<Integer> queue =
            new LinkedList<>();

    private final int capacity = 5;

    public synchronized void produce(int value)
            throws InterruptedException {

        while (queue.size() == capacity) {
            wait();
        }

        queue.add(value);

        System.out.println("Produced: " + value);

        notifyAll();
    }

    public synchronized int consume()
            throws InterruptedException {

        while (queue.isEmpty()) {
            wait();
        }

        int value = queue.poll();

        System.out.println("Consumed: " + value);

        notifyAll();

        return value;
    }
}