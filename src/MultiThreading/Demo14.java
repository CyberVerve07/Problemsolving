package MultiThreading;

class TicketSystem {

    int tickets = 1;


  synchronized   void  bookTicket() {

        if (tickets > 0) {
            System.out.println("Ticket available");

            tickets--;

            System.out.println("Ticket booked");
        }
    }
}


 class Demo14{
     public static void main(String[] args) {

         TicketSystem ticketSystem=new TicketSystem();

           Thread t1=new Thread(()->ticketSystem.bookTicket());
         System.out.println("Ticket is booking by the User 1 "+Thread.currentThread().getName());

          Thread t2=new Thread(()->ticketSystem.bookTicket());
         System.out.println("Ticket is booking by the User 2:"+Thread.currentThread().getName());
         t1.start();
         t2.start();


     }

 }