package Exceptions;

public class Demo2 {
    //Airthmatic exception is a runtime exception which occurs when we try to divide a number by zero.
    public static void main(String[] args) {
        int a = 10;
        int b = 0;
        try {
            int c = a / b;
            System.out.println(c);
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
        }
    }
}
