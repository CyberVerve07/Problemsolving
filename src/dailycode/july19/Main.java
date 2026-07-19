package dailycode.july19;

// Main class - sabko ek saath use karte hain
// July 19 - Airplane Flight Booking System
// OOP Concepts: Abstraction, Encapsulation, Inheritance, Polymorphism

public class Main {

    static void companyInfo() {
        System.out.println("**************");
        System.out.println("Welcome to IndiAir");
        System.out.println("India's Trusted Flight Booking Platform");
        System.out.println("**************");
    }

    public static void main(String[] args) {

        companyInfo();

        // ---- Passengers create karo (Encapsulation) ----
        Passenger rahul  = new Passenger(1001, "Rahul Sharma", 28, "P1234567");
        Passenger chhoti = new Passenger(1002, "Chhoti Sharma", 8, "N/A");    // Child - domestic only
        Passenger suresh = new Passenger(1003, "Suresh Kumar", 65, "P9876543"); // Senior citizen
        Passenger ananya = new Passenger(1004, "Ananya Singh", 22, "P5432167");

        // ---- Flights create karo (Inheritance) ----
        // DomesticFlight aur InternationalFlight dono Flight ke subclass hain

        DomesticFlight flight1 = new DomesticFlight("AI-101", "Air India",
                "Delhi", "Mumbai", "06:00 AM", 4500.0, 60);

        DomesticFlight flight2 = new DomesticFlight("6E-202", "IndiGo",
                "Mumbai", "Bangalore", "09:00 AM", 3800.0, 80);

        InternationalFlight flight3 = new InternationalFlight("AI-501", "Air India",
                "Delhi", "Dubai", "07:00 AM", 18000.0, 40, "UAE");

        InternationalFlight flight4 = new InternationalFlight("EK-601", "Emirates",
                "Mumbai", "London", "10:00 PM", 45000.0, 30, "UK");

        // ---- BookingProcess use karo ----
        BookingProcess process = new BookingProcess();

        // ---- Notification create karo (Polymorphism via Interface) ----
        NotificationSender email = new EmailNotification();
        NotificationSender sms   = new SMSNotification();

        System.out.println("\n========== BOOKING 1: Rahul - Delhi to Dubai (International) ==========");
        // Polymorphism: flight3 InternationalFlight hai, to calculateFare() uska chalega
        process.book(rahul, flight3);
        Booking booking1 = new Booking(101, rahul, flight3, flight3.calculateFare(rahul));
        email.sendConfirmation(booking1);

        System.out.println("\n========== BOOKING 2: Chhoti (Child) - Delhi to Mumbai (Domestic) ==========");
        // Polymorphism: flight1 DomesticFlight hai, to calculateFare() uska chalega
        process.book(chhoti, flight1);
        Booking booking2 = new Booking(102, chhoti, flight1, flight1.calculateFare(chhoti));
        sms.sendConfirmation(booking2);

        System.out.println("\n========== BOOKING 3: Suresh (Senior) - Mumbai to Bangalore (Domestic) ==========");
        process.book(suresh, flight2);
        Booking booking3 = new Booking(103, suresh, flight2, flight2.calculateFare(suresh));
        email.sendConfirmation(booking3);

        System.out.println("\n========== BOOKING 4: Chhoti - International (Should FAIL - No Passport) ==========");
        // Chhoti ke paas passport nahi hai, international booking fail hogi
        process.book(chhoti, flight3);

        System.out.println("\n========== CANCELLATION: Rahul ki booking cancel karo ==========");
        process.cancel(booking1);
        email.sendCancellation(booking1);

        System.out.println("\n========== BOOKING 5: Ananya - Mumbai to London (International) ==========");
        process.book(ananya, flight4);
        Booking booking5 = new Booking(104, ananya, flight4, flight4.calculateFare(ananya));
        sms.sendConfirmation(booking5);
    }
}
