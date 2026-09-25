import java.util.*;

class Employee {
    int id;

    Employee(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Employee &&
                id == ((Employee) obj).id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}

public class Main {
    public static void main(String[] args) {

        Employee e = new Employee(10);

        Map<Employee, String> map = new HashMap<>();

        map.put(e, "Java");

        e.id = 20;

        System.out.println(map.get(e));
    }
}