package dailycode.july18.JeevanSaathiConsolApplication;

public abstract class User {

    //Create a private fields of Users:

    private int userId;
    private String name;
    private int age;
    private String city;
    private String profession;
    private String religion;
    private boolean premium;

    //Create a Constructor for initialized the values at object creation:


    public User(int userId, String name, int age, String city, String profession, String religion, boolean premium) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.city = city;
        this.profession = profession;
        this.religion = religion;
        this.premium = premium;
    }

    //Create Getter and setter for read/Write


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    static void CompanyInfo() {
        System.out.println("**************\n" +
                "Welcome to JeevanSaathi\n" +
                "India's Trusted Matrimonial Platform\n" +
                "**************");
    }


        //Method for display the userDefeatist :

    final  void  displayDetails(){
        System.out.println("=====================");
        System.out.println("User Details are :::");
        System.out.println("User name is "+getName());
        System.out.println("User id is "+getUserId());
        System.out.println("User age is "+getAge());
        System.out.println("User city is :"+getCity());
        System.out.println("User profession :"+getProfession());
        System.out.println("User religion is :"+getReligion());
        System.out.println("========================================");
        System.out.println();
    }


       //Create an Abstract method   for  Every User can Search Differently
    abstract void searchPartner();





}