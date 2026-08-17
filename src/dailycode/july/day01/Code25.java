package dailycode.july.day01;

public class Code25 {
    public static void main(String[] args) {
        Auth auth = new Auth();
        auth.login("Aditya", "Password123");
        auth.login("Aditya", String.valueOf(930393));
        auth.login("123456789012", String.valueOf(979));
    }

    static class Auth {

        void login(String name, String password) {
            System.out.println("Login done using password");
        }

        void login(String name, int otp) {
            System.out.println("Login done using OTP");
        }

        void login(String adharno, float otp) {
            System.out.println("Login by Aadhaar number");
        }
    }
}