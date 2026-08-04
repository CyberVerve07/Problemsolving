package dailycode.july.day27;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

interface IDiscount {
    int apply(int amount, int dis);
}

class Driver {
    public static void main(String[] args) {
        IDiscount iDiscount = (amt, dsc) -> {
            int dis = amt * dsc / 100;
            return dis;
        };
        int result = iDiscount.apply(1000, 5);
        System.out.println("Discount result: " + result);

        Predicate<String> predictable = (a) -> a.equals("Java");
        System.out.println("Predicate test: " + predictable.test("19"));

        Supplier<Integer> supplier2 = () -> 10000 + new Random().nextInt(90000);
        System.out.println("Your OTP is :: " + supplier2.get());

        Consumer<String> consumer = (emailTo) ->
                System.out.println("Email has been sent: " + emailTo);
        consumer.accept("adityamahajan7287@gmail.com");

        Function<Integer, Integer> function = (amt) -> amt * 100;
        System.out.println("Function result: " + function.apply(100));


    }
}

