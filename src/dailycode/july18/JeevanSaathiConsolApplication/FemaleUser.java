package dailycode.july18.JeevanSaathiConsolApplication;

public class FemaleUser extends User{

     public  String preferredProfession;

    public FemaleUser(int userId, String name, int age, String city, String profession, String religion, boolean premium) {
        super(userId, name, age, city, profession, religion, premium);
    }

    @Override
    void searchPartner() {

        System.out.println("Search Male Profiles: ");

    }

    
}
