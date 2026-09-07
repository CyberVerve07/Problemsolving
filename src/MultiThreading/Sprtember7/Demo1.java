package MultiThreading.Sprtember7;


import static august.augest4.Practice.Demo.print;

public class Demo1 extends Thread {
    @Override
    public void run() {
        for (int i=0;i<5;i++){
            System.out.println("Inside the main thread:"+i);
        }
    }
}
