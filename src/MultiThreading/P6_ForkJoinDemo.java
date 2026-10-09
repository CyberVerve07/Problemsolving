package MultiThreading;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * Question 6: Fork-Join Framework Demo
 * ---------------------------------------
 * Fork-Join framework Java 7 me introduce hua tha. Ye "divide and conquer" strategy
 * ko parallel execution ke saath implement karta hai.
 *
 * Core Idea:
 *  - FORK  → Task ko chhote sub-tasks me tod do aur unhe parallel execute karo
 *  - JOIN  → Saare sub-tasks ke results ko collect karke combine karo
 *
 * Key Classes:
 *  1. ForkJoinPool     → Special thread pool for fork-join tasks (uses work-stealing)
 *  2. RecursiveTask<V> → Jab task kuch VALUE return karta ho  (e.g., sum, max)
 *  3. RecursiveAction  → Jab task koi value return NA kare    (e.g., array sort/fill)
 *
 * Work-Stealing Algorithm:
 *  - Har thread apna deque (double-ended queue) rakhta hai
 *  - Idle threads dusre threads ke pending tasks "steal" kar lete hain
 *  - Isse CPU maximum utilize hota hai
 */
public class P6_ForkJoinDemo {

    // ─────────────────────────────────────────────────────────────────────────
    // EXAMPLE 1: RecursiveTask<Long> — Parallel Array Sum
    //   Problem: Ek bada array hai, uska sum nikalna hai fast
    //   Approach: Array ko halves me divide karo, dono halves parallel me sum karo,
    //             phir dono results add karo
    // ─────────────────────────────────────────────────────────────────────────
    static class ParallelSumTask extends RecursiveTask<Long> {

        private static final int THRESHOLD = 5_000; // Ye limit ke upar hi fork karega
        private final long[] array;
        private final int start;
        private final int end;

        public ParallelSumTask(long[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end   = end;
        }

        @Override
        protected Long compute() {
            int length = end - start;

            // BASE CASE: Agar task chhota hai to directly compute karo (no fork)
            if (length <= THRESHOLD) {
                long sum = 0;
                for (int i = start; i < end; i++) {
                    sum += array[i];
                }
                return sum;
            }

            // FORK STEP: Task ko do halves me divide karo
            int mid = start + length / 2;

            ParallelSumTask leftTask  = new ParallelSumTask(array, start, mid);
            ParallelSumTask rightTask = new ParallelSumTask(array, mid, end);

            // leftTask ko fork karo → background thread me chala do
            leftTask.fork();

            // rightTask current thread me hi compute karo (optimization)
            long rightResult = rightTask.compute();

            // JOIN STEP: leftTask ke result ka wait karo aur dono add karo
            long leftResult = leftTask.join();

            return leftResult + rightResult;
        }
    }

    // ─────────────────────────────────────────────────────────────────────────
    // EXAMPLE 2: RecursiveAction — Parallel Array Increment
    //   Problem: Array ke har element ko 1 se increment karna hai
    //   Approach: RecursiveAction use karenge (return type void)
    // ─────────────────────────────────────────────────────────────────────────
    static class ParallelIncrementAction extends RecursiveAction {

        private static final int THRESHOLD = 3_000;
        private final int[] array;
        private final int start;
        private final int end;

        public ParallelIncrementAction(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end   = end;
        }

        @Override
        protected void compute() {
            int length = end - start;

            // BASE CASE: Directly increment karo
            if (length <= THRESHOLD) {
                for (int i = start; i < end; i++) {
                    array[i]++;
                }
                return;
            }

            // FORK STEP: Do halves banao
            int mid = start + length / 2;

            ParallelIncrementAction leftAction  = new ParallelIncrementAction(array, start, mid);
            ParallelIncrementAction rightAction = new ParallelIncrementAction(array, mid, end);

            // invokeAll() dono tasks ko fork karta hai aur join bhi karta hai automatically
            invokeAll(leftAction, rightAction);
        }
    }

    // ─────────────────────────────────────────────────────────────────────────
    // EXAMPLE 3: Fibonacci using RecursiveTask (classic divide & conquer)
    // ─────────────────────────────────────────────────────────────────────────
    static class FibonacciTask extends RecursiveTask<Long> {

        private final int n;

        public FibonacciTask(int n) {
            this.n = n;
        }

