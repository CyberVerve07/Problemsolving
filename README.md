# Core Java Interview Prep — 378 Questions & Answers

A focused, GitHub-ready Core Java interview repository, created from the learner-provided interview dump and expanded with additional fundamentals, internal-working questions, code examples, and references to official Java documentation.

**378 numbered interview questions with answers**, covering beginner fundamentals through advanced JVM and concurrency topics. The single-file guide is the complete reference; `docs/` splits it into smaller study-friendly chapters.

## Start here

- **[Open the complete guide](core-java-interview-questions-answers.md)** — all questions, answers, code samples, interview traps, and source links in one Markdown file.
- **[30-day study plan](STUDY-PLAN.md)** — a practical order for learning and revision.
- **Chapter files:** browse the `docs/` directory for smaller topic-specific sections.

## What is covered?

| Area | Main concepts |
|---|---|
| Java execution | JDK/JRE/JVM, bytecode, compiler, process vs thread, classpath |
| Language & OOP | Types, casting, constructors, object creation, overloading, overriding, method hiding, IS-A/HAS-A, interfaces, abstraction |
| Object model | `equals()`/`hashCode()` contracts, String pool, immutability, cloning, `toString()` |
| Exceptions & type system | Checked/unchecked exceptions, try-with-resources, generics, wildcards, PECS, erasure |
| Reflection & serialization | Class metadata, `Constructor.newInstance()`, annotations, serialization risks |
| Collections | List/Set/Map APIs, ArrayList, LinkedList, HashSet, TreeSet, fail-fast, iterators, return types |
| Map internals | HashMap collisions/resize/tree bins, ConcurrentHashMap, WeakHashMap, LinkedHashMap, TreeMap |
| Java functional APIs | Lambdas, method references, Stream operations, `map` vs `flatMap`, collectors, Optional |
| Concurrency | Thread states, synchronization, visibility, race conditions, deadlocks, interruption, thread safety |
| Executors & advanced concurrency | ThreadPoolExecutor, queue/rejection policies, Future, CompletableFuture, ForkJoinPool, CAS, ThreadLocal, locks, virtual threads |
| JVM internals | Stack/heap/Metaspace, GC, leaks, GC roots, OOME, class loaders, JIT, class initialization |
| Modern Java | Java 8/11/17/21, records, sealed types, switch expressions, virtual threads, sequenced collections |
| Interview practice | API return-type traps and Core Java coding solutions |

## How to study this repo

1. Read one answer and explain it out loud without looking.
2. Recreate every code sample in a small Java project; do not only memorise the result.
3. For internals, answer three follow-ups: **how it works, why it exists, and what can go wrong**.
4. For concurrent code, explain the correctness guarantee—not just that a class is “thread-safe.”
5. Mark uncertain topics and revisit them after 48 hours. Aim for recall, not passive reading.

## Scope decisions

The code samples are independent interview snippets; some intentionally use illustrative types such as `Employee` or variables such as `values`, and may need their imports/domain classes added to compile in your own project.

The supplied list mixes Core Java with Spring Boot, Kafka, SQL, JPA, AWS, Docker, and microservices. This repository keeps the main guide focused on the Java language, standard library, JVM, and concurrency. The omitted topics are listed in Chapter 19 so they can become separate repositories rather than muddying the Core Java study scope.

## Research and accuracy notes

- The supplied interview dump was the primary source for deciding which concepts needed extra coverage.
- Public LinkedIn interview discussions were used as **topic-selection signals**, especially for JVM internals, HashMap/ConcurrentHashMap, Java Memory Model, thread pools, CAS, and virtual threads.
- Official Java API documentation, the Java Language Specification, and OpenJDK JEPs are the authority for technical behaviour; LinkedIn posts are not treated as specifications.
- Implementation-specific details are labelled as such. JVM vendor, release, flags, and APIs can change behaviour; verify the documentation for the Java version used in your interview.
- This guide is a study resource, not a guarantee that every interviewer will ask these questions.

## Main sources

- [Java SE 21 API docs](https://docs.oracle.com/en/java/javase/21/docs/api/)
- [Java Language Specification, Java SE 21](https://docs.oracle.com/javase/specs/jls/se21/html/)
- [JEP 444 — Virtual Threads](https://openjdk.org/jeps/444)
- [LinkedIn: JVM, multithreading, collections, OOP, exceptions](https://www.linkedin.com/posts/java-by-madhu-vundavalli_sharing-real-core-java-questions-if-you-activity-7415779330338861056-BLwZ)
- [LinkedIn: senior Java multithreading interview topics](https://www.linkedin.com/posts/bhanu-prakash-5637a2183_java-multithreading-interview-questions-senior-activity-7427235268392534016-Ir0m)

## Suggested repository name

`core-java-interview-prep`
