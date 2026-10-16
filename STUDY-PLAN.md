# 30-Day Core Java Interview Study Plan

This plan is designed around understanding and recall. Spend roughly 60–90 minutes per day: 25 minutes reading, 25 minutes explaining answers without notes, and 20–40 minutes coding/testing. If you have less time, do one topic block per day rather than rushing multiple blocks.

| Day | Focus | Output to prove understanding |
|---:|---|---|
| 1 | JDK/JRE/JVM, bytecode, compile/run path | Explain the journey from `.java` to running code in 60 seconds |
| 2 | Types, wrappers, casting, operators | Write examples of autoboxing, unboxing NPE, overflow, and casting |
| 3 | OOP pillars, IS-A/HAS-A, composition | Design a small payment-method interface and implementations |
| 4 | Overloading, overriding, method hiding, constructors | Predict output for superclass/subclass dispatch cases |
| 5 | Abstract class vs interface, default methods | Resolve a default-method conflict in code |
| 6 | `equals`, `hashCode`, `toString`, identity | Implement a correct value object and test it in HashSet/HashMap |
| 7 | String pool, immutability, copy semantics | Explain shallow vs deep copy with a mutable field |
| 8 | Exceptions and try-with-resources | Create a custom exception and preserve its cause |
| 9 | Generics, wildcards, PECS, erasure | Write producer/consumer methods and explain why invariance exists |
| 10 | Reflection, annotations, serialization | Create an object with `Constructor.newInstance()` and discuss risk |
| 11 | Collection hierarchy, List, Set, Queue | Choose a collection for five use cases and defend each choice |
| 12 | ArrayList, LinkedList, iterators, fail-fast | Explain time complexity and safe removal while iterating |
| 13 | HashMap, collisions, resize, tree bins | Draw bucket lookup and explain both equality methods |
| 14 | ConcurrentHashMap, WeakHashMap, LinkedHashMap, TreeMap | Compare concurrency, ordering, null rules, and key semantics |
| 15 | Functional interfaces, lambdas, method references | Replace an anonymous class with a lambda where valid |
| 16 | Streams: filter/map/flatMap/reduce/collect | Solve duplicate-character and grouping questions |
| 17 | Optional, collectors, `map` vs `flatMap` | Explain `orElse` vs `orElseGet` with a side-effect example |
| 18 | Thread lifecycle, Runnable/Callable, interruption | Implement a task and explain why `start()` differs from `run()` |
| 19 | synchronized, volatile, wait/notify | Explain one visibility bug and one race condition |
| 20 | Deadlock, starvation, race condition, JMM | Draw a deadlock and give a concrete prevention strategy |
| 21 | ExecutorService and ThreadPoolExecutor | Configure a bounded queue and explain rejection policy |
| 22 | Future, CompletableFuture, composition | Combine two asynchronous results and handle failure |
| 23 | ForkJoinPool, CAS, atomics, locks | Explain ABA and when a lock is clearer than CAS |
| 24 | ThreadLocal, thread dumps, virtual threads | Show ThreadLocal cleanup and explain virtual-thread use cases |
| 25 | Heap, stack, Metaspace, GC roots, memory leaks | Describe a realistic leak and how a heap dump finds it |
| 26 | GC, OOME, SOE, class loading, ClassLoader | Explain load/link/initialise and distinguish two class errors |
| 27 | Java 8/11/17/21, records, sealed, switch | Compare Java 17 and 21 without mislabelling preview features |
| 28 | API return types and traps | Recite return types for equals/hashCode/add/put/remove/compareTo/count |
| 29 | Coding set A | Solve strings, duplicates, frequency, list transformations without copying |
| 30 | Coding set B + mock interview | Answer 25 random questions aloud and write 2 solutions from scratch |

## Daily self-check

- Can I answer “what is it?” in 30–60 seconds?
- Can I explain internal working and the reason it exists?
- Can I write a small example without searching?
- Can I name a common wrong assumption or failure mode?
- Can I explain time/space complexity when applicable?

If any answer is no, mark that topic for revision. Completing the checklist is less valuable than being able to explain and implement the concepts correctly.
