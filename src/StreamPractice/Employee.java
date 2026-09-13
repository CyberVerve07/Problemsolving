package StreamPractice;

public class Employee {
    //Given a list of employees, find all employees whose salary is greater than
    // 50,000 and return their names as a List<String>.

    String name;
    double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }


    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }


}
