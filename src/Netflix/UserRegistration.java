package Netflix;

public class UserRegistration {
    public int userid;
    public String userName;
    private String email;
    private String password;
    public String subscriptionType;
    public Subscription currentSubscription;

    // Create a constructor
    public UserRegistration(int userid, String userName, String email, String password, String subscriptionType) {
        this.userid = userid;
        this.userName = userName;
        setEmail(email);
        setPassword(password);
        this.subscriptionType = subscriptionType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null && email.contains("@") && email.contains(".")) {
            this.email = email;
        } else {
            System.out.println("Invalid email format! Email must contain '@' and a domain.");
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password != null && password.length() >= 6) {
            this.password = password;
        } else {
            System.out.println("Invalid password! Password must be at least 6 characters long.");
        }
    }

    // Login verification method
    public boolean login(String email, String password) {
        if (this.email != null && this.email.equalsIgnoreCase(email) && this.password != null && this.password.equals(password)) {
            System.out.println("Login Successful! Welcome back, " + userName + ".");
            return true;
        } else {
            System.out.println("Login Failed! Incorrect Email or Password.");
            return false;
        }
    }

    public void displayUserDetails() {
        System.out.println("User Details: ---------------------------------");
        System.out.println("User ID: " + userid);
        System.out.println("Name: " + userName);
        System.out.println("Email: " + email);
        System.out.println("Preferred Subscription: " + subscriptionType);
        if (currentSubscription != null) {
            System.out.println("Active Subscription Plan: " + currentSubscription.planName);
        } else {
            System.out.println("Active Subscription Plan: None");
        }
    }
}
