package Collection.Collections;

import java.util.Comparator;

public class CustomerByNameComparator implements Comparator<Customer> {

    @Override
    public int compare(Customer o1, Customer o2) {
        int res = o1.name.compareTo(o2.name);
        return res;
    }
}