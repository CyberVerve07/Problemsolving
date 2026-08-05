package august.augest4.Practice;

import java.util.function.Predicate;

public class Swd implements  Employee{
    @Override
    public String getName() {
        return "Software Devolper";

    }
    public static void main(String[] args) {
         Swd swd=new Swd();
        System.out.println(swd.getName());

        Predicate<Integer> salaryGreaterThanOneLakh=x->x>100000;
        System.out.println(salaryGreaterThanOneLakh.test(70000));







    }
}
