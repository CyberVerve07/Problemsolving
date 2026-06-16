package Practice1;

public class Problem16 {
    //Main Task:
    //
    //User should be able to book a movie ticket
    //
    //Sub Tasks:
    //
    //Generate ticket
    //Send booking confirmation message
    //Make payment

      static  void movieTicket(){
          System.out.println("Book your ticket");
      }

          //Generate ticket
    static void genTicket(){
        System.out.println("Ticket Generated");
    }
     //Send booling config
    static void sendBooking(){
        System.out.println("Message will we send");
    }
    static void payment(){
        System.out.println("Payment Done");
    }

    public static void main(String[] args) {
        movieTicket();
        genTicket();sendBooking();
        payment();
    }
}
