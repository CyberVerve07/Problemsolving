package dailycode.july9.ecommerce;
    public class ElectronicsProducts extends Product {
        // Constructor (Parent constructor ko call karne ke liye super() use karenge)
        public ElectronicsProducts(String name, double price) {

            super(name, price);
        }

        @Override
       public double discount() {
                // Electronics par 10% discount
                double discount = this.productPrice * 0.10;
                return this.productPrice - discount;


        }
    }

