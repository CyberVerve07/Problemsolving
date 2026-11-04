package MultiThreading;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ═══════════════════════════════════════════════════════════════════════════════
 *  P7 — Executor Framework: Complete Deep Dive
 * ═══════════════════════════════════════════════════════════════════════════════
 *
 *  ❓ WHY DID JAVA INTRODUCE THE EXECUTOR FRAMEWORK? (Java 5 — 2004)
 *  ─────────────────────────────────────────────────────────────────
 *  Pehle (pre-Java-5) developer ko manually Thread banane padte the:
 *
 *      new Thread(() -> doWork()).start();   ← Purana tarika (BAD ❌)
 *
 *  Isme problems the:
 *   1. THREAD CREATION COSTLY HAI → Har kaam ke liye naya thread banana expensive hai
 *      (Memory allocate hoti hai, OS me register hota hai — ~1MB per thread!)
 *   2. NO CONTROL   → Kitne threads chal rahe hain pata nahi
 *   3. NO REUSE     → Thread kaam karne ke baad destroy ho jata tha, reuse nahi hota
 *   4. NO RESULTS   → Runnable koi value return nahi kar sakta tha
 *   5. NO ERROR HANDLING → Thread crash ho to handle karna mushkil tha
 *
 *  Executor Framework ne solve kiya:
 *   ✅ Thread Pool  → Threads ko reuse karo, naye mat banao
 *   ✅ Control      → Max threads limit karo
 *   ✅ Future/Callable → Result aur exceptions handle karo
 *   ✅ Separation of Concern → "What to do" (task) aur "How to run" (executor) alag
 *
 *  HIERARCHY (Interface Chain):
 *  ─────────────────────────────
 *      Executor  (just one method: execute(Runnable))
 *          └── ExecutorService  (shutdown, submit, invokeAll, invokeAny...)
 *                  └── ScheduledExecutorService  (schedule, scheduleAtFixedRate...)
 *
 *  IMPLEMENTATIONS:
 *      ThreadPoolExecutor         ← Most powerful, fully configurable
 *      ScheduledThreadPoolExecutor← For delayed / periodic tasks
 *      ForkJoinPool               ← Work-stealing pool (P6 me dekha tha)
 *
 *  FACTORY CLASS — Executors:
 *      Executors.newFixedThreadPool(n)      → Fixed n threads
 *      Executors.newCachedThreadPool()      → Dynamic threads (create/destroy on demand)
 *      Executors.newSingleThreadExecutor()  → Exactly 1 thread, tasks queue me
 *      Executors.newScheduledThreadPool(n)  → Scheduled / periodic tasks
 *      Executors.newVirtualThreadPerTaskExecutor() → Virtual threads (Java 21+)
 * ═══════════════════════════════════════════════════════════════════════════════
 */
public class P7_ExecutorFrameworkDemo {

    // ═══════════════════════════════════════════════════════════════════════
    //  SECTION 1: Basic Executor — execute() with Runnable
    //  Runnable → void return, no exception throwing
    // ═══════════════════════════════════════════════════════════════════════
    static void demo1_BasicExecutor() throws InterruptedException {
        printHeader("DEMO 1: Basic Executor — FixedThreadPool + Runnable");

        /*
         *  newFixedThreadPool(3) → Exactly 3 threads banata hai pool me
         *  Agar 10 tasks submit karo to 3 chal rahe honge, baaki queue me wait karenge
         *  Thread kaam finish kare to queue se agla task utha leta hai (REUSE ✅)
         */
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 6; i++) {
            final int taskId = i;
            // execute() → fire-and-forget, koi result nahi milta
            executor.execute(() -> {
                System.out.printf("  [Task-%d] Running on: %s%n", taskId, Thread.currentThread().getName());
                sleep(500); // simulate work
                System.out.printf("  [Task-%d] Done ✓%n", taskId);
            });
        }

