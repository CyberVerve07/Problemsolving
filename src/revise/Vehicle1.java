package revise;

public interface Vehicle1 {

    // Abstract method (needs implementation)
    void start();

    // Static method (utility function)
    static boolean isValidVin(String vin) {
        return vin != null && vin.length() == 17;
    }
}

