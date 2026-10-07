//package Java8.StreamApi;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//import java.util.concurrent.*;
//import java.util.concurrent.atomic.AtomicInteger;
//import java.util.stream.Collectors;
//
///**
// * Demo49 - Multithreading + Stream API ka combination
// *
// * Topics covered:
// *  1. Thread class extend karke custom thread banana
// *  2. Runnable interface implement karke thread banana
// *  3. parallelStream() - stream ki multithreading
// *  4. ExecutorService - thread pool se multiple tasks run karna
// *  5. synchronized - race condition rokne ke liye
// *  6. volatile - inter-thread visibility
// *  7. CountDownLatch - threads ko coordinate karna
// *  8. CompletableFuture - non-blocking async chaining
// */
//public class Demo49 {
//
//    // =====================================================
//    // 1. Thread class extend karke custom thread
//    // =====================================================
//    static class SalaryPrinterThread extends Thread {
//        private final List<Employee7> employees;
//
//        SalaryPrinterThread(List<Employee7> employees) {
//            this.employees = employees;
//            this.setName("SalaryPrinter-Thread");
//        }
//
//        @Override
//        public void run() {
//            System.out.println("\n[" + Thread.currentThread().getName() + "] --- IT Dept Employees ---");
//            employees.stream()
//                    .filter(e -> e.dept.equalsIgnoreCase("IT"))
//                    .forEach(e -> System.out.println("  " + e));
//        }
//    }
//
//    // =====================================================
//    // 2. Runnable interface implement karke thread
//    // =====================================================
//    static class ThirdHighestSalaryTask implements Runnable {
//        private final List<Employee7> employees;
//
//        ThirdHighestSalaryTask(List<Employee7> employees) {
//            this.employees = employees;
//        }
//
//        @Override
//        public void run() {
//            System.out.println("\n[" + Thread.currentThread().getName() + "] --- 3rd Highest Salary ---");
//            Optional<Employee7> thirdHighest = employees.stream()
//                    .distinct()
//                    .sorted(Comparator.comparingDouble((Employee7 emp) -> emp.salary).reversed())
//                    .skip(2)
//                    .findFirst();
//
//            thirdHighest.ifPresentOrElse(
//                    e -> System.out.println("  3rd Highest: " + e),
//                    () -> System.out.println("  Data insufficient!")
//            );
//        }
//    }
//
//    // =====================================================
//    // 5. synchronized - Race condition rokne ke liye
//    //    Multiple threads ek saath ek shared counter update karein
//    //    bina synchronized ke galat result aata hai
//    // =====================================================
//    static class SalaryCounter {
//        private int count = 0;                     // shared resource
//        private final Object lock = new Object();  // lock object
//
//        // synchronized method - sirf ek thread ek baar access kar sakti hai
//        public synchronized void increment() {
//            count++;
//        }
//
//        // synchronized block - finer control ke liye
//        public void incrementWithBlock() {
//            synchronized (lock) {
//                count++;
//            }
//        }
//
//        public int getCount() { return count; }
//    }
//
//    // =====================================================
//    // 6. volatile - variable ka latest value sab threads ko dikhe
//    //    Without volatile: thread apni local cache mein stale value rakh sakti hai
//    // =====================================================
//    static class DepartmentScanner implements Runnable {
//        private volatile boolean running = true;  // volatile = always main memory se padho
//        private final List<Employee7> employees;
//
//        DepartmentScanner(List<Employee7> employees) {
//            this.employees = employees;
//        }
//
//        @Override
//        public void run() {
//            System.out.println("  [" + Thread.currentThread().getName() + "] Scanning departments...");
//            while (running) {
//                Map<String, Long> deptCount = employees.stream()
//                        .collect(Collectors.groupingBy(
//                                e -> e.dept.toUpperCase(),
//                                Collectors.counting()
//                        ));
//                deptCount.forEach((dept, cnt) ->
//                        System.out.println("    Dept: " + dept + " -> " + cnt + " employees")
//                );
//                running = false; // ek baar scan karo aur band karo
//            }
//        }
//
//        public void stop() { this.running = false; }
//    }
//
//    public static void main(String[] args) throws InterruptedException, ExecutionException {
//
//        List<Employee7> employees = new ArrayList<>(Arrays.asList(
//                new Employee7("Aditya",    70000,  "It"),
//                new Employee7("Abhishake",  9000,  "Hr"),
//                new Employee7("Prachi",   230000,  "Hr"),
//                new Employee7("Kartik",    32000,  "Manager"),
//                new Employee7("Prajwal",   92000,  "IT"),
//                new Employee7("Aman",      23000,  "It")
//        ));
//
//        System.out.println("=== Main Thread: " + Thread.currentThread().getName() + " ===");
//
//        // --------------------------------------------------
//        // APPROACH 1: Thread class extend karke
//        // --------------------------------------------------
//        Thread t1 = new SalaryPrinterThread(employees);
//        t1.start();
//        t1.join(); // Main thread wait karega jab tak t1 khatam na ho
//
//        // --------------------------------------------------
//        // APPROACH 2: Runnable implement karke
//        // --------------------------------------------------
//        Thread t2 = new Thread(new ThirdHighestSalaryTask(employees), "ThirdHighest-Thread");
//        t2.start();
//        t2.join();
//
//        // --------------------------------------------------
//        // APPROACH 3: parallelStream() - automatic multithreading
//        // Internally ForkJoinPool use karta hai
//        // --------------------------------------------------
//        System.out.println("\n[parallelStream] --- Salary > 50000 wale employees ---");
//        employees.parallelStream()
//                .filter(e -> e.salary > 50000)
//                .forEach(e ->
//                    System.out.println("  [" + Thread.currentThread().getName() + "] -> " + e)
//                );
//
//        // --------------------------------------------------
//        // APPROACH 4: ExecutorService - Thread Pool
//        // Callable use karke result bhi le sakte hain
//        // --------------------------------------------------
//        System.out.println("\n--- ExecutorService: Max Salary Finder ---");
//        ExecutorService executor = Executors.newFixedThreadPool(2);
//
//        // Callable<T> - Runnable jaisa hi, par result return karta hai
//        Callable<Employee7> maxSalaryTask = () -> {
//            System.out.println("  [" + Thread.currentThread().getName() + "] max salary dhundh raha hai...");
//            return employees.stream()
//                    .max(Comparator.comparingDouble(e -> e.salary))
//                    .orElseThrow(() -> new RuntimeException("Empty list!"));
//        };
//
//        Callable<Long> hrCountTask = () -> {
//            System.out.println("  [" + Thread.currentThread().getName() + "] HR count kar raha hai...");
//            return employees.stream()
//                    .filter(e -> e.dep.equalsIgnoreCase("hr"))
//                    .count();
//        };
//
//        // Future - async result holder
//        Future<Employee7> maxFuture = executor.submit(maxSalaryTask);
//        Future<Long>      hrFuture  = executor.submit(hrCountTask);
//
//        // get() - result aane tak block hoga (blocking call)
//        System.out.println("  Max Salary Employee : " + maxFuture.get());
//        System.out.println("  HR Dept Count       : " + hrFuture.get());
//
//        executor.shutdown();
//
//        // --------------------------------------------------
//        // APPROACH 5: synchronized - Race condition rokna
//        // Bina synchronized ke: 3 threads ek saath count++ karein
//        // to galat result aa sakta hai (lost update problem)
//        // --------------------------------------------------
//        System.out.println("\n--- synchronized: Salary > 30000 count karo safely ---");
//        SalaryCounter counter = new SalaryCounter();
//        AtomicInteger atomicCount = new AtomicInteger(0); // Alternative to synchronized
//
//        List<Thread> threads = new ArrayList<>();
//        for (Employee7 emp : employees) {
//            Thread t = new Thread(() -> {
//                if (emp.salary > 30000) {
//                    counter.increment();          // synchronized method
//                    atomicCount.incrementAndGet(); // AtomicInteger (lock-free)
//                }
//            });
//            threads.add(t);
//            t.start();
//        }
//        for (Thread t : threads) t.join(); // Sab threads khatam hone tak wait karo
//
//        System.out.println("  Synchronized count  : " + counter.getCount());
//        System.out.println("  AtomicInteger count : " + atomicCount.get());
//
//        // --------------------------------------------------
//        // APPROACH 6: volatile - DepartmentScanner
//        // --------------------------------------------------
//        System.out.println("\n--- volatile: Department Scanner ---");
//        DepartmentScanner scanner = new DepartmentScanner(employees);
//        Thread scanThread = new Thread(scanner, "DeptScanner-Thread");
//        scanThread.start();
//        scanThread.join();
//
//        // --------------------------------------------------
//        // APPROACH 7: CountDownLatch
//        // Ek thread tab tak wait kare jab tak N threads apna kaam khatam na kar lein
//        // Real use: parallel data loading, barrier synchronization
//        // --------------------------------------------------
//        System.out.println("\n--- CountDownLatch: 3 tasks parallel ---");
//        CountDownLatch latch = new CountDownLatch(3); // 3 threads ka wait
//        ExecutorService latchPool = Executors.newFixedThreadPool(3);
//
//        latchPool.submit(() -> {
//            System.out.println("  [" + Thread.currentThread().getName() + "] Task 1: IT dept filter");
//            employees.stream().filter(e -> e.dept.equalsIgnoreCase("IT")).forEach(e -> {});
//            latch.countDown(); // -1 from latch
//        });
//        latchPool.submit(() -> {
//            System.out.println("  [" + Thread.currentThread().getName() + "] Task 2: HR dept filter");
//            employees.stream().filter(e -> e.dept.equalsIgnoreCase("HR")).forEach(e -> {});
//            latch.countDown();
//        });
//        latchPool.submit(() -> {
//            System.out.println("  [" + Thread.currentThread().getName() + "] Task 3: Salary sort");
//            employees.stream().sorted(Comparator.comparingDouble(e -> e.salary)).forEach(e -> {});
//            latch.countDown();
//        });
//
//        latch.await(); // Jab tak teeno countDown() call na ho, yahan ruko
//        System.out.println("  Sab 3 tasks complete! Latch zero ho gaya.");
//        latchPool.shutdown();
//
//        // --------------------------------------------------
//        // APPROACH 8: CompletableFuture - Non-blocking async chaining
//        // Future se zyada powerful: chain, combine, exception handle kar sakte ho
//        // --------------------------------------------------
//        System.out.println("\n--- CompletableFuture: Async chaining ---");
//
//        CompletableFuture<Double> avgSalaryFuture = CompletableFuture
//                .supplyAsync(() -> {
//                    // Step 1: async mein average nikalo
//                    System.out.println("  [" + Thread.currentThread().getName() + "] Avg salary compute kar raha hai...");
//                    return employees.stream()
//                            .mapToDouble(e -> e.salary)
//                            .average()
//                            .orElse(0.0);
//                })
//                .thenApply(avg -> {
//                    // Step 2: result milne par, 10% bonus add karo (chaining)
//                    System.out.println("  [" + Thread.currentThread().getName() + "] 10% bonus add kar raha hai...");
//                    return avg * 1.10;
//                })
//                .exceptionally(ex -> {
//                    // Step 3: koi bhi exception ho to yahan handle karo
//                    System.out.println("  Error: " + ex.getMessage());
//                    return 0.0;
//                });
//
//        // thenAccept - final result consume karo (non-blocking chain ka end)
//        CompletableFuture<Void> printFuture = avgSalaryFuture.thenAccept(result ->
//                System.out.printf("  Avg Salary + 10%% Bonus = %.2f%n", result)
//        );
//
//        // 2 CompletableFutures ko combine karo
//        CompletableFuture<String> topEarnerFuture = CompletableFuture.supplyAsync(() ->
//                employees.stream()
//                        .max(Comparator.comparingDouble(e -> e.salary))
//                        .map(e -> e.name)
//                        .orElse("None")
//        );
//
//        CompletableFuture<Long> totalCountFuture = CompletableFuture.supplyAsync(() ->
//                (long) employees.size()
//        );
//
//        // thenCombine - dono futures complete hone par combine karo
//        CompletableFuture<String> combinedFuture = topEarnerFuture.thenCombine(
//                totalCountFuture,
//                (name, count2) -> "Top Earner: " + name + " | Total Employees: " + count2
//        );
//
//        printFuture.join();                              // wait for print
//        System.out.println("  " + combinedFuture.join()); // blocking wait for combined result
//
//        System.out.println("\n=== Sab kaam khatam! Main thread exit. ===");
//    }
//}
