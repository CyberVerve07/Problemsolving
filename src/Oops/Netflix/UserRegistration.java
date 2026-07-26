package oops.Netflix;

/**
 * UserRegistration — Handles user registration and login for Netflix.
 *
 * INTERVIEW DEFINITION — Composition (HAS-A Relationship):
 * -----------------------------------------------------------
 * Q: What is Composition?
 * A: Composition is when a class CONTAINS an object of another class as a field.
 *    It represents a HAS-A relationship (UserRegistration HAS-A Subscription).
 *    Unlike Inheritance (IS-A), Composition allows more FLEXIBILITY — the contained
 *    object can be changed at runtime (e.g., upgrade subscription from Basic to Premium).
 *
 * Q: Composition vs Inheritance?
 * A: | Feature       | Composition (HAS-A)          | Inheritance (IS-A)        |
 *    |---------------|------------------------------|---------------------------|
 *    | Relationship  | "User HAS-A Subscription"    | "Dog IS-A Animal"         |
 *    | Flexibility   | High — can change at runtime | Low — fixed at compile    |
 *    | Coupling      | LOOSE coupling               | TIGHT coupling            |
 *    | Best practice | Prefer composition           | Use when IS-A is natural  |
 *
 * Q: Why is Composition preferred over Inheritance?
 * A: "Favor Composition over Inheritance" — Gang of Four Design Principle.
 *    - Composition is more FLEXIBLE (can swap objects at runtime).
 *    - Avoids deep inheritance hierarchies.
 *    - Promotes LOOSE COUPLING between classes.
 *
 * BUG FIX: Fields `userid`, `userName`, `subscriptionType` were public — now private with getters.
 *
 * JAVA TYPE: class (uses Composition)
 * OOP PILLAR: Encapsulation + Composition
 *
 * @author Aditya
 * @version 2.0
 */
public class UserRegistration {

    /** BUG FIX: Changed from 'public' to 'private' */
    private int userId;
    private String userName;
    private String email;
    private String password;
    private String subscriptionType;

    /**
     * COMPOSITION: UserRegistration HAS-A Subscription.
     * This field holds the user's current subscription plan object.
     * It can be changed at runtime (e.g., upgrade from Basic to Premium).
     */
    private Subscription currentSubscription;

    /**
     * Constructor — registers a new user.
     *
     * @param userId           int — unique user ID
     * @param userName         String — display name
     * @param email            String — email address (validated)
     * @param password         String — password (min 6 characters)
     * @param subscriptionType String — preferred subscription type
     */
    public UserRegistration(int userId, String userName, String email, String password, String subscriptionType) {
        this.userId = userId;
        this.userName = userName;
        setEmail(email);       // Uses setter for validation
        setPassword(password); // Uses setter for validation
        this.subscriptionType = subscriptionType;
    }

    // ======================== GETTERS & SETTERS ========================

    /** @return int — the user ID */
    public int getUserId() {
        return userId;
    }

    /** @return String — the user name */
    public String getUserName() {
        return userName;
    }

    /** @return String — the subscription type */
    public String getSubscriptionType() {
        return subscriptionType;
    }

    /** @param subscriptionType String — the subscription type to set */
    public void setSubscriptionType(String subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    /** @return Subscription — the current subscription object */
    public Subscription getCurrentSubscription() {
        return currentSubscription;
    }

    /** @param currentSubscription Subscription — the subscription to set */
    public void setCurrentSubscription(Subscription currentSubscription) {
        this.currentSubscription = currentSubscription;
    }

    /**
     * @return String — the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter with email VALIDATION — must contain '@' and '.'.
     *
     * @param email String — the email to set
     */
    public void setEmail(String email) {
        if (email != null && email.contains("@") && email.contains(".")) {
            this.email = email;
        } else {
            System.out.println("Invalid email format! Email must contain '@' and a domain.");
        }
    }

    /**
     * @return String — the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter with password VALIDATION — minimum 6 characters.
     *
     * @param password String — the password to set
     */
    public void setPassword(String password) {
        if (password != null && password.length() >= 6) {
            this.password = password;
        } else {
            System.out.println("Invalid password! Password must be at least 6 characters long.");
        }
    }

    /**
     * Login verification — checks email and password.
     *
     * INTERVIEW: Why equalsIgnoreCase() for email?
     * → Email addresses are CASE-INSENSITIVE (user@GMAIL.com == user@gmail.com).
     * → equalsIgnoreCase() compares strings ignoring case differences.
     * → But password comparison uses equals() (case-SENSITIVE — passwords are case-sensitive).
     *
     * @param email    String — email to verify
     * @param password String — password to verify
     * @return boolean — true if login successful, false otherwise
     */
    public boolean login(String email, String password) {
        if (this.email != null && this.email.equalsIgnoreCase(email)
                && this.password != null && this.password.equals(password)) {
            System.out.println("Login Successful! Welcome back, " + userName + ".");
            return true;
        } else {
            System.out.println("Login Failed! Incorrect Email or Password.");
            return false;
        }
    }

    /**
     * Displays user details including active subscription.
     */
    public void displayUserDetails() {
        System.out.println("User Details: ---------------------------------");
        System.out.println("User ID: " + userId);
        System.out.println("Name: " + userName);
        System.out.println("Email: " + email);
        System.out.println("Preferred Subscription: " + subscriptionType);
        if (currentSubscription != null) {
            System.out.println("Active Subscription Plan: " + currentSubscription.getPlanName());
        } else {
            System.out.println("Active Subscription Plan: None");
        }
    }
}
