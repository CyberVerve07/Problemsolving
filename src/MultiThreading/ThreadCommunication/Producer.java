
package MultiThreading.ThreadCommunication;

import MultiThreading.ThreadCommunication.Task;

public class Producer extends Thread {

    Task task;

    public Producer(Task task) {
        super();
        this.task = task;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(2000);
                task.produce(i);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }
    }

}