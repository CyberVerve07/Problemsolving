package dailycode.july20;

import dailycode.july17.Code1.AmazonOrderManagementSystem.Order;

class  Gpay   extends  Payment{
    public Gpay(double amount) {
        super(amount);
    }

    @Override
    void payment( ) {
        System.out.println("Payment  is  done by using Google Pay .....");
        System.out.println("Ammount is Credit from your Account is"+getAmount());
        System.out.println();
    }
}
