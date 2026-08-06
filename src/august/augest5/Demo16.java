package august.augest5;
public class Demo16 {

    // Recursive method to calculate factorial
    public static int factorial(int n) {
        // 1. Base Case: stops the recursion when n is 0 or 1
        if (n <= 1) {
            return 1;
        }

        // 2. Recursive Case: method calls itself with (n - 1)
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        int number = 4;
        int result = factorial(number);

        System.out.println("The factorial of " + number + " is: " + result);
    }
}

