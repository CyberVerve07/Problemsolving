# 🚀 Singleton Design Pattern - Ultimate Interview & Production Guide

> **Pattern Category:** Creational Design Pattern  
> **Key Objective:** Ensure that a class has **only one instance** throughout the application lifecycle and provide a **global point of access** to that instance.

---

## 📌 Table of Contents
1. [Overview & Real-World Use Cases](#1-overview--real-world-use-cases)
2. [Why Do We Need Singleton?](#2-why-do-we-need-singleton)
3. [6 Ways to Implement Singleton in Java](#3-6-ways-to-implement-singleton-in-java)
   - [3.1 Eager Initialization](#31-eager-initialization)
   - [3.2 Lazy Initialization (Non-Thread-Safe)](#32-lazy-initialization-non-thread-safe)
   - [3.3 Thread-Safe Synchronized Method](#33-thread-safe-synchronized-method)
   - [3.4 Double-Checked Locking (DCL) + volatile](#34-double-checked-locking-dcl--volatile)
   - [3.5 Bill Pugh Static Inner Helper Class](#35-bill-pugh-static-inner-helper-class)
   - [3.6 Enum Singleton (Effective Java Recommendation)](#36-enum-singleton-effective-java-recommendation)
4. [🔥 Crucial Interview Edge Cases & Attacks](#-crucial-interview-edge-cases--attacks)
   - [Attack 1: Reflection Attack & Defense](#attack-1-reflection-attack--defense)
   - [Attack 2: Serialization/Deserialization Attack & Defense](#attack-2-serializationdeserialization-attack--defense)
   - [Attack 3: Cloning Attack & Defense](#attack-3-cloning-attack--defense)
5. [🧠 Deep Dive: Why is `volatile` mandatory in Double-Checked Locking?](#-deep-dive-why-is-volatile-mandatory-in-double-checked-locking)
6. [💡 Top Interview Questions & Quick Revisions](#-top-interview-questions--quick-revisions)

---

## 1. Overview & Real-World Use Cases

Singleton is used when exactly one object is needed to coordinate actions across the system.

### 🏢 Real-World Examples in Java / Spring Ecosystem:
1. **`java.lang.Runtime#getRuntime()`**: Allows Java application to interface with the JVM environment.
2. **`java.awt.Desktop#getDesktop()`**: Accesses desktop environment.
3. **Database Connection Pools / Thread Pools**: Manages shared resources (`HikariPool`, `ExecutorService`).
4. **Loggers (SLF4J, Log4j)**: Single logger object to append logs across threads without conflicting file handles.
5. **Spring Framework Beans**: Default scope of Spring beans is `@Scope("singleton")`.

---

## 2. Why Do We Need Singleton?

- **Memory Efficiency**: Avoids creating duplicate heavy objects (e.g., Database connections, Cache objects).
- **Global State Control**: Ensures consistent configuration across different modules.
- **Resource Management**: Prevents resource exhaustion (e.g., restricting max concurrent connections to a database).

---

## 3. 6 Ways to Implement Singleton in Java

| Approach | Lazy Loading? | Thread-Safe? | Performance | Complexity | Recommended? |
| :--- | :---: | :---: | :---: | :---: | :---: |
| **1. Eager Initialization** | ❌ | ✅ | High | Simple | ⚠️ Only for light objects |
| **2. Lazy Initialization** | ✅ | ❌ | High | Simple | ❌ No (Race condition) |
| **3. Synchronized Method** | ✅ | ✅ | Low (Bottleneck) | Simple | ❌ No (Slow) |
| **4. Double-Checked Locking (DCL)** | ✅ | ✅ | High | Medium | ✅ Yes (Industry Standard) |
| **5. Bill Pugh Helper** | ✅ | ✅ | High | Simple | ✅ Yes (Clean & Safe) |
| **6. Enum Singleton** | ❌ (Loaded on Enum access) | ✅ | High | Extremely Simple | ⭐ **BEST (Effective Java)** |

---

### 3.1 Eager Initialization
Instance is initialized at the time of class loading.

```java
public class EagerSingleton {
    private static final EagerSingleton INSTANCE = new EagerSingleton();

    private EagerSingleton() {}

    public static EagerSingleton getInstance() {
        return INSTANCE;
    }
}
```
- **Pros:** Thread-safe by JVM class loader guarantee.
- **Cons:** Instance created even if application never uses it.

---

### 3.2 Lazy Initialization (Non-Thread-Safe)
Instance is created on demand when `getInstance()` is called for the first time.

```java
public class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {}

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton(); // Race condition in multi-threaded environment!
        }
        return instance;
    }
}
```
- **Pros:** Lazy initialization saves memory.
- **Cons:** **NOT Thread-Safe!** Multiple threads can create separate instances simultaneously.

---

### 3.3 Thread-Safe Synchronized Method
Adds `synchronized` to the `getInstance()` method.

```java
public class SynchronizedSingleton {
    private static SynchronizedSingleton instance;

    private SynchronizedSingleton() {}

    public static synchronized SynchronizedSingleton getInstance() {
        if (instance == null) {
            instance = new SynchronizedSingleton();
        }
        return instance;
    }
}
```
- **Pros:** Thread-safe and lazy initialized.
- **Cons:** **Performance Bottleneck!** `synchronized` locks the method for EVERY read call, even after instance creation.

---

### 3.4 Double-Checked Locking (DCL) + `volatile`
Industry standard for lazy thread-safe singleton initialization. Synchronizes ONLY when instance is `null`.

```java
public class DoubleCheckedLockingSingleton implements Serializable, Cloneable {
    private static volatile DoubleCheckedLockingSingleton instance;

    private DoubleCheckedLockingSingleton() {
        // Reflection Defense
        if (instance != null) {
            throw new RuntimeException("Instance already exists!");
        }
    }

    public static DoubleCheckedLockingSingleton getInstance() {
        if (instance == null) { // 1st Check (No Lock Overhead)
            synchronized (DoubleCheckedLockingSingleton.class) {
                if (instance == null) { // 2nd Check (Inside Lock)
                    instance = new DoubleCheckedLockingSingleton();
                }
            }
        }
        return instance;
    }

    // Serialization Defense
    protected Object readResolve() {
        return getInstance();
    }

    // Cloning Defense
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning not allowed!");
    }
}
```

---

### 3.5 Bill Pugh Static Inner Helper Class
Uses JVM classloading mechanism to achieve lazy loading without explicit synchronization overhead.

```java
public class BillPughSingleton {
    private BillPughSingleton() {}

    // Static inner class is NOT loaded into memory until getInstance() is called!
    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
```
- **Pros:** Fast, thread-safe, lazy initialized, no synchronized keyword needed.

---

### 3.6 Enum Singleton (Effective Java Recommendation)
Recommended by **Joshua Bloch** (Author of *Effective Java*).

```java
public enum EnumSingleton {
    INSTANCE;

    public void doSomething() {
        System.out.println("Executing Enum Singleton logic...");
    }
}
```
- **Why is Enum the best?**
  1. Reflection Proof (JVM throws `IllegalArgumentException`).
  2. Serialization Proof (JVM handles Enum serialization safely).
  3. Thread-Safe natively by JVM.
  4. Cannot be cloned.

---

## 🔥 Crucial Interview Edge Cases & Attacks

### Attack 1: Reflection Attack & Defense
**Interview Question:** *"Can you break Singleton using Reflection?"*  
**Answer:** Yes! Reflection API can access private constructors and set accessible flag to `true`.

#### How to Break:
```java
Constructor<DoubleCheckedLockingSingleton> constructor = DoubleCheckedLockingSingleton.class.getDeclaredConstructor();
constructor.setAccessible(true);
DoubleCheckedLockingSingleton brokenInstance = constructor.newInstance();
```

#### How to Prevent:
Throw an exception from constructor if instance is already created:
```java
private DoubleCheckedLockingSingleton() {
    if (instance != null) {
        throw new RuntimeException("Instance already created! Reflection attack blocked.");
    }
}
```

---

### Attack 2: Serialization/Deserialization Attack & Defense
**Interview Question:** *"What happens when a Singleton object is serialized and deserialized back?"*  
**Answer:** Deserialization creates a NEW object in memory, breaking the Singleton contract!

#### How to Prevent:
Implement the `readResolve()` method. When `readResolve()` is defined, JVM invokes it during deserialization and returns the existing instance instead of creating a new one:

```java
@Serial
protected Object readResolve() {
    return getInstance();
}
```

---

### Attack 3: Cloning Attack & Defense
**Interview Question:** *"What if someone calls `.clone()` on a Singleton object?"*  
**Answer:** If the class implements `Cloneable`, calling `clone()` creates a shallow copy, breaking Singleton.

#### How to Prevent:
Override `clone()` and throw `CloneNotSupportedException`:
```java
@Override
protected Object clone() throws CloneNotSupportedException {
    throw new CloneNotSupportedException("Cloning of Singleton instance is strictly prohibited!");
}
```

---

## 🧠 Deep Dive: Why is `volatile` mandatory in Double-Checked Locking?

This is one of the most requested **Senior Developer / Lead Interview Questions**!

### The Problem: Instruction Reordering (Memory Barrier Violation)
When JVM executes `instance = new DoubleCheckedLockingSingleton();`, it is NOT an atomic instruction. It performs 3 distinct steps:

1. **Memory Allocation:** `memory = allocate()` (Allocates memory for object)
2. **Instance Creation:** `ctorSingleton(memory)` (Calls constructor to initialize object)
3. **Reference Assignment:** `instance = memory` (Points `instance` variable to allocated memory)

### Without `volatile`:
The compiler/CPU is allowed to **reorder instructions** for optimization:
- Order becomes: `1 -> 3 -> 2`
- Step 1: Memory allocated.
- Step 3: `instance` is set to memory address (**instance is NO LONGER NULL!**).
- **At this exact microsecond, Thread-B enters `getInstance()`!**
- Thread-B checks `if (instance == null)`. Since `instance != null`, **Thread-B returns the half-initialized / corrupted object** before Step 2 completes!

### With `volatile`:
`volatile` places a **Memory Barrier (Fence)**. It strictly prevents instruction reordering around the read/write of the `instance` variable. Thread-B will always read a fully constructed object.

---

## 💡 Top Interview Questions & Quick Revisions

### Q1: Difference between Spring Bean Singleton vs Java Singleton?
- **Java Singleton:** Exactly one instance per **JVM / ClassLoader**.
- **Spring Singleton:** Exactly one instance per **Spring ApplicationContext Container**. (If you create 2 ApplicationContexts, there will be 2 bean instances).

### Q2: How does ClassLoader affect Singleton?
If two different ClassLoaders load the same Singleton class, each ClassLoader will create its own static instance! (Solution: Use custom root classloader or Enum).

### Q3: Why is Enum preferred over Double-Checked Locking?
Enum handles Reflection, Serialization, and Thread-Safety out of the box without boilerplate code or edge case risks.

---

### 📂 Code References:
- [EagerSingleton.java](file:///c:/Users/lenovo/Problemsolving/src/DesignPattens/singleton/EagerSingleton.java)
- [LazySingleton.java](file:///c:/Users/lenovo/Problemsolving/src/DesignPattens/singleton/LazySingleton.java)
- [SynchronizedSingleton.java](file:///c:/Users/lenovo/Problemsolving/src/DesignPattens/singleton/SynchronizedSingleton.java)
- [DoubleCheckedLockingSingleton.java](file:///c:/Users/lenovo/Problemsolving/src/DesignPattens/singleton/DoubleCheckedLockingSingleton.java)
- [BillPughSingleton.java](file:///c:/Users/lenovo/Problemsolving/src/DesignPattens/singleton/BillPughSingleton.java)
- [EnumSingleton.java](file:///c:/Users/lenovo/Problemsolving/src/DesignPattens/singleton/EnumSingleton.java)
- [SingletonDemo.java](file:///c:/Users/lenovo/Problemsolving/src/DesignPattens/singleton/SingletonDemo.java)
