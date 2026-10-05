package Collection.Collections;

import java.util.HashMap;
import java.util.Map;

class Employee {
    int id;
    String name;

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
class  main {
    public static void main(String[] args) {

    Map<Employee, String> map = new HashMap<>();

    Employee e1 = new Employee(101, "Amit");

    map.put(e1,"Developer");

    Employee e2 = new Employee(101, "Amit");

System.out.println(map.get(e2));

 //When we are not override the equal and hashcode so it will return the null
        //HashMap first uses e2.hashCode() to locate the bucket. Since it can differ from e1's hash code,
        // it may never even reach the bucket containing e1.

}}