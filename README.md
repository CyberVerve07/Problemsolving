# 🚀 200 Days Java & Full-Stack Backend Learning Challenge

Welcome to my personal 200-day Java and backend development learning repository! This project serves as a dedicated space to track my daily coding practice, algorithms, object-oriented design, exception handling, design patterns, and Java Collections Framework.

---

## 📅 Challenge Overview
*   **Goal**: Master core Java, object-oriented design, collections framework, and full backend development from scratch.
*   **Duration**: 200 Days.
*   **Language**: Java.
*   **Key Focus Areas**:
    *   Java Basics & Flow Control (Loops, Conditionals)
    *   Data Structures (Arrays, String Manipulation)
    *   Object-Oriented Programming (OOP: Encapsulation, Inheritance, Polymorphism, Abstraction)
    *   Design Patterns (Singleton variations with Reflection, Serialization & Cloning defenses)
    *   Exception Handling (Try-Catch-Finally, Custom Exceptions, Throws)
    *   Java Collections Framework (List, ArrayList, Iterators, Collections utility)
    *   Backend Foundations (Database Integration, APIs, Frameworks, etc.)

---

## 📁 Repository Structure

The codebase is organized into clean, modular packages directly under the `src` folder:

*   **`Collections/`**: Java Collections Framework hands-on practice (`Demo1` to `Demo13`):
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
*   **`august/`**: Monthly progress tracking and exception handling:
    *   `august.augest11`: Deep Dive into `ArrayList` architecture (5 programs covering internal working, 1.5x resizing algorithm, memory shifting, performance optimization with `ensureCapacity()` & `trimToSize()`, and custom `MyArrayList<T>` implementation).
    *   Custom Exception Handling (`InsufficientBalanceException`, `UserAlreadyExist`)
    *   Nested try-catch blocks and try-with-resources
    *   Serialization & Deserialization (`Share`, `Main`)
    *   Marker Interfaces & Object Cloning (Shallow vs Deep Copying)
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
javac src/Collections/Demo1.java
```
Or to compile all files into the output (`out/`) directory:
```bash
javac -d out (Get-ChildItem -Recurse -Filter *.java src | Select-Object -ExpandProperty FullName)
```

### 2. Run a class
Run any compiled class containing a `main` method (e.g. `Demo1` inside `Collections`):
```bash
java -cp out Collections.Demo1
```

---

## 📈 Learning Log & Milestones

| Milestone | Target | Description | Status |
| :--- | :--- | :--- | :--- |
| **Phase 1** | Days 1 - 30 | Java Syntax, Loops, Arrays, and String Basics | ✅ Completed |
| **Phase 2** | Days 31 - 60 | OOP Principles (Encapsulation, Inheritance, Polymorphism, Abstraction, Design Patterns) | ✅ Completed |
| **Phase 3** | Days 61 - 90 | Exception Handling (Try-Catch, Custom Exceptions, Throw/Throws, Nested Try) | ✅ Completed |
| **Phase 4** | Days 91 - 120 | Java Collections Framework (`List`, `ArrayList`, `Iterator`, Sets, Maps) | 🔄 In Progress |
| **Phase 5** | Days 121 - 160 | Advanced Data Structures, File I/O & Streams API | ⏳ Upcoming |
| **Phase 6** | Days 161 - 200 | Database (SQL/NoSQL), REST APIs, Spring Boot & Deployment | ⏳ Upcoming |

---

> *"Consistency is the key. Keep coding every day!"* 💻🔥
