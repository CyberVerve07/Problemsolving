package Java8.StreamApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.*;

/**
 * Demo49 - Multithreading + Stream API ka combination
 *
 * Topics covered:
 *  1. Thread class extend karke custom thread banana
 *  2. Runnable interface implement karke thread banana
 *  3. parallelStream() - stream ki multithreading
 *  4. ExecutorService - thread pool se multiple tasks run karna
 */
public class Demo49 {

    // =====================================================
    // 1. Thread class extend karke custom thread
    // =====================================================
    static class SalaryPrinterThread extends Thread {
        private final List<Employee7> employees;

        SalaryPrinterThread(List<Employee7> employees) {
            this.employees = employees;
            this.setName("SalaryPrinter-Thread");
        }

        @Override
        public void run() {
            System.out.println("\n[" + Thread.currentThread().getName() + "] --- IT Dept Employees ---");
            employees.stream()
                    .filter(e -> e.dept.equalsIgnoreCase("IT"))
                    .forEach(e -> System.out.println("  " + e));
        }
    }

    // =====================================================
    // 2. Runnable interface implement karke thread
    // =====================================================
    static class ThirdHighestSalaryTask implements Runnable {
        private final List<Employee7> employees;

        ThirdHighestSalaryTask(List<Employee7> employees) {
            this.employees = employees;
        }

        @Override
        public void run() {
            System.out.println("\n[" + Thread.currentThread().getName() + "] --- 3rd Highest Salary ---");
            Optional<Employee7> thirdHighest = employees.stream()
                    .distinct()
                    .sorted(Comparator.comparingDouble((Employee7 emp) -> emp.salary).reversed())
                    .skip(2)
                    .findFirst();

            thirdHighest.ifPresentOrElse(
                    e -> System.out.println("  3rd Highest: " + e),
                    () -> System.out.println("  Data insufficient!")
            );
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        List<Employee7> employees = new ArrayList<>(Arrays.asList(
                new Employee7("Aditya",    70000,  "It"),
                new Employee7("Abhishake",  9000,  "Hr"),
                new Employee7("Prachi",   230000,  "Hr"),
                new Employee7("Kartik",    32000,  "Manager"),
                new Employee7("Prajwal",   92000,  "IT"),
                new Employee7("Aman",      23000,  "It")
        ));

        System.out.println("=== Main Thread: " + Thread.currentThread().getName() + " ===");

        // --------------------------------------------------
        // APPROACH 1: Thread class extend karke
        // --------------------------------------------------
        Thread t1 = new SalaryPrinterThread(employees);
        t1.start();
        t1.join(); // Main thread wait karega jab tak t1 khatam na ho

        // --------------------------------------------------
        // APPROACH 2: Runnable implement karke
        // --------------------------------------------------
        Thread t2 = new Thread(new ThirdHighestSalaryTask(employees), "ThirdHighest-Thread");
        t2.start();
        t2.join();

        // --------------------------------------------------
        // APPROACH 3: parallelStream() - automatic multithreading
        // Internally ForkJoinPool use karta hai
        // --------------------------------------------------
        System.out.println("\n[parallelStream] --- Salary > 50000 wale employees ---");
        employees.parallelStream()
                .filter(e -> e.salary > 50000)
                .forEach(e ->
                    System.out.println("  [" + Thread.currentThread().getName() + "] -> " + e)
                );

        // --------------------------------------------------
        // APPROACH 4: ExecutorService - Thread Pool
        // Callable use karke result bhi le sakte hain
        // --------------------------------------------------
        System.out.println("\n--- ExecutorService: Max Salary Finder ---");
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Callable<T> - Runnable jaisa hi, par result return karta hai
        Callable<Employee7> maxSalaryTask = () -> {
            System.out.println("  [" + Thread.currentThread().getName() + "] max salary dhundh raha hai...");
            return employees.stream()
                    .max(Comparator.comparingDouble(e -> e.salary))
                    .orElseThrow(() -> new RuntimeException("Empty list!"));
        };

        Callable<Long> hrCountTask = () -> {
            System.out.println("  [" + Thread.currentThread().getName() + "] HR count kar raha hai...");
            return employees.stream()
                    .filter(e -> e.dept.equalsIgnoreCase("hr"))
                    .count();
        };

        // Future - async result holder
        Future<Employee7> maxFuture = executor.submit(maxSalaryTask);
        Future<Long>      hrFuture  = executor.submit(hrCountTask);

        // get() - result aane tak block hoga (blocking call)
        System.out.println("  Max Salary Employee : " + maxFuture.get());
        System.out.println("  HR Dept Count       : " + hrFuture.get());

        executor.shutdown(); // Pool band karo, warna program hang karega
        System.out.println("\n=== Sab kaam khatam! Main thread exit. ===");
    }
}
