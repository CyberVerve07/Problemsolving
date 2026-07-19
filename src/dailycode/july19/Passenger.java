package dailycode.july19;

// =============================================
// Passenger Class - OOP: Encapsulation
// Stores private passenger details with getters/setters
// =============================================
public class Passenger {

    private int passengerId;
    private String name;
    private int age;
    private String passportNumber; // Required for international flights
    private String email;
    private String phone;

    // Constructor
    public Passenger(int passengerId, String name, int age, String passportNumber,
                     String email, String phone) {
        this.passengerId = passengerId;
        this.name = name;
        this.age = age;
        this.passportNumber = passportNumber;
        this.email = email;
        this.phone = phone;
    }

    // Getters
    public int getPassengerId() { return passengerId; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getPassportNumber() { return passportNumber; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }

    // Setters
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }

    // Passenger age category (used for fare discounts)
    public String getAgeCategory() {
        if (age < 12) return "CHILD";
        else if (age >= 60) return "SENIOR";
        else return "ADULT";
    }

    @Override
    public String toString() {
        return String.format("Passenger[ID=%d, Name=%s, Age=%d (%s), Email=%s, Phone=%s]",
                passengerId, name, age, getAgeCategory(), email, phone);
    }
}
