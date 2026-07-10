package july9.Register;


 class UserRegistration {
    public static void main(String[] args) {

        String firstName = "aditya";

        String formattedName =
                firstName.substring(0,1).toUpperCase()
                        + firstName.substring(1).toLowerCase();

        System.out.println("Formatted Name : " + formattedName);
    }
}