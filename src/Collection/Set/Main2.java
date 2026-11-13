package Collection.Set;

import Collection.Set.TreeSet.UserDemo;

import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public  static void main(String[] args) {

        UserDemo e1 = new UserDemo("Aditya", 1, 10000);
        UserDemo e2 = new UserDemo("Aman", 2, 20000);
        UserDemo e3 = new UserDemo("Rahul", 3, 30000);
        UserDemo e4 = new UserDemo("Ankit", 4, 40000);
        UserDemo e5 = new UserDemo("Rohit", 5, 50000);

        List<UserDemo> employee = new ArrayList<>();

        employee.add(e1);
        employee.add(e2);
        employee.add(e3);
        employee.add(e4);
        employee.add(e5);

        print(employee);

    }
        //Create a method for print
        public  static void print (List < UserDemo > employee) {
            for (UserDemo userDemo : employee) {
                System.out.println("Name: " + userDemo.getName() + "\n" + "Id: " + userDemo.getId() + "\n" + "Salary: " + userDemo.getSalary());
            }
        }

    }
