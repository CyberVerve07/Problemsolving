package dailycode.july.day29.serialization;

public class Deserialization {
    public static void main(String[] args) {

        try {
            // Read the object from the file
            java.io.ObjectInputStream ois = new java.io.ObjectInputStream(new java.io.FileInputStream("src/dailycode/july29/serialization/hdfc.txt"));
            Hdfc hdfc = (Hdfc) ois.readObject();
            ois.close();

            // Print the deserialized object's data
            System.out.println("Account Number: " + hdfc.getAccountNumber());
            System.out.println("Account Holder: " + hdfc.getAccountHolder());
            System.out.println("Balance: " + hdfc.getBalance());
            System.out.println("Account Type: " + hdfc.getAccountType());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
