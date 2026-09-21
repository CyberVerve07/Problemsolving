package MultiThreading;

class Task {
    public synchronized void printNumbers() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " - Printing: " + i);
        }
    }
}

class PrintThread extends Thread {
    private final Task task;

    // Fixed: Proper constructor with matching name and no return type
    public PrintThread(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        // Fixed: Called the actual method on the task object
        task.printNumbers();
    }
}

public class Demo12 {
    public static void main(String[] args) {
        Task sharedTask = new Task();

        PrintThread t1 = new PrintThread(sharedTask);
        PrintThread t2 = new PrintThread(sharedTask);

        t1.start();
        t2.start();
    }
}