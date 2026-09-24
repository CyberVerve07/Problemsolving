package MultiThreading;

import com.sun.jdi.event.ThreadDeathEvent;

public class Demo15 {

    public static void main(String[] args) {

        MovieTicket movieTicket = new MovieTicket();

        Runnable task = ()-> movieTicket.ticketBooking();


        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);
        Thread t4 = new Thread(task);

        Thread t5 = new Thread(task);
        Thread t6=new Thread(task);

        // Set thread names before starting
        t1.setName("User1");
        t2.setName("User2");
        t3.setName("User3");
        t4.setName("User4");

        // Start threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }
}