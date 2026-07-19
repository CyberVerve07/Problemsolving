package dailycode.july19;

// Passenger class - Encapsulation
// Passenger ki details private rakhi hai

public class Passenger {

    private int passengerId;
    private String name;
    private int age;
    private String passportNumber;

    // Constructor
    public Passenger(int passengerId, String name, int age, String passportNumber) {
        this.passengerId = passengerId;
        this.name = name;
        this.age = age;
        this.passportNumber = passportNumber;
    }

    // Passenger ki details print karna
    void displayDetails() {
        System.out.println("=====================");
        System.out.println("Passenger Details :");
        System.out.println("ID       : " + passengerId);
        System.out.println("Name     : " + name);
        System.out.println("Age      : " + age);
        System.out.println("Passport : " + passportNumber);
        System.out.println("=====================");
    }

    // Getters
    public int getPassengerId()     { return passengerId; }
    public String getName()         { return name; }
    public int getAge()             { return age; }
    public String getPassportNumber() { return passportNumber; }
}
