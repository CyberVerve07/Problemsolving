package august.augest5;

public class Login {

    public static void main(String[] args) {

        try {
            login("Aditya", "Adit");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void login(String name, String password)throws  IllegalArgumentException {

        if (name == null ) {
            throw new IllegalArgumentException("Username cannot be null.");
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException("Username cannot be empty.");
        }

        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null.");
        }

        if (password.length() < 8) {
            throw new IllegalArgumentException("Password must contain at least 8 characters.");
        }

        System.out.println("Login Successful");
    }
}