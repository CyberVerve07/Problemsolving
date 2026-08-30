package Java8.Order;

public class ClothesProduct implements Demo1{
    @Override
    public void buy() {
        System.out.println("Buting the T-shirt ");
    }

    @Override
    public void refund() {
        Demo1.super.refund();
    }
}
