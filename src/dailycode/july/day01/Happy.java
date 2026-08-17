package dailycode.july.day01;
class Employee {

    void work() {
        System.out.println("Employee is working");
    }
}

class Developer extends Employee {

    @Override
    void work() {
        System.out.println("Developer is writing code");
    }
}

public class Happy {
    public static void main(String[] args) {

        Employee emp = new Employee();
        emp.work();

    }
}


