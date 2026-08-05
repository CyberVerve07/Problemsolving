package august.augest5;

public class Demo10 {

    public static void main(String[] args) {
        try {
            movieTicket("Spiderman","3pm","3hours",-3);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


    }

    public  static void movieTicket( String movieName, String time ,String duration,  int seatNO) throws IllegalArgumentException  {

        System.out.println("Welcome to the Cinema ");

          if (seatNO<=0){
              throw new  IllegalArgumentException("Seat number can't be zero:");
          }

        System.out.println("Movie name is "+movieName);
        System.out.println("Timing is "+time);
        System.out.println("Duration is "+duration);
        System.out.println("Seat no is "+seatNO);


    }


}
