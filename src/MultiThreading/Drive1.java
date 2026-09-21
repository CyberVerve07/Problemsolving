package MultiThreading;

public class Drive1{
    public static void main(String[] args) {

        Task task1=new Task();
        PrintThread t1=new PrintThread(task1);
        t1.setName("First thread");
        t1.start();


        
        
    }
}
