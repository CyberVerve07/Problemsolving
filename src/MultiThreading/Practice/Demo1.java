package MultiThreading.Practice;

import august.augest22.Demo;

public class Demo1  extends Thread{
    //So in java we have two ways to create a thread
    //1. By extending the Thread class
    //2. By implementing the Runnable interface


    @Override
    public void run() {
        System.out.println("Thread is running");
    }



}
class main{
    public static void main(String[] args) {
        Demo d1=new Demo();
        d1.start();
        //So start method is used to start the thread and it will call the run method internally
        //And it is responsabile for creating a new thread and calling the run method
    }
}
