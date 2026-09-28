package MultiThreading.ThreadCommunication;

public class Drive {
    public static void main(String[] args) {


        Task task=new Task();
Producer producer=new Producer(task);
Consumer consumer=new Consumer(task);

      producer.setName("Producer");
      consumer.setName("Consumer:");

      producer.start();
      consumer.start();

    }
}
