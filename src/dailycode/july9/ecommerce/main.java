package dailycode.july9.ecommerce;

public class
main {
    public static void main(String[] args) {
        // Electronics product (Base price: 50000)
        Product laptop = new ElectronicsProducts("Laptop", 50000);

        // Clothing product (Base price: 2000)
        Product tShirt = new ClothingProduct("T-Shirt", 2000);
         //Book ka object
        Product Book=new Book("C++ in advance",999);


        System.out.println("Laptop Price after Discount: " + laptop.discount());


        System.out.println("T-Shirt Price after Discount: " + tShirt.discount());



        System.out.println("Book Price after Discount :"+Book.discount());
    }

}

