package MultiThreading;

import java.util.concurrent.*;

public class Demo24 {
    //Executor is work with the Callable

    public static void main(String[] args) {

        ExecutorService es= Executors.newFixedThreadPool(1);

        Future<Integer>future=es.submit(new Mythread1());

        System.out.println("Result is ::"+future);
    }

}

class  Mythread1 implements Callable<Integer> {

    @Override
    public Integer call()  {
        return  20;
    }
}
//Callable vs Runnable
//Need of Executable Service :
//Future ::: :: :: ::::::: ::::: :::::