package MultiThreading.ThreadCommunication;

import java.util.Comparator;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Demo25 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<Integer>completableFuture=CompletableFuture.supplyAsync(()->
        {
            System.out.println(Thread.currentThread().getName());
            return 20;
        });

        System.out.println(completableFuture.get());
    }
}
