package dailycode.july19;

import java.util.List;
import java.util.Scanner;

// =============================================
// Main Class - Interactive Console Application
// OOP Demo: Abstraction, Encapsulation,
//           Inheritance, Polymorphism
//
// IndiAir - Airplane Flight Booking System
// Daily Code: July 19
// =============================================
public class Main {

    static Scanner scanner = new Scanner(System.in);
    static BookingSystem system;

    public static void main(String[] args) {

        // OOP Polymorphism: Choose notification type
        // We inject EmailNotification - can be swapped with SMSNotification
        NotificationSender emailNotifier = new EmailNotification();
        NotificationSender smsNotifier   = new SMSNotification();

        // Use Email as primary, SMS as secondary (polymorphism demo)
        system = new BookingSystem(emailNotifier);

        printBanner();

        boolean running = true;
        while (running) {
            printMenu();
            System.out.print("  Enter your choice: ");
            int choice = getIntInput();

            switch (choice) {
                case 1: searchFlightsMenu(); break;
                case 2: viewAllFlights(); break;
                case 3: bookFlightMenu(); break;
                case 4: cancelBookingMenu(); break;
                case 5: viewMyBookings(); break;
                case 6: showPassengers(); break;
                case 7: demoSMSNotification(smsNotifier); break;
                case 0:
                    System.out.println("\n  ✈️  Thank you for using IndiAir Booking System! Bon Voyage! ✈️");
                    running = false;
                    break;
                default:
                    System.out.println("  ❌ Invalid choice! Please try again.");
            }
        }
        scanner.close();
    }

    // =============================================
    // MENU 1: Search Flights by Route
    // =============================================
    private static void searchFlightsMenu() {
        System.out.println("\n========== SEARCH FLIGHTS ==========");
        System.out.print("  Enter Source City      : ");
        String source = scanner.nextLine().trim();
        System.out.print("  Enter Destination City : ");
        String destination = scanner.nextLine().trim();

        List<Flight> results = system.searchFlights(source, destination);

        if (results.isEmpty()) {
            System.out.printf("  ❌ No available flights found from %s to %s.%n", source, destination);
        } else {
            System.out.printf("\n  ✅ Found %d flight(s) from %s to %s:%n",
                    results.size(), source, destination);
            for (Flight f : results) {
                f.displayFlightInfo();
            }
        }
    }

    // =============================================
    // MENU 2: View All Flights
    // =============================================
    private static void viewAllFlights() {
        System.out.println("\n========== ALL AVAILABLE FLIGHTS ==========");
        List<Flight> all = system.getAllFlights();
        if (all.isEmpty()) {
            System.out.println("  No flights registered.");
            return;
        }
        for (Flight f : all) {
            f.displayFlightInfo();
        }
    }

    // =============================================
    // MENU 3: Book a Flight
    // =============================================
    private static void bookFlightMenu() {
        System.out.println("\n========== BOOK A FLIGHT ==========");

        // Show available passengers
        showPassengers();

        System.out.print("\n  Enter Passenger ID : ");
        int pid = getIntInput();
        Passenger passenger = system.findPassengerById(pid);
        if (passenger == null) {
            System.out.println("  ❌ Passenger not found!");
            return;
        }
        System.out.printf("  ✅ Passenger: %s%n", passenger.getName());

        // Show all flights
        viewAllFlights();

        System.out.print("\n  Enter Flight Number (e.g. AI-101) : ");
        String flightNum = scanner.nextLine().trim();
        Flight flight = system.findFlightByNumber(flightNum);
        if (flight == null) {
            System.out.println("  ❌ Flight not found!");
            return;
        }

        System.out.printf("  ✅ Flight: %s (%s --> %s) [%s]%n",
                flight.getFlightNumber(), flight.getSource(),
                flight.getDestination(), flight.getFlightType());

        System.out.println("\n  Processing your booking...");
        Booking booking = system.bookFlight(flight, passenger);

        if (booking != null) {
            System.out.println("\n  🎉 BOOKING SUCCESSFUL!");
            booking.displayBooking();
        }
    }

