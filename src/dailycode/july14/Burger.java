package dailycode.july14;

public class Burger extends  Food {

    @Override
    void prepareFood() {

        System.out.println("Prepare Burger--------");
    }

    @Override
    public String getCategory() {
        return  super.getCategory();
    }

    @Override
    public String getPrice() {
        return  "299";
    }
}
