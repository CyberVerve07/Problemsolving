package Collection.Collections;

import java.util.Comparator;

public class CustomerByIdComparator implements Comparator<Customer> {

    @Override
    public int compare(Customer o1, Customer o2) {
        int res=Integer.compare(o1.customerId, o2.customerId);
        return res;
    }
}
 // In java comparable means  natural and default sorting order:
// A separate object/class provides a sorting rule for another class.


 //Comparable class ka Andar  natural / default sorting perform kart hai :
 //And Comparator separate obj /class provides a sorting rules for another class:
