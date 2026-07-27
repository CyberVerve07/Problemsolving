package dailycode.july27;

import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

interface IDiscount {
     int apply(int amount,int dis);
}

  class Driver{
     public static void main(String[] args) {
         IDiscount iDiscount = (amt, dsc) -> {

             int dis = amt * dsc / 100;
             return dis;


         };
         int result = iDiscount.apply(1000, 5);
         System.out.println(result);


           Predicate<String> predictabel=(a)->a.equals("Java"); //Test krta hai:
         System.out.println(predictabel.test("19"));

         Supplier<Integer> Supplier2 = () -> 10000 + new Random().nextInt();  //don't take any input only give  output :
         System.out.println("Your OTP is :: " + Supplier2.get());

          //Consumer interface of the functional interface is the one that accepts only one argument.
         // It is used for performing an action, such as printing or logging. There are also functional variants of the Consumer DoubleConsumer, IntConsumer and LongConsumer.
         //
         //Syntax:

         Consumer<String> consumer = (emailTo) ->
                 System.out.println("Email has been Send:" + emailTo); //Take input from user and return:
         consumer.accept("adityamahajan7287@gmail.com");


         Function<Integer, Integer> function = (amt) -> amt =  (amt * 100);  // Take input process and  return
         System.out.println(function.apply(100));


         // predectable -> Test krta hai  test condition
         //Supplier get krta ha Random::
         //Consumer accept
         //Functional apply krta ha

     }}
