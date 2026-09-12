package Java8.StreamApi;

public class Transcation {
    //Given a list of transactions find the total transaction amount based on catagory


     String iteam;
     double transaction;


    public Transcation(String iteam, double transaction) {
        this.iteam = iteam;
        this.transaction = transaction;
    }

    //Getter methods

    public String getIteam() {
        return iteam;
    }

    public double getTransaction() {
        return transaction;
    }
}
