package Collection.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DriveComparator {
    public static void main(String[] args) {

        List<Customer> customerList = new ArrayList<>();

        customerList.add(new Customer("Aditya", 120));
        customerList.add(new Customer("Raja", 980));
        customerList.add(new Customer("Darshan", 990));
        customerList.add(new Customer("Prachi", 987));
        customerList.add(new Customer("GoldBrother", 345));
        customerList.add(new Customer("Ashish", 700));

        // Sorting by ID first, then by Name if IDs are equal
        Comparator<Customer> idThenNameComparator = Comparator.comparingInt((Customer c) -> c.customerId).thenComparing(c -> c.name);

        Collections.sort(customerList, idThenNameComparator);

        for (int i = 0; i < customerList.size(); i++) {
            Customer cus = customerList.get(i);
            System.out.println("Customer ID is " + cus.customerId + " Customer name is :: " + cus.name);
        }    }
}