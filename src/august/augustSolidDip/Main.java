package august.augustSolidDip;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   SOLID Principles Demo: Dependency Inversion (DIP)");
        System.out.println("==================================================");

        // 1. Create concrete low-level notification channel instances
        NotificationChannel emailChannel = new EmailNotificationChannel();
        NotificationChannel smsChannel = new SmsNotificationChannel();
        NotificationChannel whatsappChannel = new WhatsAppNotificationChannel();

        // 2. High-level NotificationService depends ONLY on abstraction interface
        // We inject the dependency (Email) at runtime
        NotificationService emailService = new NotificationService(emailChannel);
        emailService.notifyUser("aditya@example.com", "Your Account balance has been updated to ₹15,000.");

        // Switch channel to SMS effortlessly without altering NotificationService
        NotificationService smsService = new NotificationService(smsChannel);
        smsService.notifyUser("+91-9876543210", "OTP for payment transaction is 482910.");

        // Switch channel to WhatsApp effortlessly
        NotificationService whatsappService = new NotificationService(whatsappChannel);
        whatsappService.notifyUser("+91-9876543210", "Your monthly statement for August is ready.");

        // 3. Multi-channel broadcast demonstration
        List<NotificationChannel> activeChannels = Arrays.asList(emailChannel, smsChannel, whatsappChannel);
        NotificationService broadcastService = new NotificationService(emailChannel);
        broadcastService.notifyUserAllChannels(activeChannels, "aditya@example.com", "CRITICAL SECURITY ALERT: New login detected.");

        System.out.println("\n[DIP Summary]: High-level NotificationService is loosely coupled.");
        System.out.println("It relies entirely on NotificationChannel abstraction rather than concrete implementations!");
    }
}
