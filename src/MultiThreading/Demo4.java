package MultiThreading;

public class Demo4 {
    static void main() throws InterruptedException {
        //use of sleep method
        System.out.println("Main thread is start:");

        try {
            Thread.sleep(900);  //Thread.sleep is for Time waites state :
        }
        catch (InterruptedException e){

        }
        System.out.println("Main thread is end : ");
    }
}