    // =============================================
    // MENU 4: Cancel a Booking
    // =============================================
    private static void cancelBookingMenu() {
        System.out.println("\n========== CANCEL BOOKING ==========");

        // Show all bookings
        List<Booking> all = system.getAllBookings();
        if (all.isEmpty()) {
            System.out.println("  No bookings to cancel.");
            return;
        }

        System.out.println("  Current Bookings:");
        for (Booking b : all) {
            System.out.printf("    BKG-%d | %s | %s --> %s | %s%n",
                    b.getBookingId(),
                    b.getPassenger().getName(),
                    b.getFlight().getSource(),
                    b.getFlight().getDestination(),
                    b.getStatus());
        }

        System.out.print("\n  Enter Booking ID to cancel (e.g. 1001) : ");
        int bid = getIntInput();
        system.cancelBooking(bid);
    }

    // =============================================
    // MENU 5: View My Bookings
    // =============================================
    private static void viewMyBookings() {
        System.out.println("\n========== VIEW MY BOOKINGS ==========");
        showPassengers();
        System.out.print("\n  Enter Passenger ID : ");
        int pid = getIntInput();
        system.viewPassengerBookings(pid);
    }

    // =============================================
    // MENU 6: Show All Passengers
    // =============================================
    private static void showPassengers() {
        System.out.println("\n  ---- Registered Passengers ----");
        for (Passenger p : system.getAllPassengers()) {
            System.out.printf("    ID: %d | %-18s | Age: %d (%s) | Passport: %s%n",
                    p.getPassengerId(), p.getName(), p.getAge(),
                    p.getAgeCategory(), p.getPassportNumber());
        }
        System.out.println("  --------------------------------");
    }

    // =============================================
    // MENU 7: Demo SMS Notification (Polymorphism)
    // =============================================
    private static void demoSMSNotification(NotificationSender smsNotifier) {
        System.out.println("\n========== SMS NOTIFICATION DEMO ==========");
        List<Booking> all = system.getAllBookings();
        if (all.isEmpty()) {
            System.out.println("  No bookings available. Please make a booking first.");
            return;
        }
        // Show SMS notification for the first CONFIRMED booking
        for (Booking b : all) {
            if (b.getStatus() == BookingStatus.CONFIRMED) {
                System.out.println("  Demonstrating SMS notification for: BKG-" + b.getBookingId());
                smsNotifier.sendBookingConfirmation(b);
                return;
            }
        }
        System.out.println("  No confirmed bookings found.");
    }

    // =============================================
    // Helper: Print the welcome banner
    // =============================================
    private static void printBanner() {
        System.out.println();
        System.out.println("  ╔══════════════════════════════════════════════╗");
        System.out.println("  ║       ✈️   IndiAir Flight Booking System  ✈️  ║");
        System.out.println("  ║    Daily Code | July 19 | OOP in Java        ║");
        System.out.println("  ║    Concepts: Abstraction | Encapsulation      ║");
        System.out.println("  ║              Inheritance | Polymorphism       ║");
        System.out.println("  ╚══════════════════════════════════════════════╝");
        System.out.println();
    }

    // =============================================
    // Helper: Print main menu
    // =============================================
    private static void printMenu() {
        System.out.println("\n  ==========================================");
        System.out.println("              MAIN MENU                   ");
        System.out.println("  ==========================================");
        System.out.println("  1. 🔍 Search Flights by Route");
        System.out.println("  2. 📋 View All Flights");
        System.out.println("  3. 🎫 Book a Flight");
        System.out.println("  4. ❌ Cancel a Booking");
        System.out.println("  5. 📄 View My Bookings");
        System.out.println("  6. 👤 View All Passengers");
        System.out.println("  7. 📱 Demo: SMS Notification (Polymorphism)");
        System.out.println("  0. 🚪 Exit");
        System.out.println("  ==========================================");
    }

    // =============================================
    // Helper: Safe integer input
    // =============================================
    private static int getIntInput() {
        try {
            String line = scanner.nextLine().trim();
            return Integer.parseInt(line);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
