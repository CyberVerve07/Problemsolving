package Collection.Set.TreeSet;

import org.jetbrains.annotations.NotNull;

import java.lang.Comparable;

public class UserDemo implements Comparable<UserDemo> {
    private String name;
    private int id;
    private double salary;

    //create a Coonstructor of it

    public UserDemo(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    //Crete a getter

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }
    //Create a toString method


    @Override
    public String toString() {
        return "UserDemo{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(@NotNull UserDemo o) {
        return 0;
    }
}
