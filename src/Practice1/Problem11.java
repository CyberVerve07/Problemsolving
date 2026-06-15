package Practice1;

import java.util.Scanner;

public class Problem11 {

    static  void placeOrder(){
        System.out.println("Order the food");
        Scanner input=new Scanner(System.in);
        String food= input.next();
        System.out.println("Your iteam is shortly delivered");

    }
    //sub task
    static  void billGen(){
        System.out.println("Your bill is Generated");

    }
    static void delivery(){
        System.out.println("Item is delivered");
    }
    static  void payment(){
        System.out.println("Please make the payment ");
    }

    public static void main(String[] args) {
        placeOrder();
        billGen();
        delivery();
        payment();
    }

}
