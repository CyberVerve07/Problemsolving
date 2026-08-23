package august.augest22;

class Product implements Comparable<Product> {

    int price;

    Product(int price) {
        this.price = price;
    }

    @Override
    public int compareTo(Product other) {
        return Integer.compare(this.price, other.price);
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                '}';
    }
}