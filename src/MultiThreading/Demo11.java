package MultiThreading;

public class Demo11 implements  Runnable {



        @Override
        public  void run () {
            for (int i = 0; i <= 10; i++) {
                if (i == 5) {
                    System.out.println("Sleeping:");
                    try {
                        Thread.sleep(1500); //current thread will be sleep for 1.5 seconds
                        System.out.println("sleeping time is over so Walk up ");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                System.out.println("Printing :" + i);

            }
        }
    }

    class Drive{

        public static void main(String[] args) {
            Demo11 demo11=new Demo11();
            Thread thread=new Thread(demo11);
            thread.start();


        }
    }