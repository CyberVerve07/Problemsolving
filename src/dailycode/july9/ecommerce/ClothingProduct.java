package dailycode.july9.ecommerce;

public  class ClothingProduct extends Product {

    public ClothingProduct(String name, double price) {
        super(name, price);
    }

@Override          //Run time Polymorphism :: because jvm check in runtime methods name will be checked
    public double discount(){
        // Clothing par 20% discount  dena ha
        // 10*100/20
        double discount = this.productPrice * 0.20;
        return this.productPrice - discount;
    }
}
