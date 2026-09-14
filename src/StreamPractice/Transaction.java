package StreamPractice;

public class Transaction {
    String iteam;
    double price;

    public Transaction(String iteam, double price) {
        this.iteam = iteam;
        this.price = price;
    }


    //Create the geeter method

    public String getIteam() {
        return iteam;
    }

    public double getPrice() {
        return price;
    }
}
