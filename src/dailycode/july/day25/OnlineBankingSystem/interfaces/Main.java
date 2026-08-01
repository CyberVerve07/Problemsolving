//<<<<<<< HEAD
////package dailycode.july.day25.OnlineBankingSystem.interfaces;
////
////
//// * Main — Demonstrates Lambda Expression with Functional Interface.
//// *
//// * INTERVIEW DEFINITION — Lambda Expression:
//// * --------------------------------------------
//// * Q: What is a Lambda Expression?
//// * A: A lambda expression is a SHORT, ANONYMOUS FUNCTION (no name, no class) that
//// *    provides the implementation for the single abstract method of a Functional Interface.
//// *    Syntax: (parameters) -> { body }
//// *    Shorthand: (parameters) -> expression (for single-line body, no braces needed)
//// *
//// * Q: Why do we use Lambda Expressions?
//// * A: 1. CONCISE CODE — replace bulky anonymous inner classes with one-liners.
//// *    2. FUNCTIONAL PROGRAMMING — treat functions as values (pass behavior as argument).
//// *    3. READABILITY — easier to read and maintain.
//// *    4. Works ONLY with Functional Interfaces (one abstract method).
//// *
//// * Q: Lambda vs Anonymous Inner Class?
//// * A: BEFORE (Anonymous Inner Class):
//// *    Product p = new Product() {
//// *        @Override
//// *        public void publish(String message) {
//// *            System.out.println(message);
//// *        }
//// *    };
//// *
//// *    AFTER (Lambda Expression):
//// *    Product p = message -> System.out.println(message);
//// *    → Same result, much less code!
//// *
//// * JAVA TYPE: Lambda Expression
//// * JAVA VERSION: Java 8..
//// */
////public class Main {
////
////    public static void main(String[] args) {
////        // Lambda Expression — implements Product's publish(String) method in one line
////        Product product = message -> System.out.println(message);
////        product.publish("Hello bhaji Ram Ram Sbhi ko ::::::: ::" );
////    }
////
////    //for eg we dont write the core logic in the class just write the utility function for  reduce the
////    //code duplicity::
////
////    }
////
//=======
//package dailycode.july.day25.OnlineBankingSystem.interfaces;
//
///**
// * Main — Demonstrates Lambda Expression with Functional Interface.
// *
// * INTERVIEW DEFINITION — Lambda Expression:
// * --------------------------------------------
// * Q: What is a Lambda Expression?
// * A: A lambda expression is a SHORT, ANONYMOUS FUNCTION (no name, no class) that
// *    provides the implementation for the single abstract method of a Functional Interface.
// *    Syntax: (parameters) -> { body }
// *    Shorthand: (parameters) -> expression (for single-line body, no braces needed)
// *
// * Q: Why do we use Lambda Expressions?
// * A: 1. CONCISE CODE — replace bulky anonymous inner classes with one-liners.
// *    2. FUNCTIONAL PROGRAMMING — treat functions as values (pass behavior as argument).
// *    3. READABILITY — easier to read and maintain.
// *    4. Works ONLY with Functional Interfaces (one abstract method).
// *
// * Q: Lambda vs Anonymous Inner Class?
// * A: BEFORE (Anonymous Inner Class):
// *    Product p = new Product() {
// *        @Override
// *        public void publish(String message) {
// *            System.out.println(message);
// *        }
// *    };
// *
// *    AFTER (Lambda Expression):
// *    Product p = message -> System.out.println(message);
// *    → Same result, much less code!
// *
// * JAVA TYPE: Lambda Expression
// * JAVA VERSION: Java 8+
// *
// * @author Aditya
// * @version 2.0
// */
//public class Main {
//
//    public static void main(String[] args) {
//        // Lambda Expression — implements Product's publish(String) method in one line
//        Product product = message -> System.out.println(message);
//        product.publish("Hello from Lambda Expression!");
//    }
//}
//>>>>>>> fe85f421d2cb682cb4100dcce38957fd3f187bcd
