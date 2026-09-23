package MultiThreading;

class TicketSystem {

    int tickets = 1;

    void bookTicket() {


        synchronized (this) {

            if (tickets > 0) {

                System.out.println("Ticket available for::" + Thread.currentThread().getName());
                tickets--;   //Decrement the ticket by 1
                System.out.println("Ticket booked by ::" + Thread.currentThread().getName());
            } else {
                System.out.println("Ticket not available for " + Thread.currentThread().getName());
            }
        }
    }
}

public class Demo14 {

    public static void main(String[] args) {

        TicketSystem ticketSystem = new TicketSystem();

        Thread t1 = new Thread(() -> ticketSystem.bookTicket(), "User-1");

        Thread t2 = new Thread(() -> ticketSystem.bookTicket(), "User-2");
        Thread t3=new Thread(()-> ticketSystem.bookTicket(),"User3");

        t1.start();
        t2.start();
        t3.start();
    }
}