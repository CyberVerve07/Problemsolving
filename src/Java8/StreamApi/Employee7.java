package Java8.StreamApi;

public class Employee7 {
    String name;
     double salary;
     String department;

     //Create  an Constructor of it


    public Employee7(String name, double salary, String department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    //Generata the getters  method of these functions


    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    //Implement the to string method


    @Override
    public String toString() {
        return "Employee7{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }
}