        /*
         *  IMPORTANT: shutdown() call karna ZARURI hai
         *  shutdown()     → Naye tasks accept karna band karo, running/queued tasks complete karo
         *  shutdownNow()  → Sab kuch immediately stop karne ki koshish karo (harsh)
         *  awaitTermination() → Main thread wait kare jab tak pool band na ho jaye
         */
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("  Pool shutdown complete.\n");
    }

    // ═══════════════════════════════════════════════════════════════════════
    //  SECTION 2: Callable + Future
    //  Callable → Value return kar sakta hai + Exception throw kar sakta hai
    //  Future   → "Promise" of a result — result baad me milega
    // ═══════════════════════════════════════════════════════════════════════
    static void demo2_CallableAndFuture() throws Exception {
        printHeader("DEMO 2: Callable + Future — Get Results from Threads");

        /*
         *  PROBLEM WITH RUNNABLE:
         *  Runnable.run() → void return, koi cheez return nahi kar sakta
         *
         *  SOLUTION: Callable<V>
         *  Callable.call() → V type return karta hai + checked exception throw kar sakta hai
         *
         *  submit(callable) → Future<V> return karta hai
         *  Future<V>  → Ek "ticket" hai jisse baad me result le sakte ho
         */
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Callable banao — price fetch karne ka kaam simulate karenge
        Callable<Double> fetchPriceTask = () -> {
            System.out.println("  Fetching price from server... (Thread: " + Thread.currentThread().getName() + ")");
            sleep(1000); // server se data aane me time lagta hai
            return 99.99; // price return karo
        };

        // submit() → task pool me daal do, Future milta hai turant
        Future<Double> futurePrice = executor.submit(fetchPriceTask);

        // Yahan kuch aur kaam karo jab price fetch ho raha ho
        System.out.println("  [Main] Price fetch ho raha hai, meanwhile main kuch aur kar raha hoon...");

        /*
         *  Future ke methods:
         *  get()          → Result lo (BLOCKS until result available) ← BLOCKING CALL ⚠️
         *  get(t, unit)   → Timeout ke saath result lo — TimeoutException agar late hoe
         *  isDone()       → true agar task complete ho gaya (non-blocking check)
         *  isCancelled()  → true agar task cancel hua
         *  cancel(true)   → Task cancel karo (agar chal raha hai to interrupt karo)
         */
        System.out.println("  [Main] isDone() before get(): " + futurePrice.isDone());
        double price = futurePrice.get(); // ← blocks here until result ready
        System.out.println("  [Main] isDone() after  get(): " + futurePrice.isDone());
        System.out.printf("  [Main] Price received: %.2f%n%n", price);

        // ── Multiple Futures ───────────────────────────────────────────────
        System.out.println("  --- Multiple Futures (parallel tasks) ---");

        List<Callable<String>> tasks = Arrays.asList(
                () -> { sleep(300); return "Result from DB query"; },
                () -> { sleep(200); return "Result from Cache";    },
                () -> { sleep(400); return "Result from API call"; }
        );

        // invokeAll() → Saare tasks submit karo, saare complete hone ka wait karo
        // Returns List<Future<String>> — same order as input list
        List<Future<String>> results = executor.invokeAll(tasks);

        System.out.println("  All tasks done:");
        for (Future<String> f : results) {
            System.out.println("    → " + f.get());
        }

        // invokeAny() → Jo sabse pehle complete ho, usi ka result lo
        String fastest = executor.invokeAny(tasks);
        System.out.println("  Fastest result (invokeAny): " + fastest);

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
    }

    // ═══════════════════════════════════════════════════════════════════════
    //  SECTION 3: Future ki LIMITATIONS → WHY CompletableFuture?
    // ═══════════════════════════════════════════════════════════════════════
    static void demo3_FutureLimitations() {
        printHeader("DEMO 3: Future ki Limitations (Sirf samajhne ke liye)");

        /*
         *  FUTURE KI PROBLEMS:
         *  ─────────────────────
         *  1. BLOCKING get()    → future.get() karo to main thread RUKO JATA HAI
         *                         Non-blocking callback nahi de sakte
         *
         *  2. NO CHAINING       → Future complete hone ke baad automatically
         *                         koi next step trigger nahi hoti
         *                         e.g., "jab price mile, to discount calculate karo"
         *                         → Yeh Future se nahi hota
         *
         *  3. NO COMBINING      → Do Futures ka result combine nahi kar sakte easily
         *                         e.g., future1.result + future2.result ek saath nahi
         *
         *  4. NO ERROR HANDLING → Exception sirf get() ke time milti hai, pehle nahi
         *
         *  5. CANNOT COMPLETE MANUALLY → Bahar se "yeh done hai" nahi bol sakte
         *
         *  SOLUTION: CompletableFuture (Java 8) — demo agle section me
         */

        System.out.println("  Future Limitations:");
        System.out.println("    ❌ get() blocks the calling thread");
        System.out.println("    ❌ No way to chain tasks without blocking");
        System.out.println("    ❌ Cannot combine multiple futures");
        System.out.println("    ❌ No built-in error recovery");
        System.out.println("    ✅ SOLUTION → CompletableFuture (Java 8+)\n");
    }

    // ═══════════════════════════════════════════════════════════════════════
    //  SECTION 4: CompletableFuture — The Modern Way (Java 8+)
    //  Non-blocking, chainable, combinable async programming
    // ═══════════════════════════════════════════════════════════════════════
    static void demo4_CompletableFuture() throws Exception {
        printHeader("DEMO 4: CompletableFuture — Non-Blocking Async Pipeline");

        /*
         *  CompletableFuture<V> implements both:
         *   → Future<V>          (backward compatible)
         *   → CompletionStage<V> (new chaining API)
         *
         *  KEY CREATION METHODS:
         *   supplyAsync(Supplier)  → Background me kaam karo, result return karo
         *   runAsync(Runnable)     → Background me kaam karo, void (no result)
         *   completedFuture(val)   → Already complete — testing ke liye useful
         */

        // ── Example 1: supplyAsync + thenApply chain ───────────────────────
        System.out.println("  [Example 1] Price → Discount → Final Price Pipeline");

        CompletableFuture<Double> pipeline = CompletableFuture
                // Step 1: DB se original price fetch karo (async)
                .supplyAsync(() -> {
                    System.out.println("    Step 1: Fetching original price... (Thread: "
                            + Thread.currentThread().getName() + ")");
                    sleep(500);
                    return 1000.0; // original price
                })
                // Step 2: Discount calculate karo — AUTOMATICALLY runs when Step 1 done
                // thenApply() → ek value lo, transform karo, return karo (non-blocking chain)
                .thenApply(originalPrice -> {
                    System.out.println("    Step 2: Calculating 20% discount... (Thread: "
                            + Thread.currentThread().getName() + ")");
                    return originalPrice * 0.80; // 20% off
                })
                // Step 3: Tax add karo
                .thenApply(discountedPrice -> {
                    System.out.println("    Step 3: Adding 18% GST... (Thread: "
                            + Thread.currentThread().getName() + ")");
                    return discountedPrice * 1.18; // 18% GST
                });

        // Jab tak pipeline chal rahi hai, kuch aur karo
        System.out.println("    [Main] Pipeline chal rahi hai, main free hoon...");

        // thenAccept → result consume karo, return kuch nahi (void callback)
        pipeline.thenAccept(finalPrice ->
                System.out.printf("    Final Price after discount + GST: %.2f%n", finalPrice));

        // get() sirf wait ke liye (ya .join() bhi use kar sakte ho)
        pipeline.get();

        // ── Example 2: thenCompose (flatMap) ──────────────────────────────
        System.out.println("\n  [Example 2] thenCompose — Dependent Async Calls");
        /*
         *  thenCompose → Jab next step BHED aur khud ek CompletableFuture return kare
         *                (flatMap jaise — nested futures ko flatten karta hai)
         *  thenApply   → Simple transform (like map)
         *  thenCompose → Async transform jo future return kare (like flatMap)
         */
        CompletableFuture<String> orderFlow = CompletableFuture
                .supplyAsync(() -> { sleep(300); return "user_123"; })   // userId fetch
                .thenCompose(userId ->
                        CompletableFuture.supplyAsync(() -> {             // userId se order fetch
                            sleep(300);
                            return "Order #456 for " + userId;
                        }));

        System.out.println("    " + orderFlow.get());

        // ── Example 3: thenCombine — Two independent tasks combine ─────────
        System.out.println("\n  [Example 3] thenCombine — Merge Two Parallel Results");
        /*
         *  thenCombine → Do INDEPENDENT CompletableFutures parallel me chalao
         *                aur dono ke results ek saath combine karo
         *                (invokeAll jaisa but non-blocking aur chainable)
         */
        CompletableFuture<Double> priceFromDB    = CompletableFuture.supplyAsync(() -> { sleep(400); return 500.0; });
        CompletableFuture<Double> taxFromTaxServ = CompletableFuture.supplyAsync(() -> { sleep(300); return 90.0;  });

        // Jab DONO complete hon to combine karo
        double totalBill = priceFromDB
                .thenCombine(taxFromTaxServ, Double::sum) // price + tax
                .get();
        System.out.printf("    Price: 500.0 + Tax: 90.0 = Total: %.1f%n", totalBill);

        // ── Example 4: Error Handling ──────────────────────────────────────
        System.out.println("\n  [Example 4] Error Handling — exceptionally()");
        /*
         *  exceptionally → Agar koi step fail hoe to fallback value provide karo
         *                   (try-catch jaisa but async pipeline me)
         *  handle(result, ex) → Dono success aur failure handle karo ek saath
         */
        CompletableFuture<String> safeResult = CompletableFuture
                .supplyAsync(() -> {
                    if (true) throw new RuntimeException("DB connection failed!");
                    return "data";
                })
                .exceptionally(ex -> {
                    System.out.println("    Exception caught: " + ex.getMessage());
                    return "DEFAULT_DATA"; // fallback
                });

        System.out.println("    Result with fallback: " + safeResult.get());

        // ── Example 5: allOf / anyOf ───────────────────────────────────────
        System.out.println("\n  [Example 5] allOf vs anyOf");
        /*
         *  allOf(cf1, cf2, cf3) → Saare futures complete hone ka wait karo
         *  anyOf(cf1, cf2, cf3) → Jo bhi sabse pehle complete ho, uska result lo
         */
        CompletableFuture<String> api1 = CompletableFuture.supplyAsync(() -> { sleep(600); return "API1 Result"; });
        CompletableFuture<String> api2 = CompletableFuture.supplyAsync(() -> { sleep(300); return "API2 Result"; });
        CompletableFuture<String> api3 = CompletableFuture.supplyAsync(() -> { sleep(500); return "API3 Result"; });

        // anyOf → Race condition — jo pehle aaya wo lelo
        String fastest = (String) CompletableFuture.anyOf(api1, api2, api3).get();
        System.out.println("    anyOf — Fastest: " + fastest);

        // allOf → Sab ka wait karo (note: allOf returns Void, isliye thenApply se kaam lo)
        CompletableFuture<Void> allDone = CompletableFuture.allOf(api1, api2, api3);
        allDone.get(); // wait for all
        System.out.println("    allOf — All done: " + api1.get() + " | " + api2.get() + " | " + api3.get());
    }

    // ═══════════════════════════════════════════════════════════════════════
    //  SECTION 5: ThreadPoolExecutor — Manual Configuration
    //  Jab Executors factory se zyada control chahiye
    // ═══════════════════════════════════════════════════════════════════════
    static void demo5_ThreadPoolExecutor() throws InterruptedException {
        printHeader("DEMO 5: ThreadPoolExecutor — Full Control");

        /*
         *  ThreadPoolExecutor constructor:
         *  ─────────────────────────────────────────────────────────────────
         *  new ThreadPoolExecutor(
         *      corePoolSize,       ← Min threads jo hamesha alive rahein
         *      maximumPoolSize,    ← Max threads pool me (jab queue full ho)
         *      keepAliveTime,      ← Extra (non-core) threads kitne time baad destroy hon
         *      timeUnit,           ← keepAliveTime ki unit
         *      workQueue,          ← Queue jahan tasks wait karte hain
         *      threadFactory,      ← Custom thread factory (optional)
         *      rejectedHandler     ← Kya karo agar pool full + queue full ho jaye
         *  )
         *
         *  QUEUE TYPES:
         *  ─────────────────────────────────────────────────────────────────
         *  LinkedBlockingQueue()       → Unbounded queue (careful! OOM possible)
         *  ArrayBlockingQueue(n)       → Bounded queue (n tasks max)
         *  SynchronousQueue()          → No queue — task seedha thread ko diya
         *  PriorityBlockingQueue()     → Priority ke hisaab se tasks execute
         *
         *  REJECTION POLICIES (jab pool + queue dono full):
         *  ─────────────────────────────────────────────────────────────────
         *  AbortPolicy         → Default: RejectedExecutionException throw karo
         *  CallerRunsPolicy    → Caller thread khud hi task chalaye (backpressure)
         *  DiscardPolicy       → Task silently drop karo
         *  DiscardOldestPolicy → Queue ka purana task hatao, naya daalo
         */
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                2,                              // corePoolSize: hamesha 2 threads alive
                4,                              // maximumPoolSize: max 4 threads
                30, TimeUnit.SECONDS,           // idle threads 30s baad destroy
                new ArrayBlockingQueue<>(3),    // max 3 tasks queue me wait kar sakti
                new ThreadPoolExecutor.CallerRunsPolicy() // queue full → caller khud kare
        );

        AtomicInteger completedTasks = new AtomicInteger(0);

        // 8 tasks submit karo — pool 4 max, queue 3 → 7 fit honge, 8th CallerRuns se
        for (int i = 1; i <= 8; i++) {
            final int id = i;
            pool.execute(() -> {
                System.out.printf("  [Task-%d] on %s | Active: %d, Queue: %d%n",
                        id,
                        Thread.currentThread().getName(),
                        pool.getActiveCount(),
                        pool.getQueue().size());
                sleep(300);
                completedTasks.incrementAndGet();
            });
        }

        pool.shutdown();
        pool.awaitTermination(15, TimeUnit.SECONDS);
        System.out.printf("  Completed tasks: %d%n%n", completedTasks.get());
    }

    // ═══════════════════════════════════════════════════════════════════════
    //  SECTION 6: ScheduledExecutorService — Delayed & Periodic Tasks
    // ═══════════════════════════════════════════════════════════════════════
    static void demo6_ScheduledExecutor() throws InterruptedException {
        printHeader("DEMO 6: ScheduledExecutorService — Delay aur Repeat");

        /*
         *  ScheduledExecutorService ke methods:
         *  ─────────────────────────────────────────────────────────────────
         *  schedule(task, delay, unit)
         *      → Ek baar, delay ke baad run karo
         *      → Like: "5 second baad email bhejo"
         *
         *  scheduleAtFixedRate(task, initialDelay, period, unit)
         *      → Har `period` seconds pe run karo (task start time se count)
         *      → Like: "Har minute heartbeat check karo"
         *
         *  scheduleWithFixedDelay(task, initialDelay, delay, unit)
         *      → Task finish hone ke BAAD `delay` wait karo, fir run karo
         *      → Task slow ho to automatically slow ho jata hai
         */
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        System.out.println("  Scheduler started at: " + now());

        // One-time delayed task
        scheduler.schedule(
                () -> System.out.println("  [One-Time] Ran after 1s delay at: " + now()),
                1, TimeUnit.SECONDS
        );

        // Fixed Rate — task har 500ms pe run karo (3 times then cancel)
        AtomicInteger counter = new AtomicInteger(0);
        ScheduledFuture<?> repeating = scheduler.scheduleAtFixedRate(
                () -> {
                    int count = counter.incrementAndGet();
                    System.out.println("  [Fixed-Rate #" + count + "] Tick at: " + now());
                },
                500,  // initial delay
                500,  // period
                TimeUnit.MILLISECONDS
        );

        // 2 seconds baad repeating task cancel karo
        scheduler.schedule(() -> {
            repeating.cancel(false); // false = current execution finish hone do
            System.out.println("  [Scheduler] Repeating task cancelled.");
        }, 2, TimeUnit.SECONDS);

        Thread.sleep(3000); // wait to see output
        scheduler.shutdown();
        System.out.println();
    }

    // ═══════════════════════════════════════════════════════════════════════
    //  SECTION 7: Virtual Threads (Java 21 — Project Loom)
    //  ─────────────────────────────────────────────────────────────────────
    //  WHY VIRTUAL THREADS?
    //  Traditional "Platform Threads" OS threads se map hote hain:
    //    - Ek Platform Thread = Ek OS Thread
    //    - OS Thread ~1MB stack memory leta hai
    //    - System pe max ~few thousand threads ho sakte hain
    //    - Thread block ho (I/O wait) to OS thread bhi block → CPU waste
    //
    //  Virtual Threads (Project Loom):
    //    - JVM manage karta hai, OS nahi
    //    - Bahut lightweight: ~few KB memory
    //    - MILLIONS of virtual threads ek saath chal sakte hain
    //    - I/O pe block ho to JVM automatically carrier thread release karta hai
    //    - Dusra virtual thread us carrier thread pe chal sakta hai
    //
    //  BEST FOR: I/O bound tasks (DB, HTTP, File)
    //  NOT FOR:  CPU intensive tasks (ForkJoin zyada suitable hai)
    // ═══════════════════════════════════════════════════════════════════════
    static void demo7_VirtualThreads() throws Exception {
        printHeader("DEMO 7: Virtual Threads (Java 21+) — Project Loom");

        // ── Method 1: Thread.ofVirtual() ──────────────────────────────────
        System.out.println("  [Method 1] Thread.ofVirtual().start()");
        Thread vt1 = Thread.ofVirtual()
                .name("my-virtual-thread")
                .start(() -> {
                    System.out.println("    Running on virtual thread: " + Thread.currentThread());
                    System.out.println("    Is Virtual? " + Thread.currentThread().isVirtual());
                });
        vt1.join(); // wait for it to finish

        // ── Method 2: Thread.startVirtualThread(runnable) ─────────────────
        System.out.println("\n  [Method 2] Thread.startVirtualThread()");
        Thread vt2 = Thread.startVirtualThread(() ->
                System.out.println("    Quick virtual thread on: " + Thread.currentThread().getName()));
        vt2.join();

        // ── Method 3: ExecutorService with Virtual Thread Per Task ─────────
        System.out.println("\n  [Method 3] Executors.newVirtualThreadPerTaskExecutor()");
        /*
         *  newVirtualThreadPerTaskExecutor() → Har task ke liye ek nayi virtual thread
         *  Traditional thread pools se ALAG:
         *   - Platform pool: N threads fix, tasks queue me wait karte hain
         *   - Virtual pool: Unlimited tasks, har ek apni virtual thread pe — no waiting!
         *
         *  Use case: Web server me har HTTP request ke liye ek virtual thread
         *            Spring Boot 3.2+ me Virtual Threads enable ho sakte hain one line se
         */
        try (ExecutorService virtualPool = Executors.newVirtualThreadPerTaskExecutor()) {
            List<Future<String>> futures = new java.util.ArrayList<>();

            for (int i = 1; i <= 5; i++) {
                final int id = i;
                Future<String> f = virtualPool.submit(() -> {
                    sleep(200); // I/O wait simulate
                    return String.format("Task-%d done on [%s] isVirtual=%b",
                            id,
                            Thread.currentThread().getName(),
                            Thread.currentThread().isVirtual());
                });
                futures.add(f);
            }

            System.out.println("  Results:");
            for (Future<String> f : futures) {
                System.out.println("    " + f.get());
            }
        }

        // ── Comparison: Platform vs Virtual Thread Count ───────────────────
        System.out.println("\n  [Comparison] Creating 1000 Virtual Threads:");
        long start = System.currentTimeMillis();
        Thread[] vThreads = new Thread[1000];
        for (int i = 0; i < 1000; i++) {
            vThreads[i] = Thread.ofVirtual().start(() -> sleep(100));
        }
        for (Thread t : vThreads) t.join();
        long elapsed = System.currentTimeMillis() - start;
        System.out.println("    1000 virtual threads done in: " + elapsed + "ms");
        System.out.println("    (1000 platform threads would use ~1GB RAM, virtual use ~MBs)\n");
    }

    // ═══════════════════════════════════════════════════════════════════════
    //  QUICK REFERENCE — FUTURE vs COMPLETABLE FUTURE
    // ═══════════════════════════════════════════════════════════════════════
    static void printFutureVsCompletableFuture() {
        printHeader("QUICK REFERENCE: Future vs CompletableFuture");

        System.out.println("""
                  Feature                  │ Future              │ CompletableFuture
                  ─────────────────────────┼─────────────────────┼──────────────────────────
                  Introduced               │ Java 5              │ Java 8
                  Result retrieval         │ get() — BLOCKING    │ thenAccept/Apply/non-blocking
                  Task chaining            │ ❌ Not possible      │ ✅ thenApply, thenCompose
                  Combine multiple         │ ❌ Manual only       │ ✅ thenCombine, allOf, anyOf
                  Error handling           │ ❌ Only in get()     │ ✅ exceptionally, handle
                  Manual completion        │ ❌ Cannot            │ ✅ complete(value)
                  Cancellation             │ ✅ cancel()          │ ✅ cancel()
                  Async callback           │ ❌ No                │ ✅ Yes (non-blocking pipeline)
                  Best for                 │ Simple one-off task │ Complex async pipelines
                 \s""");
    }

    // ═══════════════════════════════════════════════════════════════════════
    //  QUICK REFERENCE — EXECUTOR SERVICE TYPES
    // ═══════════════════════════════════════════════════════════════════════
    static void printExecutorTypes() {
        printHeader("QUICK REFERENCE: Executor Service Types");

        System.out.println("""
                  Executor Type                        │ Use Case
                  ─────────────────────────────────────┼────────────────────────────────────
                  newFixedThreadPool(n)                 │ CPU-bound tasks, known load
                  newCachedThreadPool()                 │ Short-lived, high-volume I/O tasks
                  newSingleThreadExecutor()             │ Tasks must run SEQUENTIALLY (1 by 1)
                  newScheduledThreadPool(n)             │ Delay/periodic tasks (cron-like)
                  newVirtualThreadPerTaskExecutor()     │ Massive concurrency, I/O heavy (J21)
                  ForkJoinPool.commonPool()             │ Parallel recursive (CPU intensive)
                  new ThreadPoolExecutor(...)           │ Custom control over all parameters
                 \s""");
    }

    // ═══════════════════════════════════════════════════════════════════════
    //  MAIN
    // ═══════════════════════════════════════════════════════════════════════
    public static void main(String[] args) throws Exception {

        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║      Java Executor Framework — Complete Deep Dive            ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝\n");

        demo1_BasicExecutor();
        demo2_CallableAndFuture();
        demo3_FutureLimitations();
        demo4_CompletableFuture();
        demo5_ThreadPoolExecutor();
        demo6_ScheduledExecutor();
        demo7_VirtualThreads();
        printFutureVsCompletableFuture();
        printExecutorTypes();

        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║                 ALL DEMOS COMPLETE ✅                        ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
    }

    // ═══════════════════════════════════════════════════════════════════════
    //  HELPER METHODS
    // ═══════════════════════════════════════════════════════════════════════

    private static void sleep(long ms) {
        try { Thread.sleep(ms); }
        catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }

    private static void printHeader(String title) {
        System.out.println("┌─────────────────────────────────────────────────────────────┐");
        System.out.printf( "│  %-60s│%n", title);
        System.out.println("└─────────────────────────────────────────────────────────────┘");
    }

    private static String now() {
        return java.time.LocalTime.now().withNano(0).toString();
    }
}

