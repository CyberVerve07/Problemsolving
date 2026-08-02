package oops.interfaces;

/**
 * PhonePe â€” Implements the Payment interface for PhonePe UPI payments.
 *
 * INTERVIEW: Why is PhonePe not 'public'?
 * â†’ The class has DEFAULT (package-private) access â€” accessible only within oops.InterPhases package.
 * â†’ In production, it should be 'public' if other packages need to use it.
 * â†’ Only ONE public class is allowed per .java file, and it must match the filename.
 *
 * JAVA TYPE: class implementing interface (default access)
 *
 * @author Aditya
 * @version 2.0
 * @see Payment
 */
public class PhonePe implements Payment {

    /**
     * Processes payment using PhonePe.
     */
    @Override
    public void pay() {
        System.out.println("Paid using PhonePe.");
    }
}
