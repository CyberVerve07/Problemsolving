package Exceptions;

import java.util.HashMap;
import java.util.Map;

// Custom Runtime Exception
class CacheHitException extends RuntimeException {

    public CacheHitException(String message) {
        super(message);
    }
}

public class Demo4 {

    public static String getFromCache(String key) {

        Map<String, String> cache = new HashMap<>();

        cache.put("user1", "Aditya");
        cache.put("user2", "Rahul");

        String value = cache.get(key);

        if (value == null) {
            throw new CacheHitException(
                    "Key not found in cache: " + key
            );
        }

        return value;
    }

    public static void main(String[] args) {

        try {
            String value = getFromCache("nonExistentKey");

            System.out.println(value);

        } catch (CacheHitException e) {

            System.out.println("Error: " + e.getMessage());
        }
    }
}
