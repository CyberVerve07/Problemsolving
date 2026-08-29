package Collection.Practice;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class UnmodifiableList {
    public static void main(String[] args) {

        //Create a normal set of electronic items:

            Set<String> electronicSet=new HashSet<>();

              electronicSet.add("I phone15");
              electronicSet.add("Washing machine");
              electronicSet.add("Fridge");


                  //Make the Set unmodifiable:

        Set<String>unmodifiableElectronic= Collections.unmodifiableSet(electronicSet);

         //print the elements :
        System.out.println("unmodifiable elements are"+unmodifiableElectronic );

        //Try to umodify the unmodifiable set(will throw exception):

        unmodifiableElectronic.add("Smart watch:");


    }


}
