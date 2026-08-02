package oops.interfaces;

/**
 * GooglePay â€” Implements the Payment interface for Google Pay payments.
 *
 * NOTE: Class name in file is 'GooglePay' (typo in filename) â€” ideally should be 'GooglePay'.
 * File rename is not done to avoid breaking project structure, but the output is fixed.
 *
 * TYPO FIX: Output message corrected from "googel pay" â†’ "Google Pay".
 *
 * JAVA TYPE: class implementing interface
 *
 * @author Aditya
 * @version 2.0
 * @see Payment
 */
public class GooglePay implements Payment {

    /**
     * Processes payment using Google Pay.
     */
    @Override
    public void pay() {
        System.out.println("Payment done by Google Pay.");
    }
}
