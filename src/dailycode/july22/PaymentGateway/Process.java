package dailycode.july22.PaymentGateway;

public class Process {

    // Bug Fix: method was package-private, now public so Main can call it
    public void done(PaymentGateway a) {
        a.pay();        // triggers payment + balance update via processPayment inside pay()
    }

    // Convenience: deposit money then pay
    public void depositAndPay(PaymentGateway a) {
        a.deposit();
        a.pay();
    }

    // Convenience: pay then withdraw remaining
    public void payAndWithdraw(PaymentGateway a) {
        a.pay();
        a.withdraw();
    }

}

