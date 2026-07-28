package dailycode.july27.QuickBite;

public class Authentication {

    private String CustomerID;

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        CustomerID = customerID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.isEmpty()) {
            System.out.println("Invalid Mobile number:: ");

        } else {
            PhoneNumber=phoneNumber;
        }
    }
    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public double getWalleBalance() {
        return WalleBalance;
    }

    public void setWalleBalance(double walleBalance) {
        if (walleBalance>=0) {
            WalleBalance = walleBalance;
        }
        else {
            System.out.println(" Wallet balance is Low:");
        }
    }

    public Authentication(String customerID, String name, String phoneNumber, String poneNumber, String email, String address, String password, double walleBalance) {
        CustomerID = customerID;
        Name = name;
        PhoneNumber = poneNumber;
        Email = email;
        Address = address;
        Password = password;
        WalleBalance = walleBalance;
    }

    private String Name;
    private String PhoneNumber;
    private String Email;
    private String Address;
    private String Password;
    private double WalleBalance;


    //Register
    //Login
    //Logout
    //View Profile
    //Update Profile


    void login(String tocken) {
        System.out.println("Enter the default token  key ::  :: ");
        if (tocken.equals(getPassword())) {
            System.out.println("Login is Success Full ::: ");
        } else {
            System.out.println("Password are not match :: ");
            System.out.println("Please Recheck your Password:: ");
        }
    }

       void  logout(){
           System.out.println("Logout is Successfully thanks for using :: ");
       }
         void ViewProfile(){
             System.out.println("User name is "+getName());
             System.out.println("Phone Number is "+getPhoneNumber());
             System.out.println("Email adderess is :"+getEmail());
             System.out.println("Addres is :"+getAddress());

         }
          void  updateProfile (){

          }


}