        @Override
        protected Long compute() {
            // BASE CASE
            if (n <= 1) return (long) n;

            // FORK: fib(n-1) ko fork karo
            FibonacciTask fib1 = new FibonacciTask(n - 1);
            fib1.fork();

            // Compute fib(n-2) in current thread
            FibonacciTask fib2 = new FibonacciTask(n - 2);
            long result2 = fib2.compute();

            // JOIN: fib(n-1) ka result lo
            long result1 = fib1.join();

            return result1 + result2;
        }
    }

    // ─────────────────────────────────────────────────────────────────────────
    // MAIN METHOD
    // ─────────────────────────────────────────────────────────────────────────
    public static void main(String[] args) throws Exception {

        // ForkJoinPool.commonPool() → JVM ka shared pool (CPUs ke barabar threads)
        ForkJoinPool pool = ForkJoinPool.commonPool();
        System.out.println("ForkJoinPool Parallelism (threads): " + pool.getParallelism());
        System.out.println("Available Processors: " + Runtime.getRuntime().availableProcessors());
        System.out.println("=".repeat(60));

        // ── Demo 1: Parallel Array Sum ────────────────────────────────────────
        System.out.println("\n[DEMO 1] Parallel Array Sum (RecursiveTask<Long>)");
        System.out.println("-".repeat(50));

        int SIZE = 1_000_000;
        long[] bigArray = new long[SIZE];
        for (int i = 0; i < SIZE; i++) bigArray[i] = i + 1; // 1 to 1_000_000

        long expectedSum = (long) SIZE * (SIZE + 1) / 2; // Formula: n*(n+1)/2

        // Sequential sum
        long seqStart = System.currentTimeMillis();
        long seqSum   = 0;
        for (long val : bigArray) seqSum += val;
        long seqTime  = System.currentTimeMillis() - seqStart;

        // Parallel Fork-Join sum
        long forkStart   = System.currentTimeMillis();
        ParallelSumTask sumTask = new ParallelSumTask(bigArray, 0, SIZE);
        long parallelSum = pool.invoke(sumTask); // invoke() = submit + wait for result
        long forkTime    = System.currentTimeMillis() - forkStart;

        System.out.println("Expected Sum  : " + expectedSum);
        System.out.println("Sequential Sum: " + seqSum    + "  Time: " + seqTime  + " ms");
        System.out.println("Parallel  Sum : " + parallelSum + "  Time: " + forkTime + " ms");
        System.out.println("Results Match : " + (seqSum == parallelSum));

        // ── Demo 2: Parallel Array Increment ─────────────────────────────────
        System.out.println("\n[DEMO 2] Parallel Array Increment (RecursiveAction)");
        System.out.println("-".repeat(50));

        int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.print("Before Increment: ");
        printArray(intArray);

        ParallelIncrementAction action = new ParallelIncrementAction(intArray, 0, intArray.length);
        pool.invoke(action); // void task → no return value

        System.out.print("After  Increment: ");
        printArray(intArray);

        // ── Demo 3: Fibonacci ─────────────────────────────────────────────────
        System.out.println("\n[DEMO 3] Fibonacci using Fork-Join (RecursiveTask<Long>)");
        System.out.println("-".repeat(50));

        int[] fibNumbers = {10, 15, 20, 25};
        for (int n : fibNumbers) {
            FibonacciTask fibTask = new FibonacciTask(n);
            long result = pool.invoke(fibTask);
            System.out.printf("  Fibonacci(%2d) = %d%n", n, result);
        }

        // ── Summary ───────────────────────────────────────────────────────────
        System.out.println("\n" + "=".repeat(60));
        System.out.println("KEY TAKEAWAYS:");
        System.out.println("  1. ForkJoinPool    → Use commonPool() ya new ForkJoinPool(n)");
        System.out.println("  2. RecursiveTask   → Result return karna ho to use karo");
        System.out.println("  3. RecursiveAction → Result nahi chahiye to use karo");
        System.out.println("  4. fork()          → Sub-task ko asynchronously schedule karta hai");
        System.out.println("  5. join()          → Sub-task ke result ka wait karta hai");
        System.out.println("  6. invokeAll()     → Multiple tasks ko fork+join ek saath karta hai");
        System.out.println("  7. compute()       → Current thread me hi execute karta hai (no fork)");
        System.out.println("  8. invoke()        → pool me task submit karo aur result lo (blocking)");
    }

    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
