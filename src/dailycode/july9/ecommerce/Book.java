package dailycode.july9.ecommerce;

public class Book extends Product {
    public Book(String name, double price) {
        super(name, price);
    }


    @Override
    public double discount() {

           double discount=this.productPrice*0.50;
           return  this.productPrice;

    }
}