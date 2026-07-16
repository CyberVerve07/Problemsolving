package dailycode.july16.PaymentGateway;

public class Payment {
    public Payment(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;

    }

    public void setAmount(double amount) {
          if (amount>=100){
              System.out.println("Payment fail::  ");
          }
        this.amount = amount;
    }

    private  double amount;


  void  pay(){
      System.out.println(" Payment in  processing:: ");

  }

}
