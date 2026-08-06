package august.augest6;

import java.nio.file.attribute.UserDefinedFileAttributeView;

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
            throw new UnsupportedOperationException("User is already exist ");
        }
            return status;

    }

}