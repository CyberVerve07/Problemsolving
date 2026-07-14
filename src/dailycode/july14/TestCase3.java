package dailycode.july14;

public class TestCase3 {

    public static void main(String[] args) {

        Food[] menu = {
                new Pizza(),
                new Burger(),
                new Dosa(),

        };

        for (Food food : menu) {
            food.prepareFood();
            System.out.println("Category: " + food.getCategory());
            System.out.println("Price: ₹" + food.getPrice());
            System.out.println();
        }
    }
}