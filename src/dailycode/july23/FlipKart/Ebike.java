package dailycode.july23.FlipKart;

import java.util.Scanner;

public class Ebike extends BaseDeliveryPartner{
    public Ebike(int partnerId, String partnerName, int vehicleNumber, int rating, String location) {
        super(partnerId, partnerName, vehicleNumber, rating, location);
    }

    @Override
    public void acceptOrder() {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== ACCEPT ORDER =====");

        // If Partner is Available
        System.out.print("Is Partner Available (true/false): ");
        boolean partnerAvailable = sc.nextBoolean();

        if (!partnerAvailable) {
            System.out.println(" Delivery Partner is not available.");
            return;

        }

        System.out.print("Is Restaurant Open (true/false): ");
        boolean restaurantOpen = sc.nextBoolean();

        // If Restaurant is Open
        if (!restaurantOpen) {
            System.out.println(" Restaurant is closed.");
            return;
        }

        System.out.print("Is Vehicle Working (true/false): ");
        boolean vehicleWorking = sc.nextBoolean();

        // If Vehicle is Working
        if (!vehicleWorking) {
            System.out.println(" Vehicle is not working.");
            return;
        }

        System.out.print("Enter Distance to Restaurant (KM): ");
        double distanceToRestaurant = sc.nextDouble();

        double maxDistance = 8.0;

        // If Near Distance
        if (distanceToRestaurant > maxDistance) {
            System.out.println(" Restaurant is too far.");
            return;
        }

        System.out.print("Is Order Already Assigned (true/false): ");
        boolean orderAssigned = sc.nextBoolean();

        // If Partner is busy
        if (orderAssigned) {
            System.out.println(" Order is already assigned to another partner.");
            return;
        }

        String orderStatus = "ACCEPTED";
        partnerAvailable = false;

        System.out.println("\n Order Accepted Successfully!");
        System.out.println("Order Status : " + orderStatus);
        System.out.println("Partner Availability : " + partnerAvailable);
    }

    // In this method we write the actual logic for pickup
    @Override
    public void pickupOrder() {
        // Food Picked Successfully
        // Status = PICKED_UP
        Scanner sc = new Scanner(System.in);

        System.out.println("===== PICKUP ORDER =====");

        System.out.print("IS Order Accepted:  ");
        boolean accepted = sc.nextBoolean();

        if (!accepted) {
            System.out.println("Order is Not Accepted Please Try again:: ");
            return;
        } else {
            System.out.println("Order is Pickup delivery Shortly:: ");
        }

        // Is Partner Available
        System.out.print("Is Partner Available (true/false): ");
        boolean partnerAvailable = sc.nextBoolean();

        if (!partnerAvailable) {
            System.out.println("Partner is not available, Please try again :::");
            return;
        } else {
            System.out.println("Delivery Rider on the Way ::");
            System.out.println("Your item is Delivered Shortly: ");
        }
    }

    @Override
    public void deliverOrder() {
        // Check only these things:
        // Is food picked?
        // Has partner reached customer?
        // If both are true → deliver

        Scanner sc = new Scanner(System.in);

        System.out.println("===== DELIVER ORDER =====");

        // BUG FIX: prompt was "IS Order Accepted" but should check if order is picked
        System.out.print("Is Order Picked:  ");
        boolean picked = sc.nextBoolean();

        if (!picked) {
            System.out.println("Order is Not Picked  Please Try again:: ");
            return;
        }

        System.out.print("Has Partner Reached Customer (true/false): ");
        boolean reachedCustomer = sc.nextBoolean();

        if (!reachedCustomer) {
            System.out.println("Partner has not reached the customer yet.");
            return;
        }

        System.out.println("Item is Successfully Delivered!");
        System.out.println("Order Status: DELIVERED");
    }

}
