package dailycode.july27.QuickBite;

public class Authentication {

    private String customerId;
    private String name;
    private String phoneNumber;
    private String email;
    private String address;
    private String password;
    private double walletBalance;

    public Authentication(String customerId, String name, String phoneNumber, String email, String address, String password, double walletBalance) {
        this.customerId = customerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.password = password;
        this.walletBalance = walletBalance;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            System.out.println("Invalid Mobile number!");
        } else {
            this.phoneNumber = phoneNumber;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(double walletBalance) {
        if (walletBalance >= 0) {
            this.walletBalance = walletBalance;
        } else {
            System.out.println("Wallet balance cannot be negative!");
        }
    }

    public void login(String token) {
        if (token != null && token.equals(getPassword())) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Password does not match.");
            System.out.println("Please recheck your password.");
        }
    }

    public void logout() {
        System.out.println("Logged out successfully. Thanks for using QuickBite!");
    }

    public void viewProfile() {
        System.out.println("User ID: " + getCustomerId());
        System.out.println("User Name: " + getName());
        System.out.println("Phone Number: " + getPhoneNumber());
        System.out.println("Email Address: " + getEmail());
        System.out.println("Address: " + getAddress());
        System.out.println("Wallet Balance: " + getWalletBalance());
    }

    public void updateProfile(String name, String phoneNumber, String email, String address) {
        setName(name);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setAddress(address);
        System.out.println("Profile updated successfully!");
    }
}