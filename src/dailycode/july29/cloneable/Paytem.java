package dailycode.july29.cloneable;

public class Paytem  implements Cloneable{   //If we dont  implement the cloneable it throws the exception :
     String  upiId;
     String acountNo;
     double balance;

    @Override   //Override method
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Paytem(String upiId, String acountNo, double balance) {
        this.upiId = upiId;
        this.acountNo = acountNo;
        this.balance = balance;

          //We use the Cloneable for copy the object and use it wher it requires

            //for e.g. user buy a product from Flipkart next time when he buys the same product some things
        // his id , name location price or etc. thing are simpler so we don't need to create another obj ...

        //It is a marker interface that is used to  tag the permissions tio the jvm to copy the obj ::

         //Shalow copy and deep copy in java mens
         //Shallow copy means copying the object but not the objects that are referenced by it.
         //Deep copy means copying the object and the objects that are referenced by it.
        //clone() is a obj. in java method of a obj

    }

}
