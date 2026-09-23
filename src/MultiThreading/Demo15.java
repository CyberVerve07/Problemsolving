package MultiThreading;

public class Demo15 {

 public static void main(String[] args) {

  MovieTicket movieTicket = new MovieTicket();

  Thread t1 = new Thread(() -> movieTicket.ticketBooking());

  Thread t2 = new Thread(() -> movieTicket.ticketBooking());

  Thread t3 = new Thread(() -> movieTicket.ticketBooking());

  Thread t4 = new Thread(() -> movieTicket.ticketBooking());

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
 }
}