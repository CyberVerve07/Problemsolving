package Collections.list;

import java.util.ArrayList;
import java.util.List;

public class Demo8 {
    public static void main(String[] args) {
        // Pluralized variable name. Using List interface for the reference type.
        List<String> employeeNames = new ArrayList<>(10);

        employeeNames.add("Radhe");
        employeeNames.add("Shyam");
        employeeNames.add("Ram");
        employeeNames.add("Kalu");
        employeeNames.add("Aditya");
        employeeNames.add("Radhe");
        employeeNames.add("Prachi");
        employeeNames.add("Kitu");
        employeeNames.add("Ashish");
        employeeNames.add("Ashish");
        // Use enhanced for-loop for clean iteration
        for (String name : employeeNames) {
            if (name.startsWith("P")) {
                System.out.println(name);
            }
            // The else block is removed. If you wanted to print the non-'R' names,
            // you would write an else block with: System.out.println(name);
        }

    }


}
