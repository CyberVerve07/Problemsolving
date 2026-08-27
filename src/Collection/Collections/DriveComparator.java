package Collection.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DriveComparator {
    public static void main(String[] args) {

        List<Customer>customerList=new ArrayList<>();

         customerList.add(new Customer("Aditya",120));
         customerList.add(new Customer("Raja",980));
         customerList.add(new Customer("Darshan",990));
         customerList.add(new Customer("Prachi",987));
         customerList.add(new Customer("GoldBrother",345));
         customerList.add(new Customer("Ashish",700));

 //Performing  the sorting
        Collections.sort(customerList,new CustomerByIdComparator());

          for (int i=0;i< customerList.size();i++){
              Customer cus=customerList.get(i);
              System.out.println( "Customer name is "+cus.customerId+  " Customer name is ::" +cus.name);
          }
    }
}
//Use Comparable for default or natural sorting inside a class ,
//  use Comparator for custom or multiple sorting rules outside a class.

//Control and code belong to you :
//External sorting does not modify the source code :