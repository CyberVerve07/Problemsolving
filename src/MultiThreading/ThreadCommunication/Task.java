package MultiThreading.ThreadCommunication;

public class Task
{
    int data;
    boolean isDataAvailable=false;

    // produce
    public synchronized void produce(int _data) throws InterruptedException
    {
        while (isDataAvailable)
        {
            System.out.println("["+Thread.currentThread().getName() +"] is waiting...");
            wait();
        }
        // produced the data
        this.data=_data;
        System.out.println(" produced the data : "+data);
        isDataAvailable=true;
        System.out.println(" Producer notifying the consumer");
        notify(); // notify the consumer so that consumer can consume it.
    }


    // consume

    public synchronized void consume() throws InterruptedException
    {
        while (!isDataAvailable)
        {
            System.out.println("["+Thread.currentThread().getName() +"] is waiting...");
            wait();
        }
        System.out.println("Consuming the data : "+data);
        isDataAvailable=false;
        System.out.println(" Consumer notifying the Producer");
        notify(); // notify the producer so that producer can generate/produce more data
    }


}

//Thread inter Communication
//Jvm architecture
//Core java 30 concepts revise
//Solid design principles Revise
// Method hiding
//Spotify problem
//Kafka master slave and all set like that architecture