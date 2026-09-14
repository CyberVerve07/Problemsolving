package StreamPractice;

public class Employee1 {
    //Find the first employee whose sallary is greate than 50 k

     private String name;
     private  String department;
     double salary;

       //Create an Constructor


    public Employee1(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }


    //Generate an  Getter methods


    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
    @Override
    public String toString() {
        return name + " | " + department + " | " + salary;
    }


}
