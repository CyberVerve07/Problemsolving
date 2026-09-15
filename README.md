# 🚀 200 Days Java & Full-Stack Backend Learning Challenge

Welcome to my personal 200-day Java and backend development learning repository! This project serves as a dedicated space to track my daily coding practice, algorithms, object-oriented design, exception handling, design patterns, Java Collection Framework, and modern Java 8+ functional programming & Stream API.

---

## 📅 Challenge Overview
*   **Goal**: Master core Java, object-oriented design, collections framework, Java 8 Functional Programming & Stream API, and full backend development from scratch.
*   **Duration**: 200 Days.
*   **Language**: Java (JDK 8+ / Modern Java).
*   **Key Focus Areas**:
    *   Java Basics & Flow Control (Loops, Conditionals)
    *   Data Structures & Algorithms (Arrays, Strings, Frequency Maps, Sorting)
    *   Object-Oriented Programming (OOP: Encapsulation, Inheritance, Polymorphism, Abstraction)
    *   Design Patterns (Singleton variations with Reflection, Serialization & Cloning defenses)
    *   Exception Handling (Try-Catch-Finally, Custom Exceptions, Throws, Try-with-resources)
    *   Java Collection Framework (List, ArrayList internals, Iterators, Sets, Maps)
    *   ⚡ **Java 8 & Stream API (Current Focus)**:
        *   Lambda Expressions & Functional Interfaces
        *   Stream Pipeline: Intermediate (`filter`, `map`, `flatMap`, `sorted`, `distinct`, `peek`) & Terminal operations (`collect`, `reduce`, `count`, `findFirst`, `anyMatch`)
        *   Advanced Collectors: `groupingBy`, `partitioningBy`, `toMap`, `summarizingDouble`, `mapping`, downstream collectors
        *   Complex Real-World Aggregations (Employee salary analytics, Department rankings, Order processing, Top-K problems)
        *   Solving DSA & Interview Challenges using Streams
    *   Multi-Threading & Concurrency
    *   Observability & Enterprise Logging (Distributed tracing, Metrics, Logging best practices)
    *   Backend Foundations (Database Integration, APIs, Frameworks, Spring Boot)

---

## 📁 Repository Structure

The codebase is organized into clean, modular packages directly under the `src` folder:

*   🔥 **`Java8/` & `StreamPractice/` (Active Focus - Stream API Mastery)**:
    *   **`Java8.StreamApi`**: 50+ comprehensive Stream API programs covering:
        *   Filtering, transformation, mapping, sorting, and distinct filtering
        *   `findFirst`, `findAny`, `anyMatch`, `allMatch`, `noneMatch`
        *   Aggregations with `Collectors.groupingBy`, `Collectors.partitioningBy`, `Collectors.averagingDouble`
        *   Real-world domain models (`Employee`, `DeptEmployee`, `Transaction`, `AvgSalary`)
        *   Second highest salary, department-wise highest paid employee, finding duplicates
    *   **`Java8.StreamsInterview`**: High-frequency real-world interview challenges:
        *   `P1_TopEarnersPerDepartment`: Nested grouping & top earner extraction per department
        *   `P2_TopKWords`: Word frequency counting, custom sorting, and top-K selection
        *   `P3_FirstNonRepeatingChar`: LinkedHashMap / Stream frequency order resolution
        *   `P4_PartitioningSummary`: Statistical summaries by condition (`partitioningBy` + `summarizingInt`)
        *   `P5_ComplexOrderAggregation`: Multi-level order aggregation, status grouping, and revenue computation
    *   **`Java8.StreamDSA`**: Solving core DSA problems using functional streams:
        *   `CountFrequency`, `FindDuplicates`, `LongestString`, `MergetwoList`, `Reverse`, `SecondHighestSalary`, `SortList`
    *   **`Java8.Lambda`**: Functional interfaces, custom lambdas, method references, and consumer/supplier contracts.
    *   **`Java8.Order`**: E-commerce domain modeling with functional transformations.
    *   **`StreamPractice/`**: 35+ dedicated exercises (`Demo1` to `Demo28`, `HighestPaidEmployee`, etc.) applying Stream transformations to realistic business scenarios.

*   **`Collection/`**: Java Collection Framework hands-on practice (`Demo1` to `Demo13`):
    *   `List` interface & `ArrayList` dynamic resizing
    *   Iterating using `Iterator` & enhanced for-loops
    *   Bulk operations: `addAll`, `removeAll`, `clear`, `contains`, `set`, `get`

