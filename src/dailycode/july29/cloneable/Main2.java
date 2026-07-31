package dailycode.july29.cloneable;

public class Main2 {
    public static void main(String[] args) throws CloneNotSupportedException {

        Paytem paytem=new Paytem("73983023@upi","1234567890",10000);
          //Modify the upi id
        paytem.upiId="293038303830@839upi";

        System.out.println(paytem.upiId);
        System.out.println(paytem.acountNo);
        System.out.println(paytem.balance);
           //Clonable Object ::
        Object payment2=paytem.clone();
        System.out.println("-----------------------------------");
        System.out.println(((Paytem)payment2).upiId);
        System.out.println(((Paytem)payment2).acountNo);
        System.out.println(((Paytem)payment2).balance);
        System.out.println("-----------------------------------");

        //Different addresses
        System.out.println(paytem);
        System.out.println(payment2);


          //Shallow copy and deep copy in java mens
          //Shallow copy means copying the object but not the objects that are referenced by it.
          //Deep copy means copying the object and the objects that are referenced by it.





    }
}
