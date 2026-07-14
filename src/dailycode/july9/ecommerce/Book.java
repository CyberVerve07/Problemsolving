package dailycode.july9.ecommerce;

public class Book extends Product {
    public Book(String name, double price) {
        super(name, price);
    }


    @Override //Same Method name only chane the  business logic ::
    public double discount() {

          // Discount foe a book is ::
           double discount=this.productPrice*0.50;
           return  this.productPrice - discount;

    }
}