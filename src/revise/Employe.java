package revise;

// A simple POJO class without any embedded sorting logic
class Employe {
    private String name;
    private double salary;

    public Employe(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() { return name; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return name + " ($" + salary + ")";
    }
}
