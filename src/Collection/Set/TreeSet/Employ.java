package Collection.Set.TreeSet;

class Employee implements Comparable<Employee> {

    int salary;

    Employee(int salary) {

        this.salary = salary;
    }

    @Override
    public int compareTo(Employee other) {
        return this.salary - other.salary;
    }



}