package Exceptions;

public class Demo6 {
    //try with resources is a feature in java which allows us to automatically close the resources after use. It is used to avoid resource leaks.
    public static void main(String[] args) {
        try (java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader
                ("test.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (java.io.IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }}