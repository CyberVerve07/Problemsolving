package MultiThreading;



class  EmailSend extends Thread{

    @Override
    public void run() {
        System.out.println("Email is send Check Otp:::");

        //When thread in the Running state ->Thread is doing the work
        // Once waiting is over thread is moving into the Runnable state
        //Once the Cpu is allowed the thread is moved to the Running task;
        // Once the Run method is compiled by the thread,they move to Terminated State
    }
}

public class Demo7 {
    public static void main(String[] args) {
       // System.out.println(Thread.currentThread());


        EmailSend T1 = new EmailSend();

T1.start();



        //Once the thread is going into the terminated state it can not be  going to running state again

        //New->Runnable->Running-> Waited/Blocked->Runnable->Running-> Terminated:


    }
}
