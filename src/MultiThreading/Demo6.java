package MultiThreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Demo6 {
   // static void main() throws InterruptedException {

        final ReentrantLock lock = new ReentrantLock();


           void attempttask(){

               try {
                   if (lock.tryLock(2,TimeUnit.SECONDS)){

                   }
                   else{
                       System.out.println("Could not accquire the lock :performing the taask : ");
                   }
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
               finally {
                   lock.unlock();
               }
           }


}