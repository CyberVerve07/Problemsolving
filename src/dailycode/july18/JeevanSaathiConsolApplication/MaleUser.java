package dailycode.july18.JeevanSaathiConsolApplication;

public class MaleUser extends User{

    private int preferredAge;

    public MaleUser(int userId, String name, int age, String city, String profession, String religion, boolean premium) {
        super(userId, name, age, city, profession, religion, premium);
    }


    @Override
    void searchPartner() {
        System.out.println("Searching Female Profiles...");


    }



    }

