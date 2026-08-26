package Collection.Set;

import java.util.HashSet;
import java.util.Set;

// Record use karne se equals, hashCode aur getters apne aap ban jate hain
class Testorder{

    public static void main(String[] args) {
        Set<OrderService> orderServices = new HashSet<>();

        OrderService order1 = new OrderService("Clothes", "Aditya", "Btm2nd19", 800);
        OrderService order2 = new OrderService("Clothes", "Aditya", "Btm2nd19", 800);
        OrderService order3 = new OrderService("Clothes", "Aditya", "Btm2nd19", 800);
        OrderService order4 = new OrderService("Clothes", "Aditya", "Btm2nd19", 800);
        OrderService order5 = new OrderService("Clothes", "Aditya", "Btm2nd19", 800);
        OrderService order6 = new OrderService("Clothes", "Aditya", "Btm2nd19", 800);
        OrderService order7 = new OrderService("Clothes", "Aditya", "Btm2nd19", 800);
        OrderService order8 = new OrderService("Clothes", "Aditya", "Btm2nd19", 800);
        OrderService order9 = new OrderService("Clothes", "Aditya", "Btm2nd19", 800);

        orderServices.add(order1);
        orderServices.add(order2);
        orderServices.add(order3);
        orderServices.add(order4);
        orderServices.add(order5);
        orderServices.add(order6);
        orderServices.add(order7);
        orderServices.add(order8);
        orderServices.add(order9);
        System.out.println("Order 1 Hash: " + order1.hashCode());
        System.out.println("Order 2 Hash: " + order2.hashCode());

        System.out.println(orderServices);

        // Data same hai, isliye HashSet size 1 aayega!
        System.out.println("Total unique orders in set: " + orderServices.size());
        //Check equals

        System.out.println(order1.equals(order2));
    }
}

