package MultiThreading.ThreadCommunication;

public class Consumer extends Thread {

    Task task;

    public Consumer(Task task) {
        super();
        this.task = task;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {

                task.consume();
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}