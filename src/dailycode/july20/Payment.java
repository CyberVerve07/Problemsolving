package dailycode.july20;

abstract  class Payment{
     //Abstract class means how it will implement
    //what need to be done abstract class
     private double amount;

    public Payment(double amount) {                        //constructor for initialized the values of an object
        this.amount = amount;                              //
    }

    abstract   void   payment();

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}//Abstract class method have



//final vs abstract class