*   **`oops/`**: Comprehensive Object-Oriented Programming demonstrations:
    *   `oops.abstraction`: Abstract classes (`Animal`) and concrete implementations (`Dog`)
    *   `oops.encapsulation`: Private fields, getters, setters, and data protection (`Student`, `Details`)
    *   `oops.inheritance`: Class hierarchies and `super()` constructor chaining
    *   `oops.polymorphism`: Compile-time (Method Overloading) & Runtime (Method Overriding)
    *   `oops.student`, `oops.transport`, `oops.bankaccount`, `oops.phonepay`

*   **`DesignPattens/`**: Design Pattern implementations:
    *   `singleton`: Eager, Lazy, Synchronized, Double-Checked Locking (DCL), Bill Pugh, and Enum Singleton
    *   Defenses against Reflection attacks, Serialization breaks (`readResolve`), and Cloning attacks

*   **`august/`**: Deep dive modules and exception handling:
    *   `august.augest11`: Deep Dive into `ArrayList` architecture (5 programs covering internal working, 1.5x resizing algorithm, memory shifting, performance optimization with `ensureCapacity()` & `trimToSize()`, and custom `MyArrayList<T>` implementation).
    *   Custom Exception Handling (`InsufficientBalanceException`, `UserAlreadyExist`)
    *   Nested try-catch blocks and try-with-resources
    *   Serialization & Deserialization (`Share`, `Main`)
    *   Marker Interfaces & Object Cloning (Shallow vs Deep Copying)

*   **`MultiThreading/`**: Thread lifecycle, synchronization, concurrency, and thread safety demonstrations.
*   **`Loggings/`**: Production-grade observability patterns (Distributed Tracing, Metrics & Monitoring, Logging Best Practices).
*   **`revise/`**: Revision modules covering Java type system concepts:
    *   `UpCasting`, `DownCasting`, `AutoBoxing`, `IsARelationship`, `CovariantReturnType`, `MarkerInterface`, `CloneableInterface`
*   **`loops/`**: Core Java loops syntax and exercises (`Code01` to `Code21`).
*   **`array/`**: Array manipulation and search/sort exercises (`Code01` to `Code09`).
*   **`dsa/`**: Data Structures & Algorithms practice sets.
*   **`dailycode/`**: Daily coding exercises organized by month and date.

---

## 🛠️ How to Compile & Run

### 1. Compile the files
You can compile any individual Java file using the terminal:
```bash
javac src/Java8/StreamsInterview/P2_TopKWords.java
```
Or to compile all files into the output (`out/`) directory:
```powershell
javac -d out (Get-ChildItem -Recurse -Filter *.java src | Select-Object -ExpandProperty FullName)
```

### 2. Run a class
Run any compiled class containing a `main` method (e.g. `P2_TopKWords` inside `Java8.StreamsInterview`):
```bash
java -cp out Java8.StreamsInterview.P2_TopKWords
```

---

## 📈 Learning Log & Milestones

| Milestone | Target | Description | Status |
| :--- | :--- | :--- | :--- |
| **Phase 1** | Days 1 - 30 | Java Syntax, Loops, Arrays, and String Basics | ✅ Completed |
| **Phase 2** | Days 31 - 60 | OOP Principles (Encapsulation, Inheritance, Polymorphism, Abstraction, Design Patterns) | ✅ Completed |
| **Phase 3** | Days 61 - 90 | Exception Handling (Try-Catch, Custom Exceptions, Throw/Throws, Nested Try) | ✅ Completed |
| **Phase 4** | Days 91 - 120 | Java Collection Framework (`List`, `ArrayList`, `Iterator`, Sets, Maps) | ✅ Completed |
| **Phase 5** | Days 121 - 160 | **Java 8 Features & Stream API Mastery** (Lambdas, Collectors, Grouping, DSA & Interview Patterns) | 🔄 **In Progress** |
| **Phase 6** | Days 161 - 180 | Multi-Threading, Concurrency & Enterprise Observability / Logging | ⏳ Upcoming |
| **Phase 7** | Days 181 - 200 | Database (SQL/NoSQL), REST APIs, Spring Boot & Deployment | ⏳ Upcoming |

---

> *"Consistency is the key. Keep coding every day!"* 💻🔥

