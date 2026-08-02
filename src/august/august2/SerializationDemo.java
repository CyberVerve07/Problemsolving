package august.august2;

import java.io.*;

// Class implementing Serializable marker interface
class UserAccount implements Serializable {
    // Recommended serialVersionUID for object versioning control
    private static final long serialVersionUID = 1L;

    private String username;
    private String email;
    // transient fields are ignored during serialization
    private transient String password;

    public UserAccount(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserAccount{username='" + username + "', email='" + email + "', password='" + password + "'}";
    }
}

public class SerializationDemo {
    private static final String FILE_NAME = "user_account.ser";

    public static void main(String[] args) {
        System.out.println("=== MARKER INTERFACE: SERIALIZATION & DESERIALIZATION DEMO ===");

        UserAccount originalUser = new UserAccount("john_doe", "john@example.com", "SecretPass123");
        System.out.println("Original Object before Serialization:");
        System.out.println(originalUser);

        // 1. Serialization (Writing Object to File)
        serializeObject(originalUser, FILE_NAME);

        // 2. Deserialization (Reading Object from File)
        UserAccount deserializedUser = deserializeObject(FILE_NAME);

        System.out.println("\nDeserialized Object after Reading from File:");
        System.out.println(deserializedUser);
        System.out.println("Note: 'password' field is null because it was marked as 'transient'.");

        // Clean up created serialization file
        File file = new File(FILE_NAME);
        if (file.exists()) {
            boolean deleted = file.delete();
            if (deleted) {
                System.out.println("\nTemporary file '" + FILE_NAME + "' cleaned up successfully.");
            }
        }
    }

    private static void serializeObject(UserAccount obj, String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(obj);
            System.out.println("\n[SUCCESS] Object successfully serialized to file: " + filePath);
        } catch (IOException e) {
            System.err.println("Error during serialization: " + e.getMessage());
        }
    }

    private static UserAccount deserializeObject(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            UserAccount obj = (UserAccount) ois.readObject();
            System.out.println("[SUCCESS] Object successfully deserialized from file: " + filePath);
            return obj;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error during deserialization: " + e.getMessage());
            return null;
        }
    }
}
