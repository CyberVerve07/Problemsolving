package Collection.Collections;

import java.util.HashSet;
import java.util.Set;

public class Demo8 {


    public static void main(String[] args) {


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
                return id % 2;
            }
        }

        Set<Employee> set = new HashSet<>();

        set.add(new Employee(10));
        set.add(new Employee(12));
        set.add(new Employee(11));
        set.add(new Employee(13));

        System.out.println(set.size());

    }
}
