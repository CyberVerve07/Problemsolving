package MultiThreading.Exaample;

public class Testmain {
    static void main() {

        Thread t1=new Task1();
        Thread t2=new Task2();
        Thread t3=new Task3();

         t1.run();
         t2.run();
         t3.run();


    }
}
