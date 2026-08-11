package august.augest6;

public class Registration {

    public boolean doRegistration(String userId) {
        boolean status = false;
        boolean isUserExists = true;
        if (!isUserExists) {
            System.out.println("Registering the user:" + userId);

            //Insert the record
            status = true;
        } else {
            System.out.println("User is available in db..." + userId);
            throw new UserAlreadyExist("User already exists: " + userId);
        }
        return status;

    }

}