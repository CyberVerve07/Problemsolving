package MultiThreading;

public class MovieTicket {

    int ticket = 1;

    synchronized void ticketBooking() {

        if (ticket > 0) {

            System.out.println("Ticket is available for: " + Thread.currentThread().getName()
            );

            ticket--;  // ticket booked

            System.out.println("Ticket is booked by: " + Thread.currentThread().getName());

            // Notification after successful bookingsendNotification();

        } else {

            System.out.println("Sorry, house is full. Ticket is not available for: " + Thread.currentThread().getName());
        }
    }

    void sendNotification() {

        System.out.println("Your Ticket is Confirmed: " + Thread.currentThread().getName());
    }
}