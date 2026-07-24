package dailycode.july23.EcommercePaymentService;

public  abstract  class BasePayment {

     private   String paymentId;
   private  double  amount;
    private String  customerName;

    public BasePayment(String paymentId, double amount, String customerName) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.customerName = customerName;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    //Common Method:
     public void  printDetails(){
         System.out.println("User Details are: =======================");
         System.out.println("Customer  name is :: "+getCustomerName());
         System.out.println("Amount is "+getAmount());
         System.out.println("Customer Payment id is "+getPaymentId());
         System.out.println("=======================================");
         System.out.println();
     }



        //public  abstract void  pay();
        }


