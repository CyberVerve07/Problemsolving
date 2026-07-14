package dailycode.july14;

public class Dosa extends  Food{
    @Override
    void prepareFood() {
        System.out.println("Perpare dosa-------");


    }

    @Override
    public String getCategory() {
        return super.getCategory();
    }

    @Override
    public String getPrice() {
        return "90";
    }
}
