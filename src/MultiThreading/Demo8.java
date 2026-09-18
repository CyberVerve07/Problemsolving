package MultiThreading;

public class Demo8 {
    //Write a program and print the number 1 to 20  using two Threads

        public static void main(String[] args) {

            Thread t1 = new Thread(() -> {
                for (int i = 0; i <= 20; i++) {
                    System.out.println("Thread 1:"+i);
                }
            });
            Thread t2 = new Thread(() -> {
                for (int i = 1; i <= 20;i++) {
                    System.out.println("Thread 2:"+i);
                }
            });

            // Start both threads concurrently
            t1.start();
            t2.start();

            //Observation is Context switching is happen
        }
    }




