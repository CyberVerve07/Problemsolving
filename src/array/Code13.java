package array;

// 1. Define the custom exception
class BookIsNotAvailableException extends Exception {
    public BookIsNotAvailableException(String message) {
        super(message);
    }
}

public class Code13 {
    public static void main(String[] args) {
        int[] book = new int[]{20, 30, 49, 38, 72};
        int requestedIndex = 9;

        try {
            // 3. Implement proper control flow to check bounds
            if (requestedIndex < 0 || requestedIndex >= book.length) {
                // 2. Instantiate the exception using 'new'
                throw new BookIsNotAvailableException("Book at index " + requestedIndex + " is not available.");
            }

            // 4. Safely access the array if the exception was not thrown
            System.out.println(book[requestedIndex]);

        } catch (BookIsNotAvailableException e) {
            // Wrap and rethrow as a RuntimeException to halt execution, or handle it properly.
            throw new RuntimeException(e);
        }
    }
}