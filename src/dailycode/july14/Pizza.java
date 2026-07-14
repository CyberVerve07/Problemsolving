package dailycode.july14;

public class Pizza extends  Food{

    @Override
    void prepareFood() {
        System.out.println("Perpare Pizza------");
    }

    @Override
    public String getCategory() {
        return super.getCategory();
    }

    @Override
    public String getPrice() {
        return "399";
    }
}


