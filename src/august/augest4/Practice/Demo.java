package august.augest4.Practice;

import java.io.PrintStream;

public class Demo {

    public  static int  print() {
        try {
            return 10;
        } finally {
            return 20;
        }}

    public static void main(String[] args) {
        System.out.println(print());


    }}