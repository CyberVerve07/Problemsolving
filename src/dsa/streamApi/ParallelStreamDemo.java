package dsa.streamApi;
import  java.util.logging.Logger;
import java.util.List;

public class ParallelStreamDemo {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        // Sequential: Runs entirely on main thread in order
        System.out.println("Sequential Stream:");
        numbers.stream().forEach(n ->
                System.out.println(Thread.currentThread().getName() + " -> " + n)
        );

        // Parallel: Runs concurrently on multiple ForkJoinPool worker threads
        System.out.println("\nParallel Stream:");
        numbers.parallelStream().forEach(n -> System.out.println(Thread.currentThread().getName() + " -> " + n)
        );



    }
}