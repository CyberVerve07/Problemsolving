package Java8.Order;

public class TestDemo {
    static void main() {

        Demo1 demo1=new ClothesProduct();
        demo1.buy();
        Demo1 demo2=new ElectronicProducts();
        demo2.buy();
        demo2.refund();

    }
}
