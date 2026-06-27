//Irctc ticker booking
package Practice;
import java.util.Scanner;
public class code15 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter User Type (Retail / Agent ): ");
        String userType = input.next();

        switch (userType.toLowerCase()) {

            case "retail":

                System.out.print("Enter Number of Tickets: ");
                int retailTickets = input.nextInt();

                if (retailTickets <= 0) {
                    System.out.println("Invalid Ticket Count");
                }
                else if (retailTickets <= 6) {
                    System.out.println("Booking Successful");
                }
                else {
                    System.out.println("Retail user can book only 6 tickets in a day.");
                }

                break;

            case "agent":

                System.out.print("Enter Number of Tickets: ");
                int agentTickets = input.nextInt();

                if (agentTickets <= 0) {
                    System.out.println("Invalid Ticket Count");
                }
                else {
                    System.out.println("Booking Successful");
                }

                break;

            default:

                System.out.println("User Type Not Supported");
        }

        input.close();
    }
}