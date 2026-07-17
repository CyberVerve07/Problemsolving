package dailycode.july17.Code1.Abstraction;

abstract class Payment {

       private  double amount;

    public double getAmount( double amount) {
        this.amount=amount;
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Payment() {
        System.out.println("Payment is Processing :");
    }

    abstract void pay(double amount);



    }

