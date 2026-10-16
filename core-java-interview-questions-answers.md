# Core Java Interview Questions & Answers — Deep-Dive Edition

> **Purpose:** A GitHub-ready, interview-oriented Core Java reference built by filtering the interview transcript supplied by the learner and adding current Java documentation and public interview-discussion themes. It deliberately focuses on the Java language, standard library, collections, JVM, and concurrency. Spring Boot, SQL, Kafka, AWS, Docker, and microservices questions belong in separate guides.
>
> **How to use:** First say the “Interview answer” aloud in 30–60 seconds. Then explain the “Deeper point” and write the code without copying. The answers are intentionally more complete than flashcards, but do not memorise them word for word.
>
> **Version baseline:** Java 17 and Java 21, with older Java 8 concepts included because they remain common in interviews. Where behaviour depends on the JDK implementation, that is stated explicitly.

## Contents

1. [Java Platform and Execution](#1-java-platform-and-execution)
2. [Language Fundamentals and Types](#2-language-fundamentals-and-types)
3. [OOP, Inheritance, and Polymorphism](#3-oop-inheritance-and-polymorphism)
4. [Object Contract, Strings, and Immutability](#4-object-contract-strings-and-immutability)
5. [Methods, Constructors, Modifiers, and Return Types](#5-methods-constructors-modifiers-and-return-types)
6. [Exception Handling](#6-exception-handling)
7. [Generics, Reflection, Annotations, and Serialization](#7-generics-reflection-annotations-and-serialization)
8. [Collections Framework Fundamentals](#8-collections-framework-fundamentals)
9. [HashMap and Other Map Internals](#9-hashmap-and-other-map-internals)
10. [Functional Interfaces, Lambdas, and Streams](#10-functional-interfaces-lambdas-and-streams)
11. [Optional and Modern Functional APIs](#11-optional-and-modern-functional-apis)
12. [Multithreading Fundamentals](#12-multithreading-fundamentals)
13. [Executors, Thread Pools, and Async Results](#13-executors-thread-pools-and-async-results)
14. [Java Memory Model, Locks, CAS, and Advanced Concurrency](#14-java-memory-model-locks-cas-and-advanced-concurrency)
15. [JVM Memory, Garbage Collection, and Class Loading](#15-jvm-memory-garbage-collection-and-class-loading)
16. [Java 8, 11, 17, and 21 Features](#16-java-8-11-17-and-21-features)
17. [Frequently Tested API Return Types and Traps](#17-frequently-tested-api-return-types-and-traps)
18. [Core Java Coding Questions with Solutions](#18-core-java-coding-questions-with-solutions)
19. [Topics from the supplied list that are not Core Java](#19-topics-from-the-supplied-list-that-are-not-core-java)
20. [References](#20-references)

---

# 1. Java Platform and Execution

### Q1. What is Java, and why is it platform-independent?
**Interview answer:** Java is a high-level, class-based programming language whose source code is compiled into platform-independent bytecode. A compatible JVM on each operating system executes that bytecode, so the same compiled program can run on different platforms.

**Deeper point:** Platform independence is not magic: the bytecode format and Java APIs are standardised, while each platform needs a JVM implementation. Native libraries, OS-specific file paths, and environment assumptions can still make an application platform-dependent.

### Q2. What are JDK, JRE, and JVM?
**Interview answer:** The JVM executes Java bytecode. The JRE conceptually contains the JVM and runtime libraries needed to run Java applications. The JDK includes development tools such as `javac`, `java`, `javadoc`, and debugging tools, plus the runtime components.

**Deeper point:** Modern JDK distributions are the practical installation target. Since Java 11, Oracle no longer ships a separate traditional JRE download in the old way, so do not claim every modern installation has a separately installed JRE directory.

### Q3. What happens from `.java` source to program execution?
**Interview answer:** `javac` compiles source into `.class` bytecode. The JVM loads classes, verifies and links them, initializes them when required, and executes their bytecode through an interpreter and/or JIT compiler.

**Deeper point:** JIT compilation can compile frequently executed (“hot”) code into native machine code at runtime. Exact optimisation choices are JVM implementation details, not guarantees that every method is compiled.

### Q4. What is bytecode, and how is it different from machine code?
**Answer:** Bytecode is the instruction set stored in a Java class file and understood by a JVM. Machine code is processor-specific native instruction code executed directly by a CPU. The JVM can interpret bytecode and compile hot paths into native code.

### Q5. Is Java compiled or interpreted?
**Answer:** Both descriptions are incomplete on their own. Java source is compiled to bytecode before execution; a JVM may interpret bytecode and use just-in-time compilation to produce native code during execution.

### Q6. What does “write once, run anywhere” mean?
**Answer:** A class file can run on any compatible JVM, assuming the application uses supported Java APIs and has its dependencies and configuration available. It does not promise identical performance, identical filesystem behaviour, or compatibility with every native dependency.

### Q7. Can two Java applications run on one machine using the same JVM?
**Answer:** Usually, separate launched Java processes each have their own JVM instance and memory space. Applications can also be hosted in one JVM process if a container or launcher deliberately loads them together; that is a different deployment model.

### Q8. What is the difference between a process and a thread?
**Answer:** A process is an operating-system execution and resource-isolation unit. Threads are execution paths within a process and generally share the process heap and other process resources, while each thread has its own stack and execution state.

### Q9. What does the Java compiler do?
**Answer:** `javac` checks language rules and types, then converts source code into class files containing bytecode and metadata. It does not generally compile the whole application directly into CPU machine code; the JVM handles execution-time interpretation and JIT compilation.

### Q10. What is the classpath?
**Answer:** The classpath tells the compiler or application class loader where to find classes and JAR files for class-path-based applications. Modern Java also has the module path, which supports the Java Platform Module System and its module boundaries.

### Q11. What is a JAR file?
**Answer:** A JAR is a ZIP-based archive that can bundle class files, resources, and metadata. An executable JAR can declare a main class in its manifest, but it still needs a compatible Java runtime and any required dependencies.

### Q12. What is the `main` method signature and why is it static?
**Answer:** The conventional entry point is `public static void main(String[] args)`. It is static so the launcher can invoke it without first creating an instance of the application class. Newer Java releases have expanded launch capabilities, but this remains the standard interview answer.

### Q13. What is the difference between compile-time and runtime errors?
**Answer:** Compile-time errors prevent source from compiling, such as incompatible types or an invalid method call. Runtime failures happen after compilation, such as `NullPointerException`, `ClassCastException`, or an uncaught exception.

### Q14. What is the difference between a class and an object?
**Answer:** A class defines a type and its fields, methods, and constructors. An object is a runtime instance of a class with identity and state. A class can have many objects, while static members belong to the class-level definition rather than one individual object.

### Q15. What is a package in Java?
**Answer:** A package groups related types and helps organise namespaces and access control. Fully qualified names distinguish types such as `java.util.Date` and `java.sql.Date`, even though their simple name is the same.

### Q16. Can two classes have the same name?
**Answer:** Yes, provided their fully qualified names differ, for example `com.shop.User` and `com.admin.User`. Importing both with the same simple name can create a naming ambiguity; code can use a fully qualified name to disambiguate.

### Q17. What is a native method?
**Answer:** A native method is declared with the `native` modifier and implemented outside ordinary Java source, often in C or C++ through the Java Native Interface (JNI). Native calls can be useful for platform integration but reduce portability and introduce native-memory and crash risks.

### Q18. What is the difference between Java and C++ platform independence?
**Answer:** Java commonly compiles to portable bytecode executed by a JVM, while C++ is commonly compiled into machine code for a specific target platform. C++ can also be ported by recompiling its source, and Java applications can still have platform dependencies, so the difference is the usual deployment model—not that C++ can never run across platforms.

### Q19. What are the common ways to create an object in Java?
**Answer:** Interviewers commonly expect `new`, reflective construction (`Constructor.newInstance()`), cloning (`clone()` when supported), and deserialization (`ObjectInputStream.readObject()`). Factory methods such as `User.create()` and builders can also return objects, but they are higher-level APIs that may use different mechanisms internally. There is no language rule that says Java has exactly five object-creation “ways”; explain the category and caveats. `Class.newInstance()` is deprecated and should be avoided in new code.

**Deeper point:** Enums are created by the JVM as enum constants, and method handles/reflection provide further runtime construction mechanisms. Cloning is shallow unless explicitly implemented otherwise, and built-in deserialization has security/versioning concerns.

---

# 2. Language Fundamentals and Types

### Q20. What are Java's primitive data types?
**Answer:** Java has eight primitives: `byte`, `short`, `int`, `long`, `float`, `double`, `char`, and `boolean`. Numeric primitives have defined widths except that the language does not specify a particular storage size for `boolean`; a `char` is a 16-bit UTF-16 code unit, not necessarily a complete Unicode character.

### Q21. Why do we have `int` if `long` can store larger integers?
**Answer:** `int` uses less space than `long` in common layouts and is sufficient for many counters, indexes, and everyday arithmetic. A `long` has a wider range but can consume more memory in arrays and objects, and its use does not automatically make code faster or slower in every context.

### Q22. How is the range of a signed integer calculated?
**Answer:** For an n-bit two's-complement signed integer, the range is `-2^(n-1)` through `2^(n-1)-1`. For example, Java `int` is 32-bit, so its range is `-2^31` to `2^31 - 1`; `long` is 64-bit.

### Q23. What is the difference between primitive and reference types?
**Answer:** A primitive variable holds a primitive value, such as an integer or boolean. A reference variable holds a reference to an object or array, or `null`. Reference equality and object state are separate concepts; assigning a reference usually copies the reference, not the object.

### Q24. What are wrapper classes?
**Answer:** Wrapper classes represent primitive values as objects: `Integer`, `Long`, `Double`, `Boolean`, and the other wrappers. They are needed for generic collections such as `List<Integer>` and provide utility methods, parsing, and constants.

### Q25. What are autoboxing and unboxing?
**Answer:** Autoboxing automatically converts a primitive into its wrapper, such as `int` to `Integer`; unboxing converts a wrapper to a primitive. Unboxing a `null` wrapper throws `NullPointerException`, so automatic conversion does not remove null-safety concerns.

### Q26. What is the difference between `==` and `equals()`?
**Answer:** For primitives, `==` compares values; for references, it compares whether both references point to the same object. `equals()` is a method whose default implementation in `Object` also tests identity, but classes can override it to represent logical equality.

### Q27. What is type casting?
**Answer:** Widening primitive conversions, such as `int` to `long`, generally happen implicitly because the target can represent the source range. Narrowing conversions, such as `long` to `int`, require an explicit cast and can lose information. Reference downcasts can fail at runtime with `ClassCastException`.

### Q28. What are widening and narrowing reference conversions?
**Answer:** Upcasting a subclass reference to a superclass or interface type is generally safe and implicit. Downcasting to a more specific subtype requires an explicit cast unless the compiler can infer it, and it can fail if the object is not actually of that subtype. Pattern matching with `instanceof` can make checked casts safer.

### Q29. What is the difference between `final`, `finally`, and `finalize()`?
**Answer:** `final` is a modifier for variables, methods, and classes. `finally` is a cleanup block used with `try`. `Object.finalize()` is a deprecated-for-removal legacy finalization mechanism and should not be used for resource cleanup; prefer try-with-resources or explicit lifecycle management.

### Q30. What is the difference between `static` and instance members?
**Answer:** A static field or method belongs to the class, while an instance field or method is associated with an object. Static methods cannot directly access instance members without an object reference and are hidden—not overridden—when a subclass declares a static method with a matching signature.

### Q31. What is the `var` keyword?
**Answer:** Local-variable type inference lets the compiler infer a local variable's static type from its initializer, for example `var names = new ArrayList<String>();`. It does not make Java dynamically typed, cannot be used for fields or method parameters, and requires an initializer in ordinary declarations.

### Q32. What is an enum?
**Answer:** An enum defines a fixed set of named instances, such as `OrderStatus.PAID`. Enums can have fields, constructors, and methods, and are generally safer than using arbitrary strings or integers for a closed set of states.

### Q33. What are varargs?
**Answer:** A method parameter such as `void log(String... values)` accepts zero or more arguments and is treated as an array inside the method. Only one varargs parameter is allowed, and it must be the final parameter in the declaration.

### Q34. What is short-circuit evaluation?
**Answer:** `&&` and `||` may skip evaluating the right-hand expression when the left side already determines the result. `&` and `|` on booleans evaluate both operands, which matters if an expression has side effects or might throw an exception.

### Q35. What is the difference between `break`, `continue`, and `return`?
**Answer:** `break` exits the nearest loop or switch (or a labelled statement). `continue` skips to the next loop iteration. `return` exits the current method and, for non-void methods, returns a value.

### Q36. What is integer overflow?
**Answer:** Integer arithmetic on `int` and `long` wraps according to two's-complement arithmetic rather than automatically throwing on overflow. `Math.addExact`, `subtractExact`, and related methods can detect overflow by throwing `ArithmeticException`.

### Q37. Why should floating-point equality be used carefully?
**Answer:** `float` and `double` represent many decimal fractions approximately using binary floating-point. Exact equality can therefore surprise when calculations accumulate rounding error. For money, use `BigDecimal` with an explicit scale/rounding policy or integer minor units where appropriate.

---

# 3. OOP, Inheritance, and Polymorphism

### Q38. What are the four main OOP principles?
**Answer:** Encapsulation protects an object's state behind a controlled API; abstraction exposes essential behaviour while hiding implementation details; inheritance reuses or specialises behaviour through a subtype relationship; polymorphism lets one interface or superclass reference invoke behaviour implemented by different runtime types.

### Q39. What is encapsulation?
**Answer:** Encapsulation combines state and behaviour and controls how the state can be accessed or changed. Private fields with validated methods are a common implementation, but encapsulation is about maintaining invariants—not simply generating getters and setters for every field.

### Q40. What is abstraction?
**Answer:** Abstraction presents the contract needed by a caller while hiding implementation details. An interface such as `PaymentMethod` can expose `pay()` while card, wallet, and bank-transfer implementations handle the details differently.

### Q41. What is inheritance, and when should it be avoided?
**Answer:** Inheritance lets a subclass inherit accessible behaviour and type compatibility from a superclass. Use it when the subtype truly satisfies the base-type contract (“is-a”); prefer composition when the relationship is mainly code reuse, because inheritance couples subclasses to base-class implementation and can make changes risky.

### Q42. What is composition, and how is it different from inheritance?
**Answer:** Composition builds a type using other objects as fields and delegates work to them (“has-a”). Inheritance establishes a subtype relationship (“is-a”). Composition often gives more flexible runtime replacement and less coupling, while inheritance is appropriate when substitutability is real.

### Q43. What is polymorphism?
**Answer:** Polymorphism lets code call a common contract while runtime objects supply different implementations. Overriding of instance methods is runtime polymorphism; overloading is selected at compile time based on argument types and declared signatures.

### Q44. What is method overloading?
**Answer:** Overloading declares multiple methods with the same name but different parameter lists. The compiler chooses the applicable overload using compile-time types and overload-resolution rules. Changing only the return type is not enough to overload a method.

### Q45. What is method overriding?
**Answer:** Overriding occurs when a subclass instance method provides an implementation for an inherited instance method with a compatible signature. The actual object's runtime class determines which implementation executes, subject to access and inheritance rules. Use `@Override` so the compiler catches signature mistakes.

### Q46. What is method hiding?
**Answer:** A static method in a subclass with a matching signature hides a static method in a superclass; it does not override it. The selected method is based on the compile-time type used to make the static call, unlike overridden instance methods, which dispatch using runtime type.

### Q47. Can static, private, or final methods be overridden?
**Answer:** Static methods are hidden, not overridden. Private methods are not inherited as overridable methods. Final instance methods cannot be overridden. A subclass may declare a same-signature method as a private superclass method, but that is a separate declaration, not overriding.

### Q48. What is IS-A versus HAS-A?
**Answer:** IS-A means subtype compatibility: `Dog extends Animal` means a dog is an animal. HAS-A means one object contains or uses another: `Car` has an `Engine`. Model business relationships using the concept they actually represent instead of using inheritance purely to reuse code.

### Q49. What is an abstract class?
**Answer:** An abstract class cannot be instantiated directly and may combine abstract methods with concrete methods, state, constructors, and protected implementation details. A concrete subclass must implement inherited abstract methods. Use it when related subclasses need a shared base implementation or state.

### Q50. What is an interface?
**Answer:** An interface defines a contract that classes can implement. It can declare abstract methods and, since Java 8, default and static methods; later Java versions also support private helper methods. Interfaces do not provide ordinary per-instance fields or constructors.

### Q51. Abstract class versus interface: how do you choose?
**Answer:** Use an interface to define a capability or contract that unrelated classes can implement, and to allow a class to implement multiple contracts. Use an abstract class for shared state or protected implementation across a closely related hierarchy. A class can extend only one class but implement multiple interfaces.

### Q52. Why were default methods added to interfaces?
**Answer:** Default methods allow interfaces to evolve by adding implementations without forcing every existing implementing class to immediately implement the new method. They also enable reusable behaviour, but conflicts between unrelated inherited defaults must be resolved explicitly.

### Q53. What happens if two interfaces provide the same default method?
**Answer:** If a class inherits conflicting default implementations with the same signature, it must override the method to resolve the conflict. Inside that method it can select one implementation using `InterfaceName.super.method()` when applicable. A concrete superclass method generally takes precedence over an interface default.

### Q54. Can an abstract class have a constructor?
**Answer:** Yes. The abstract class constructor runs as part of constructing a concrete subclass object and can initialise common state. The constructor does not make the abstract class directly instantiable.

### Q55. Can a constructor be overridden or inherited?
**Answer:** No. Constructors are not inherited and cannot be overridden; subclasses declare their own constructors and can call a superclass constructor using `super(...)`. Constructors can be overloaded by using different parameter lists.

### Q56. What is covariant return type?
**Answer:** An overriding method may return a subtype of the return type declared by the overridden method. For example, a base method can return `Animal`, while an override returns `Dog`; this improves type precision without breaking substitutability.

### Q57. Can a method be overloaded by changing only the return type?
**Answer:** No. The parameter list must differ in a way allowed by Java's method signature rules. Return type alone does not resolve which overload should run when a caller invokes the method.

### Q58. What is dynamic method dispatch?
**Answer:** For an overridden instance method, the JVM selects the implementation corresponding to the runtime class of the receiver. For example, `Animal a = new Dog(); a.sound();` calls `Dog.sound()` if `Dog` overrides it. Static methods and fields do not use this dispatch rule.

### Q59. What is the Liskov Substitution Principle in practical terms?
**Answer:** A subtype should be usable wherever its base type is expected without violating the caller's assumptions. A subtype should not strengthen preconditions or weaken postconditions in a way that breaks clients. It is a design principle, not merely a Java syntax rule.

### Q60. Why prefer composition over inheritance in many designs?
**Answer:** Composition allows a behaviour to be swapped through a field or interface and avoids exposing all protected implementation details of a base class. Inheritance remains useful for genuine subtype relationships and framework extension points; the choice depends on substitutability and change boundaries.

### Q61. What happens if a concrete subclass does not implement every abstract method?
**Answer:** The subclass must itself be declared `abstract`; otherwise, compilation fails. A non-abstract class has to satisfy all inherited abstract method obligations, including abstract methods required by implemented interfaces.

---

# 4. Object Contract, Strings, and Immutability

### Q62. What is the `Object` class?
**Answer:** `java.lang.Object` is the root superclass of Java's class hierarchy. Classes that do not explicitly extend another class implicitly extend `Object`. Important methods include `equals`, `hashCode`, `toString`, `getClass`, `wait`, `notify`, `notifyAll`, and the legacy `clone`/`finalize` methods.

### Q63. What is the contract of `equals()`?
**Answer:** A correct equality relation should be reflexive, symmetric, transitive, consistent while relevant state does not change, and false when compared to `null`. If you override it, compare the domain identity/value fields and handle type compatibility carefully; generated IDE/record implementations can reduce mistakes.

### Q64. What is the `hashCode()` contract?
**Answer:** If two objects are equal according to `equals()`, they must return the same hash code. Unequal objects may share a hash code, although excessive collisions reduce hash-table performance. A hash code need not remain stable across separate program executions.

### Q65. What if `hashCode()` is overridden but `equals()` is not?
**Answer:** The default `Object.equals()` compares identity, so two distinct objects with identical field values are not logically equal. A `HashSet` may therefore retain both. Equal-by-domain objects require consistent overrides of both methods.

### Q66. What if `equals()` is overridden but `hashCode()` is not?
**Answer:** Two logically equal objects may return different identity-based hash codes. Hash-based collections can put them in different buckets and fail to recognise them as duplicate keys or set elements, violating the contract. Always override `hashCode()` consistently with `equals()`.

### Q67. What if neither `equals()` nor `hashCode()` is overridden?
**Answer:** The methods inherited from `Object` use identity-based equality semantics and its corresponding hash code behaviour. Two separate instances with the same data are treated as different keys, which may be correct for identity objects but often is not for value objects.

### Q68. What does `System.identityHashCode(object)` do?
**Answer:** It returns the default identity-based hash code for an object even if its class overrides `hashCode()`. It does not promise a unique integer for every object and should not be treated as a memory address.

### Q69. What is `toString()` used for?
**Answer:** `toString()` provides a textual representation useful for debugging and logging. `Object`'s default is class name plus a hash-like representation, not a stable identifier. Override it to expose helpful, non-sensitive state; do not accidentally log passwords, tokens, or personal data.

### Q70. What is the String pool?
**Answer:** Java maintains a pool of canonical strings so equal string literals can reuse the same `String` instance. Literal expressions are interned by the language/runtime rules; `new String("java")` creates a distinct object, while `intern()` returns the canonical pooled representation.

### Q71. Why is `String` immutable?
**Answer:** Once created, a `String`'s character content cannot change. This supports safe sharing, stable hashing for map keys, string pooling, and security-sensitive use such as class names and paths. Operations that seem to modify a string actually produce another string.

### Q72. String versus StringBuilder versus StringBuffer?
**Answer:** `String` is immutable. `StringBuilder` is mutable and generally preferred for repeated string modification within one thread. `StringBuffer` is mutable but synchronizes its methods for legacy thread-safe operation, which can add overhead; synchronizing a buffer does not make a whole multi-step business operation automatically atomic.

### Q73. Why can repeated `+` concatenation be inefficient in a loop?
**Answer:** Strings are immutable, so repeatedly building a growing result can allocate many intermediate strings and copy characters repeatedly. Use `StringBuilder` for loop-based concatenation, unless the compiler can optimise a simple fixed expression.

### Q74. Is `String` thread-safe?
**Answer:** Yes in the practical sense that immutable string content can be shared safely between threads once the reference is safely published. The reference variable itself can still be reassigned, and safe publication of a containing mutable object remains a separate concurrency concern.

### Q75. What is string interning, and when should it be used?
**Answer:** `intern()` returns a canonical string from the string pool, adding the content if necessary. It may save duplicate string storage for suitable high-duplication workloads, but indiscriminate interning of high-cardinality data can add overhead and create pressure in the pool.

### Q76. What is shallow copy versus deep copy?
**Answer:** A shallow copy duplicates the outer object but keeps references to the same nested objects. A deep copy also copies the relevant nested mutable objects. The required depth depends on the object graph; blindly deep-copying shared entities may be incorrect or expensive.

### Q77. What does `clone()` do, and why is it often avoided?
**Answer:** `Object.clone()` creates a field-by-field shallow copy when supported, conventionally by implementing `Cloneable` and exposing an appropriate `clone()` method. The contract is awkward, does not automatically deep-copy nested objects, and is easy to misuse; copy constructors or named factory methods are often clearer.

### Q78. What is an immutable class, and how do you design one?
**Answer:** An immutable object cannot have its externally observable state changed after construction. Common techniques are a final class (when subclass mutation must be prevented), private final fields, constructor validation, no mutators, and defensive copies of mutable inputs and outputs. Deep immutability requires considering every nested object.

### Q79. Does declaring a reference `final` make its object immutable?
**Answer:** No. `final` prevents that variable from being reassigned, but the referenced object may still be mutable. `final List<String> names = new ArrayList<>();` prevents assigning another list to `names`, not calling `names.add(...)`.

### Q80. What is the difference between identity equality and value equality?
**Answer:** Identity equality asks whether two references point to the same object (`==` for references). Value equality asks whether objects represent the same logical value (`equals()`). Value objects such as dates, money values, and records generally need value equality; identity entities may deliberately use identity semantics.

### Q81. What is a Java record, and how does it relate to immutability?
**Answer:** A record is a concise data-carrier class whose component fields are final and for which the compiler supplies accessors, equality, hash code, and string representation. Records are only shallowly immutable: a component that points to a mutable list can still expose mutable state unless the constructor/accessor makes defensive copies.

---

# 5. Methods, Constructors, Modifiers, and Return Types

### Q82. What are Java access modifiers?
**Answer:** `public` is broadly accessible; `protected` permits same-package access and qualifying subclass access; package-private (no modifier) permits same-package access; `private` limits access to the declaring top-level class's permitted nest context. Top-level classes can be `public` or package-private, not `private` or `protected`.

### Q83. What is the `this` keyword?
**Answer:** `this` refers to the current object in an instance context. It disambiguates fields from parameters (`this.id = id`) and can invoke another constructor in the same class using `this(...)`, which must be the first constructor statement under the traditional constructor syntax rules.

### Q84. What is the `super` keyword?
**Answer:** `super` refers to the superclass portion of the current instance for accessing accessible inherited members or invoking a superclass constructor with `super(...)`. A superclass constructor call must happen before the subclass constructor body continues.

### Q85. What is constructor chaining?
**Answer:** Constructor chaining means one constructor delegates to another constructor in the same class using `this(...)`, or to a superclass constructor using `super(...)`. It centralises initialisation and avoids duplicating validation or assignment logic.

### Q86. What happens if no constructor is declared?
**Answer:** The compiler provides a default no-argument constructor only if the class declares no constructors at all. That generated constructor invokes the accessible no-argument superclass constructor; if none is accessible, compilation fails.

### Q87. Can a constructor be private?
**Answer:** Yes. A private constructor restricts object creation from outside the declaring class or its permitted nestmates and is useful for utility classes, singleton designs, or controlled factory creation. It does not by itself guarantee a robust singleton against reflection or serialization in every design.

### Q88. What is an initializer block?
**Answer:** A static initializer runs when the class is initialized; an instance initializer runs during instance creation as part of constructor execution. Field initializers and initializer blocks execute in textual order within their class, with superclass construction/initialization rules applying before subclass instance initialization.

### Q89. What is the difference between `void` and returning `null`?
**Answer:** A `void` method returns no value. A reference-returning method can return an object reference or `null`; `null` is a value representing no object, not a substitute for a `void` return. Primitive-returning methods must return a value on every normal completion path.

### Q90. Can an overriding method widen access and change exceptions?
**Answer:** An override may widen visibility, but it cannot reduce the visibility of the overridden method. It cannot declare broader checked exceptions than the overridden method allows; unchecked exceptions do not have this same compile-time restriction.

### Q91. What is a varargs method's effective parameter type?
**Answer:** In a declaration like `print(String... values)`, the parameter is treated as a `String[]` inside the method. The caller can pass multiple individual strings or an array, and a varargs invocation can be ambiguous with overloaded methods if the overload set is poorly designed.

### Q92. Can `main` be overloaded?
**Answer:** Yes, a class can declare other methods named `main` with different parameter lists. The Java launcher uses the entry-point signature it recognises; it does not choose an arbitrary overloaded `main` based on user-defined overload resolution.

### Q93. What are covariant returns and bridge methods?
**Answer:** Covariant returns allow an override to return a more specific type. Because generics and overriding must interoperate after type erasure, the compiler may generate synthetic bridge methods so polymorphic dispatch continues to follow the language contract. Bridge methods are compiler-generated details visible through reflection in some cases.

### Q94. What is a marker interface?
**Answer:** A marker interface has no methods and marks a type as having a property or capability, such as `Serializable` or `Cloneable`. Modern code can also use annotations for metadata, but a marker interface participates in type checks and can be used in APIs that accept only marked types.

### Q95. What is the difference between `transient` and `volatile`?
**Answer:** `transient` marks an instance field to be excluded from default Java serialization. `volatile` provides visibility and ordering guarantees for reads and writes of that field across threads. They solve different problems and are not interchangeable.

### Q96. What does `strictfp` do today?
**Answer:** Historically, `strictfp` constrained floating-point evaluation consistency. Since Java 17, floating-point expressions always use strict semantics, so the modifier is unnecessary for that purpose and is largely a legacy keyword encountered in older code.

### Q97. What are annotations used for?
**Answer:** Annotations attach metadata to declarations, parameters, or types. A compiler, annotation processor, or runtime framework can inspect that metadata; the annotation itself does not automatically change program behaviour unless some tool or code acts on it.

### Q98. What is the difference between `@Override` and `@FunctionalInterface`?
**Answer:** `@Override` asks the compiler to verify that a method actually overrides or implements an inherited method. `@FunctionalInterface` asks the compiler to verify that an interface has one abstract method suitable for lambda use; both are optional annotations that improve compile-time checks.

### Q99. Can a Java method return multiple values?
**Answer:** A Java method has one declared return type. It can return a composite object such as a record, class, pair-like type, or collection to represent multiple logical values, or it can modify a mutable argument (usually less desirable than returning a result object).

### Q100. What is pass-by-value in Java?
**Answer:** Java is always pass-by-value. For primitives, the value is copied; for objects, the reference value is copied. A method can mutate an object through its copied reference, but reassigning the parameter does not change the caller's reference variable.

### Q101. What is the difference between a class variable and a local variable?
**Answer:** A class field has a default value when not explicitly initialised; a local variable must be definitely assigned before it is read. Local variables are scoped to a method/block and do not automatically have the same lifetime or storage model as object fields.

---

# 6. Exception Handling

### Q102. What is the difference between `Exception` and `Error`?
**Answer:** `Exception` represents conditions applications may reasonably catch or declare, while `Error` represents serious JVM or environment problems such as `OutOfMemoryError` and `StackOverflowError`. The distinction is not absolute in every design, but application code should not casually catch `Error` and continue as if the process were healthy.

### Q103. What are checked and unchecked exceptions?
**Answer:** Checked exceptions are subclasses of `Exception` other than `RuntimeException` and must be caught or declared. `RuntimeException` subclasses and `Error` subclasses are unchecked. Checked exceptions suit conditions callers are expected to handle; unchecked exceptions often represent programming errors or failures that cannot sensibly be handled at every call site.

### Q104. What is the difference between `throw` and `throws`?
**Answer:** `throw` actually throws an exception object from code. `throws` declares in a method signature that checked exceptions may escape the method. `throw new IllegalArgumentException(...)` is an action; `void read() throws IOException` is a declaration.

### Q105. Can `try` exist without `catch`?
**Answer:** Yes, a `try` statement can have `finally` without `catch`, and a try-with-resources statement can be used without a catch or finally block. A traditional `try` must have at least a `catch` or `finally` clause.

### Q106. Does `finally` always execute?
**Answer:** It normally executes when control leaves a `try`/`catch`, including through a return or exception. It may not execute if the JVM/process terminates abruptly, the machine loses power, or execution never leaves the block. Avoid returning from `finally`, because it can override an earlier return or suppress an exception.

### Q107. What happens if both `try` and `finally` throw/return?
**Answer:** A `return` or exception from `finally` can replace the pending return value or exception from the `try`/`catch`, which is why control flow in `finally` should be limited to cleanup. In try-with-resources, close failures are generally recorded as suppressed exceptions when another exception is already in flight.

### Q108. What is try-with-resources?
**Answer:** Try-with-resources automatically closes resources that implement `AutoCloseable`, such as streams and readers, when control exits the block. It makes resource cleanup safer than manually closing in `finally` and preserves suppressed exceptions from close failures.

### Q109. How do you create a custom exception?
**Answer:** Extend `Exception` for a checked exception or `RuntimeException` for an unchecked exception. Provide a clear message and, when useful, constructors that accept a cause. Use a domain-specific exception when it improves the calling code's ability to handle a meaningful failure.

### Q110. What is exception propagation?
**Answer:** If a method does not handle an exception, it propagates up the call stack until a matching handler is found or the thread terminates with the exception. Checked exceptions must be caught or declared; unchecked exceptions can propagate without declaration.

### Q111. What is exception chaining?
**Answer:** Exception chaining preserves the underlying cause when translating a low-level failure into a higher-level exception. Use a constructor that accepts the cause, for example `throw new DataAccessException("Could not load user", e)`, so logs retain the original stack trace.

### Q112. Can a `catch` block catch multiple exception types?
**Answer:** Yes. Multi-catch uses `catch (IOException | SQLException e)` when the handling is identical and the alternatives are not in a subtype relationship. The multi-catch parameter is effectively final, so it cannot be reassigned.

### Q113. In what order should catch blocks be written?
**Answer:** Catch more specific exception types before their supertypes. If a superclass catch comes first, a later subclass catch is unreachable and compilation fails.

### Q114. What is `NullPointerException`, and how do you prevent it?
**Answer:** It occurs when code dereferences `null` or performs an operation requiring a non-null reference. Prevent it by defining null contracts, validating inputs at boundaries, using safe APIs and clear domain types, and using `Optional` for suitable return values—not by wrapping every line in try/catch.

### Q115. What is `ClassCastException`?
**Answer:** It occurs when a reference cast claims a runtime object is an incompatible type. Use polymorphism, appropriate generics, or a checked `instanceof` pattern before downcasting when the type cannot be guaranteed from program structure.

### Q116. Can you catch an `OutOfMemoryError`?
**Answer:** Technically, it can be caught because it is an `Error`, but recovery is not guaranteed: the JVM may lack memory to allocate even the objects required for recovery. Capture diagnostics and fix the root cause—heap sizing, allocation rate, retaining references, or native memory—rather than relying on a catch block.

### Q117. What should an exception message include?
**Answer:** Include enough context to diagnose the failure without exposing secrets. Preserve the original cause, avoid logging the same stack trace repeatedly at every layer, and distinguish expected business outcomes from unexpected technical failures.

---

# 7. Generics, Reflection, Annotations, and Serialization

### Q118. What are generics in Java?
**Answer:** Generics let classes, interfaces, and methods be parameterised by types, such as `List<String>`. They provide compile-time type checking and reduce casts. Most generic type information is erased from ordinary runtime types, although class-file metadata and some reflection information may preserve declared generic signatures.

### Q119. What is type erasure?
**Answer:** The compiler implements most generics by erasing type parameters to their bounds or `Object` and inserting casts/bridge methods where needed. This preserves compatibility with older bytecode, but it means `new T()` and `new List<String>[10]` are not allowed in ordinary generic code.

### Q120. What is a bounded type parameter?
**Answer:** A bound restricts which types may be used for a generic parameter: `class Box<T extends Number>` accepts `Number` subtypes. A type parameter may have multiple bounds, with a class bound—if present—first, followed by interface bounds.

### Q121. What is the difference between `? extends T` and `? super T`?
**Answer:** `? extends T` means an unknown subtype of `T`, so values can generally be read as `T`, but adding a concrete `T` is unsafe (apart from `null`). `? super T` means an unknown supertype of `T`, so `T` values can be added but reads are only guaranteed as `Object`. This is the PECS rule: Producer Extends, Consumer Super.

### Q122. What is a wildcard in generics?
**Answer:** `List<?>` means a list of some unknown element type. It can be read as `Object`, but you cannot safely add an arbitrary non-null element because the actual type could be `String`, `Integer`, or something else. Wildcards are useful when an API should accept families of generic types.

### Q123. Why is `List<Integer>` not a subtype of `List<Number>`?
**Answer:** Java generics are invariant. If `List<Integer>` were assignable to `List<Number>`, code could add a `Double` to a list that is supposed to contain only integers. Use wildcards such as `List<? extends Number>` when a method should accept lists of different `Number` subtypes.

### Q124. What is a generic method?
**Answer:** A generic method declares its own type parameter, for example `<T> T identity(T value)`. The compiler can infer the type from arguments and context, and the method-level type variable is independent of any type parameter declared by the containing class.

### Q125. What are raw types and why avoid them?
**Answer:** A raw type omits generic arguments, such as `List` rather than `List<String>`. It exists largely for legacy compatibility but bypasses compile-time generic checks and can cause heap pollution or runtime `ClassCastException`. Prefer parameterised types and avoid unchecked warnings where possible.

### Q126. What is heap pollution?
**Answer:** Heap pollution happens when a variable of a parameterised type refers to an object that does not satisfy that type's parameter assumptions, often due to raw types, unchecked casts, or unsafe varargs. It can defer a type error until a later runtime cast.

### Q127. What is reflection in Java?
**Answer:** Reflection lets a program inspect runtime class metadata and, subject to access rules, examine or invoke constructors, methods, and fields. Frameworks and testing tools use it for dependency wiring, mapping, and discovery. Reflection can reduce type safety, complicate debugging, and be restricted by the module system.

### Q128. What is the difference between `Class.forName()` and `object.getClass()`?
**Answer:** `Class.forName("some.Type")` locates a class by name and, in its traditional one-argument form, initializes it. `object.getClass()` returns the runtime class of an existing non-null object. `getClass()` therefore cannot be used when there is no object reference.

### Q129. How can reflection create an object?
**Answer:** A typical modern approach is `type.getDeclaredConstructor().newInstance()`. It can throw checked reflection exceptions and may fail if a suitable constructor is absent or access restrictions prevent invocation. `Class.newInstance()` is deprecated and should not be used in new code.

### Q130. Can reflection access private fields or methods?
**Answer:** It may be possible with `setAccessible(true)` or related access controls when module boundaries and runtime permissions allow it. Strong encapsulation in modern Java can block access to non-open packages, so “reflection can access every private member” is not a reliable guarantee.

### Q131. What is an annotation processor?
**Answer:** An annotation processor runs during compilation to inspect annotations and may generate source or other outputs. It differs from runtime reflection, which inspects already compiled classes while the application runs.

### Q132. What are annotation retention policies?
**Answer:** `SOURCE` annotations are discarded after compilation, `CLASS` annotations are stored in class files but need not be available to runtime reflection, and `RUNTIME` annotations remain available at runtime. Choose the policy based on whether tooling needs the metadata at source, bytecode, or runtime.

### Q133. How do you define a custom annotation and read it at runtime?
**Answer:** Declare it with `@interface`, specify where it applies with `@Target`, and use `@Retention(RetentionPolicy.RUNTIME)` if runtime reflection must read it. Without runtime retention, it is not available in the same way to ordinary runtime reflection. An annotation is metadata; code or a framework must explicitly inspect and act on it.

```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Audited {
    String value() default "";
}

@Audited("user-update")
void updateUser() { }
```

To read it, inspect the method using reflection and call `method.getAnnotation(Audited.class)`.

### Q134. What is Java serialization?
**Answer:** Java's built-in serialization mechanism can convert an object graph to a byte stream for later reconstruction. Serializable classes implement `Serializable`, and object fields follow serialization rules including `transient`. For new external data formats, explicit formats such as JSON or Protocol Buffers are often easier to version and safer to validate.

### Q135. What is `serialVersionUID`?
**Answer:** It is a version identifier used by Java serialization to check compatibility between a serialized stream and a class. Explicitly declaring it can make version compatibility decisions more deliberate, but it does not automatically make changed object schemas compatible.

### Q136. What do `transient` fields do during default serialization?
**Answer:** They are skipped by default Java object serialization. After ordinary deserialization, primitive transient fields receive their default values and reference fields are initially `null`, unless custom serialization/deserialization logic sets them.

### Q137. What is `Externalizable` versus `Serializable`?
**Answer:** `Serializable` uses default field serialization unless custom hooks are defined. `Externalizable` gives the class explicit control through `writeExternal` and `readExternal`, but it requires a public no-argument constructor and places more responsibility on the class to maintain a compatible format.

### Q138. Why can deserializing untrusted Java data be dangerous?
**Answer:** Deserialization can instantiate types and trigger logic across a complex object graph, potentially invoking unexpected behaviour in classes on the classpath. Do not deserialize untrusted streams without strict controls; prefer simple validated data formats and allowlists when legacy serialization is unavoidable.

---

# 8. Collections Framework Fundamentals

### Q139. What is the Java Collections Framework?
**Answer:** It provides standard interfaces and implementations for groups of objects, including `List`, `Set`, `Queue`, and `Deque`, plus algorithms and utility methods. `Map` is part of the framework but is not a subtype of `Collection` because it stores key-value associations rather than individual elements.

### Q140. What is the difference between `Collection` and `Collections`?
**Answer:** `Collection` is a root interface for many collection types. `Collections` is a utility class with static helpers such as sorting, reversing, synchronised wrappers, unmodifiable wrappers, and frequency counting.

### Q141. What are common ways to create a List in Java, and how do they differ?
**Answer:** `new ArrayList<>()` creates a mutable, resizable list; `Arrays.asList(array)` creates a fixed-size list backed by the array; `List.of(...)` creates an unmodifiable list that rejects null; `Collections.emptyList()` returns an empty unmodifiable list; and `Stream.toList()` returns an unmodifiable list of stream results (Java 16+). `new ArrayList<>(source)` makes a mutable structural copy of another collection.

**Interview trap:** `Arrays.asList` allows `set` but not structural add/remove, while `List.of` rejects mutation and null entries. An unmodifiable list is not necessarily deeply immutable if its elements are mutable.

### Q142. What is the difference between List, Set, and Map?
**Answer:** A `List` preserves an element sequence and usually permits duplicates; a `Set` enforces uniqueness according to its equality/ordering semantics; a `Map` associates unique keys with values. Choose based on required ordering, duplicate behaviour, lookup pattern, and concurrency needs.

### Q143. ArrayList versus LinkedList?
**Answer:** `ArrayList` uses a resizable array and provides O(1) indexed access on average, with amortised O(1) append; middle insertion/removal usually shifts elements. `LinkedList` is a doubly linked list with O(n) indexed access and extra per-node memory; it can insert/remove efficiently when the node/iterator position is already known. For most ordinary list workloads, `ArrayList` is the default choice.

### Q144. How does ArrayList grow internally?
**Answer:** It stores elements in an array and allocates a larger array when capacity is exhausted, copying the existing references. A particular growth factor is an implementation detail rather than a universal API contract, so avoid claiming an exact factor unless you specify the JDK implementation/version.

### Q145. What is the difference between size and capacity in ArrayList?
**Answer:** Size is the number of stored elements returned by `size()`. Capacity is the length of the internal array available before another growth allocation is needed. Capacity is an implementation detail and is not exposed as a general `List` method.

### Q146. What is HashSet's internal working?
**Answer:** In the standard JDK implementation, `HashSet` is backed by a `HashMap`: set elements are stored as map keys with a shared dummy value. `hashCode()` helps choose a bucket and `equals()` distinguishes matching elements when collisions occur. This backing detail is an implementation fact, not the `Set` interface contract.

### Q147. How does TreeSet differ from HashSet?
**Answer:** `HashSet` provides expected constant-time basic operations with good hash distribution and has no guaranteed iteration order. `TreeSet` keeps elements sorted using natural ordering or a `Comparator`, with typically O(log n) basic operations. The ordering must be consistent with the intended uniqueness semantics.

### Q148. What is LinkedHashSet?
**Answer:** `LinkedHashSet` combines hash-based lookup with a linked iteration order, usually insertion order. It costs more memory than `HashSet` but offers predictable iteration order without sorting all elements.

### Q149. What is a Queue versus a Deque?
**Answer:** `Queue` models elements waiting to be processed, usually with operations to insert, inspect, and remove from one end. `Deque` supports insertion and removal at both ends and can act as either a queue or a stack. `ArrayDeque` is generally preferred to legacy `Stack` for single-threaded stack use.

### Q150. What is PriorityQueue?
**Answer:** `PriorityQueue` is a heap-based queue whose head is the least element according to natural ordering or a supplied comparator. `offer` and `poll` are O(log n), while peeking at the head is O(1). Iterating over it does not guarantee sorted order; repeatedly polling does.

### Q151. What is Iterator and why use it?
**Answer:** `Iterator` provides a common traversal API through `hasNext()` and `next()`, with optional `remove()`. It avoids relying on implementation-specific indexing and can support safe removal through the iterator while iterating over some collections.

### Q152. Iterator versus ListIterator?
**Answer:** `Iterator` traverses forward and can optionally remove elements. `ListIterator` is specific to lists and can traverse both directions, report indices, and support add/set operations where supported. `ListIterator` cannot be created for a generic `Set` or `Map`.

### Q153. What is fail-fast iteration?
**Answer:** Many standard collection iterators detect certain structural modifications made outside the iterator and may throw `ConcurrentModificationException`. This is a best-effort bug-detection mechanism, not a thread-safety guarantee and not something correctness should depend on.

### Q154. Is there a truly “fail-safe” iterator category in the Java API?
**Answer:** “Fail-safe” is an informal interview term, not a formal Java collection interface category. Concurrent collections may use weakly consistent iterators, while `CopyOnWriteArrayList` iterates over a snapshot. Explain the actual semantics of the collection instead of using the loose label as if it were a specification.

### Q155. What causes ConcurrentModificationException?
**Answer:** It can occur when a fail-fast iterator detects a structural change outside its permitted iterator operations. In single-threaded code, use `Iterator.remove()`, `removeIf`, or build a filtered copy. For concurrent access, choose an appropriate concurrent collection or use external synchronisation.

### Q156. What is the difference between `Arrays.asList()` and `List.of()`?
**Answer:** `Arrays.asList(array)` returns a fixed-size list backed by the array: `set` is supported, but adding/removing elements is not. `List.of(...)` creates an unmodifiable list, rejects null elements, and is available since Java 9. Neither produces a mutable `ArrayList` by itself.

### Q157. How do you create a mutable list from existing values?
**Answer:** Use `new ArrayList<>(List.of("a", "b"))` or `new ArrayList<>(Arrays.asList("a", "b"))`. This copies the element references into a resizable list, so changes to the list structure are permitted; the contained objects themselves are not deep-copied.

### Q158. What are unmodifiable and immutable collections?
**Answer:** An unmodifiable collection wrapper blocks modification through that wrapper, but the backing collection may still change through another reference. A collection created by `List.of` is unmodifiable and detached from an external mutable backing collection, but its elements may themselves be mutable. “Deep immutable” requires immutable elements or defensive copying.

### Q159. What is CopyOnWriteArrayList?
**Answer:** It is a thread-safe list that copies its backing array for mutative operations, while readers and iterators can traverse a stable snapshot. It works well for read-heavy, low-write use cases such as listener lists; frequent writes are expensive in CPU and memory.

### Q160. What is BlockingQueue?
**Answer:** `BlockingQueue` supports producer-consumer coordination: a take can wait while the queue is empty and a put can wait while a bounded queue is full. Implementations include `ArrayBlockingQueue`, `LinkedBlockingQueue`, and `PriorityBlockingQueue`; their capacity, ordering, and blocking behaviour differ.

### Q161. What is the difference between synchronized collections and concurrent collections?
**Answer:** Synchronized wrappers generally coordinate access using a shared lock and often require the caller to synchronise during iteration. Concurrent collections are designed with finer-grained or non-blocking techniques and provide specified concurrency semantics. Select based on required consistency and contention, not only on whether a class says “thread-safe.”

---

# 9. HashMap and Other Map Internals

### Q162. How does HashMap work internally in Java 8 and later OpenJDK implementations?
**Answer:** A hash is spread and used to choose an index in an internal bucket array. A bucket stores entries; collisions are handled with a linked bin and, when specified implementation thresholds and conditions are met, a red-black tree bin. Lookup compares hashes and then keys with equality semantics. The exact implementation thresholds are version-specific details.

### Q163. What happens during a HashMap collision?
**Answer:** Different keys can map to the same bucket. HashMap checks hash values and key equality to locate an existing mapping or add a new entry in that bucket. A collision does not automatically mean the keys are equal; equal hash codes are permitted for unequal objects.

### Q164. What happens if every key returns the same hash code?
**Answer:** All entries contend for one bucket, so lookup performance can degrade. In modern OpenJDK HashMap, sufficiently large collision bins may be treeified if capacity and other conditions permit. Tree bins can improve lookup substantially, especially for mutually comparable keys, but do not promise O(log n) in every pathological equal-hash case. A poor or malicious hash function can still hurt performance.

### Q165. What are load factor and capacity in HashMap?
**Answer:** Capacity is the bucket-array size, while load factor influences the threshold at which the map resizes. The default load factor is commonly 0.75 in standard JDK implementations. An initial capacity estimate can reduce rehashing for known large maps, but oversizing wastes memory.

### Q166. What happens when HashMap resizes?
**Answer:** When the entry count exceeds the threshold, the table grows and entries are redistributed according to the new capacity. In OpenJDK implementations the resize process can reuse hash bits to determine whether a node remains at its old index or moves by the old capacity, but avoid relying on implementation details in code.

### Q167. Can HashMap store null keys and values?
**Answer:** The standard `HashMap` permits one null key and multiple null values. This behaviour differs from `ConcurrentHashMap`, which rejects null keys and null values so a `null` result from `get` can mean “no mapping” without ambiguity about a stored null value.

### Q168. Is HashMap thread-safe?
**Answer:** No. Concurrent structural updates without external coordination can produce race conditions, lost updates, inconsistent observations, and other incorrect behaviour. Use `ConcurrentHashMap` for concurrent map operations or protect a normal map with a correctly used lock/synchronised wrapper.

### Q169. HashMap versus Hashtable versus ConcurrentHashMap?
**Answer:** `HashMap` is unsynchronised and allows null key/value entries. `Hashtable` is a legacy synchronised map that rejects null keys and values. `ConcurrentHashMap` is built for concurrent access, supports atomic compound operations such as `compute`, and rejects null keys/values. Prefer `ConcurrentHashMap` over `Hashtable` for most concurrent-map use cases.

### Q170. How does ConcurrentHashMap work internally?
**Answer:** In modern JDK implementations, reads are commonly non-blocking, while updates use CAS and synchronisation around affected bins rather than one lock for the entire map. It supports concurrent retrieval and updates and provides atomic methods such as `putIfAbsent`, `compute`, and `merge`. Do not confuse the Java 7 segmented implementation with modern Java 8+ internals.

### Q171. Why does ConcurrentHashMap disallow null keys and values?
**Answer:** In a concurrent map, `get(key) == null` must be unambiguous enough to represent an absent mapping. If stored null values were allowed, a concurrent update could make it hard to distinguish “no mapping” from “mapping currently has null” without another synchronised check. The API prevents that ambiguity by rejecting nulls.

### Q172. What happens if one thread reads and another updates a ConcurrentHashMap?
**Answer:** Map operations are thread-safe and have documented memory-consistency guarantees, but a retrieval is not a global snapshot of the entire map. A read may see an update according to the operation's concurrency guarantees; bulk traversal and aggregate methods can reflect transient states while updates are occurring.

### Q173. What are atomic map operations and why are they important?
**Answer:** Methods such as `putIfAbsent`, `computeIfAbsent`, `compute`, and `merge` combine a read/decision/update in one map operation. They avoid race conditions that can occur if code separately calls `get`, checks for null, and then calls `put`. The mapping function should be short and should not recursively update the same map in problematic ways.

### Q174. What is LinkedHashMap?
**Answer:** `LinkedHashMap` maintains a linked order in addition to hash-based lookup, typically insertion order or, when configured, access order. Access-order mode can help implement an LRU-style cache, but it is not a complete production cache by itself because it lacks built-in expiry, size policies, metrics, and concurrency guarantees.

### Q175. What is TreeMap?
**Answer:** `TreeMap` is a sorted map based on a balanced search tree and provides O(log n) for common get/put/remove operations. Keys are ordered by natural ordering or a comparator, and keys used with natural ordering must be mutually comparable. Its notion of key equivalence follows comparison results, so comparator consistency with `equals` matters.

### Q176. What is the difference between Comparable and Comparator?
**Answer:** `Comparable<T>` defines natural ordering inside the type through `compareTo(T other)`, while `Comparator<T>` defines an external or alternative ordering through `compare(T a, T b)`. A class should implement Comparable when one natural order is meaningful; use Comparator for multiple sorts, such as employee salary, name, or joining date. Both comparison methods return a negative, zero, or positive integer—not necessarily exactly -1, 0, or 1.

**Example:** `employees.sort(Comparator.comparingInt(Employee::getSalary).thenComparing(Employee::getName));`

### Q177. What is WeakHashMap?
**Answer:** `WeakHashMap` stores weak references to keys, so a mapping may disappear when its key is no longer strongly reachable elsewhere and the garbage collector processes the weak reference. Its contents can change as GC runs; it is not a deterministic cache. Be careful that a value which strongly references its own key can keep that key reachable and defeat the intended cleanup.

### Q178. What happens if a mutable object is used as a HashMap key and then mutated?
**Answer:** If mutation changes the fields used by `hashCode()` or `equals()`, the map may no longer be able to find the key in the bucket chosen at insertion time. Use immutable key types or ensure equality/hash fields do not change while the key is stored in the map.

### Q179. What is a red-black tree and why can HashMap use one?
**Answer:** A red-black tree is a self-balancing binary search tree that constrains its height to O(log n). HashMap's tree bins can reduce lookup cost under heavy bucket collisions. This does not make HashMap globally sorted; only a particular bucket's internal representation may be tree-based.

### Q180. HashSet vs HashMap?
**Answer:** A `HashSet<E>` models unique elements; a `HashMap<K,V>` associates keys with values. In common JDK implementations, HashSet uses a HashMap internally and stores elements as keys with a dummy value, but callers should choose the abstraction matching the requirement.

### Q181. What is EnumMap?
**Answer:** `EnumMap` is a specialised map with enum keys. It is compact and efficient because it can use the finite set of enum constants to organise storage; all keys must come from one enum type, and null keys are not permitted.

### Q182. What is IdentityHashMap?
**Answer:** `IdentityHashMap` compares keys using reference identity (`==`) instead of ordinary `equals()`. It is useful for specialised graph processing or identity-oriented algorithms, but it violates the usual `Map` equality convention and should not be the default choice for application maps.

---

# 10. Functional Interfaces, Lambdas, and Streams

### Q183. What is a functional interface?
**Answer:** A functional interface has exactly one abstract method, called its functional method, and can therefore be implemented with a lambda expression or method reference. It may still contain default methods, static methods, and methods matching public methods of `Object`. `@FunctionalInterface` asks the compiler to validate the contract.

### Q184. What is a lambda expression?
**Answer:** A lambda is a compact way to provide an implementation of a functional interface, for example `names.forEach(name -> System.out.println(name))`. It provides behaviour as a value without defining a named class explicitly, although the runtime representation is not specified as simply “a new anonymous class.”

### Q185. What is a method reference?
**Answer:** A method reference uses `::` to refer to an existing method or constructor when it matches the target functional interface, such as `String::toUpperCase` or `System.out::println`. It is a concise alternative to a compatible lambda, not an independent execution model.

### Q186. What are the main built-in functional interfaces?
**Answer:** `Predicate<T>` tests a value and returns boolean; `Function<T,R>` transforms a value; `Consumer<T>` accepts a value and returns no result; `Supplier<T>` produces a value without an input. Primitive specialisations such as `IntPredicate`, `IntFunction<R>`, and `IntConsumer` can avoid some boxing.

### Q187. What are `BiFunction`, `BiPredicate`, and `BiConsumer`?
**Answer:** These accept two input arguments: `BiFunction<T,U,R>` returns `R`, `BiPredicate<T,U>` returns boolean, and `BiConsumer<T,U>` returns void. They are useful for operations involving a key and value, two records, or combining two input values.

### Q188. What is Stream API?
**Answer:** The Stream API processes a sequence of elements through a pipeline of operations such as filtering, mapping, sorting, and reducing. Streams do not generally store their own elements; they process data from a source such as a collection, array, generator, or I/O source.

### Q189. How is a Stream different from a Collection?
**Answer:** A collection stores data and can usually be traversed repeatedly; a stream describes a computation over a source and is intended for one use. Stream operations can be lazy and compose into a pipeline, whereas collection methods such as `add` mutate the collection itself.

### Q190. What are intermediate and terminal Stream operations?
**Answer:** Intermediate operations such as `filter`, `map`, `distinct`, and `sorted` return another stream and are generally lazy. Terminal operations such as `collect`, `count`, `reduce`, `forEach`, and `findFirst` trigger processing and produce a result or side effect. After a terminal operation, the stream should not be reused.

### Q191. What is lazy evaluation in Stream API?
**Answer:** Intermediate stream operations usually do not run until a terminal operation needs their results. The implementation can combine pipeline stages and sometimes stop early—for example, `findFirst()` may not process every element. Do not rely on intermediate side effects to execute unless the operation's semantics guarantee it.

### Q192. What is the difference between `map()` and `flatMap()`?
**Answer:** `map` transforms each element into one result; `flatMap` transforms each element into a stream-like result and flattens those nested results into one stream. For example, mapping students to lists of courses creates `Stream<List<Course>>`; flat-mapping their courses creates one `Stream<Course>`.

### Q193. What is `filter()`?
**Answer:** `filter(Predicate)` keeps only elements for which the predicate returns true and returns a new stream stage. It does not modify the source collection and is typically lazy until a terminal operation executes the pipeline.

### Q194. What is the difference between `collect()` and `Collectors`?
**Answer:** `collect()` is a terminal Stream method that performs a mutable or collector-defined reduction. `Collectors` is a utility class supplying collector implementations such as `toList`, `groupingBy`, `partitioningBy`, `joining`, and `counting`.

### Q195. How does `Collectors.groupingBy()` work?
**Answer:** It classifies each input element using a key function and groups elements by that key. For example, `employees.stream().collect(groupingBy(Employee::department))` builds a map from department to employee list. Overloads allow a downstream collector such as `counting()` or `mapping()`.

### Q196. `groupingBy()` versus `partitioningBy()`?
**Answer:** `groupingBy` groups into potentially many keys. `partitioningBy(predicate)` always models a boolean split into the `true` and `false` partitions, even if one partition has no elements. Use the one that expresses the domain classification most clearly.

### Q197. What is `reduce()`?
**Answer:** `reduce` combines stream elements into one result using an associative accumulation operation, such as summing numbers. For parallel reductions, the operation and identity must satisfy the required algebraic properties; using a non-associative operation or shared mutable state can produce incorrect or order-dependent results.

### Q198. What is the difference between `findFirst()` and `findAny()`?
**Answer:** `findFirst()` returns the first element according to encounter order when an encounter order exists. `findAny()` may return any matching element and can allow more flexibility in parallel execution. Both return an `Optional` because the stream may be empty.

### Q199. What is `distinct()` based on?
**Answer:** `distinct()` identifies duplicates using `equals()` semantics. For object streams, a correct `equals()` implementation is therefore important; hash-based tracking may also use `hashCode()`. It preserves encounter order for ordered streams but may cost memory to track previously seen values.

### Q200. What is the difference between `forEach()` and `forEachOrdered()`?
**Answer:** `forEach()` does not guarantee encounter order for parallel streams. `forEachOrdered()` preserves encounter order when the stream has one, which may reduce parallelism. Prefer transformations and terminal reductions over side effects whenever possible.

### Q201. What is a parallel stream?
**Answer:** A parallel stream partitions stream work so multiple workers may process elements concurrently, commonly through the ForkJoin common pool for standard collection pipelines. Parallelism is not automatically faster; it can hurt for small inputs, blocking work, poor splitting, ordering requirements, or shared mutable state.

### Q202. What are the risks of side effects in Stream pipelines?
**Answer:** Side effects can make execution order, parallel behaviour, and correctness hard to reason about. Avoid modifying the source collection during its own traversal or updating non-thread-safe shared state inside a parallel pipeline. Prefer `map`, `filter`, `collect`, and reductions that express the intended transformation.

### Q203. What is a primitive stream?
**Answer:** `IntStream`, `LongStream`, and `DoubleStream` represent primitive numeric pipelines and provide operations such as `sum`, `average`, `range`, and primitive mapping methods. They can reduce boxing overhead and offer numeric operations unavailable directly on `Stream<Integer>`.

### Q204. How can a stream be created?
**Answer:** Common sources include `collection.stream()`, `collection.parallelStream()`, `Arrays.stream(array)`, `Stream.of(...)`, `Stream.empty()`, `Stream.generate(...)`, `Stream.iterate(...)`, and primitive ranges such as `IntStream.range(0, n)`. Infinite streams should generally be bounded or use short-circuiting terminals.

### Q205. What is `peek()` for?
**Answer:** `peek()` attaches an action to elements as they pass through a pipeline and is mainly useful for debugging. It is not a reliable substitute for a terminal action because lazy or optimised execution can mean some elements are never processed. Do not use it for essential business side effects.

### Q206. What does `Collectors.toMap()` do when keys collide?
**Answer:** The two-argument form throws `IllegalStateException` if duplicate keys occur. Use the overload that accepts a merge function when duplicates are expected, for example `(oldValue, newValue) -> oldValue + newValue`, and make that rule explicit.

---

# 11. Optional and Modern Functional APIs

### Q207. What is `Optional`?
**Answer:** `Optional<T>` represents either a present non-null value or no value. It makes the possibility of an absent result explicit and supports operations such as `map`, `flatMap`, `filter`, `orElse`, and `orElseThrow`. It is primarily intended for method return types where “no result” is a meaningful outcome.

### Q208. How do `Optional.of()`, `ofNullable()`, and `empty()` differ?
**Answer:** `Optional.of(value)` requires a non-null value and throws `NullPointerException` when passed null. `ofNullable(value)` creates an empty Optional for null and a present one otherwise. `Optional.empty()` explicitly creates an empty Optional.

### Q209. What is the difference between `orElse()` and `orElseGet()`?
**Answer:** `orElse(defaultValue)` evaluates the default expression before the method call even when a value is present. `orElseGet(supplier)` invokes the supplier only if the Optional is empty. Use `orElseGet` when computing the fallback is expensive or has a side effect.

### Q210. What does `Optional.map()` do?
**Answer:** If a value is present, `map` applies a function and wraps the possibly-null result as an empty Optional; if empty, it does not apply the function. This lets a chain transform a possibly absent result without manually checking every step.

### Q211. What is `Optional.flatMap()` used for?
**Answer:** Use `flatMap` when the mapping function already returns an Optional. It avoids a nested `Optional<Optional<T>>` result and propagates absence through the chain. A mapper passed to `flatMap` must return a non-null Optional.

### Q212. Does Optional eliminate all NullPointerExceptions?
**Answer:** No. The Optional reference itself can be null if poorly designed, a value retrieved from other APIs can be null, and methods inside the mapping function can still throw. Optional provides a structured representation of absence; it does not automatically make all code null-safe.

### Q213. Should Optional be used for every field, parameter, and collection element?
**Answer:** Usually no. Its main purpose is method return values that may be absent. Using Optional for every field or parameter adds wrapping and API complexity; an empty collection is often clearer than `Optional<List<T>>` when “no items” is the only absent state.

### Q214. Can Optional contain null?
**Answer:** A correctly created Optional never represents a present null value. `Optional.of(null)` throws, and `Optional.ofNullable(null)` becomes empty. The Optional variable itself should also never be assigned null.

### Q215. What is `Predicate.and()`, `or()`, and `negate()`?
**Answer:** These methods compose predicates: `and` requires both predicates, `or` accepts either, and `negate` reverses the result. Evaluation short-circuits for `and` and `or`, which can be useful to place a null or range check before a potentially unsafe condition.

### Q216. What are `Function.andThen()` and `compose()`?
**Answer:** `andThen(after)` applies the current function first, then `after`; `compose(before)` applies `before` first, then the current function. If `f` transforms A to B and `g` transforms B to C, `f.andThen(g)` is equivalent to `g(f(a))`.

### Q217. What is the difference between `map()` on Optional and `map()` on Stream?
**Answer:** `Optional.map()` transforms zero or one present value and returns another Optional. `Stream.map()` transforms each element in a possibly many-element pipeline and returns a Stream. They share a transformation idea but have different cardinality and terminal-processing semantics.

### Q218. Why were default and static methods added to interfaces in Java 8?
**Answer:** Default methods allow interfaces to add compatible behaviour without requiring every existing implementation to add an override. Static methods group utility operations with the interface that conceptually owns them. Neither mechanism makes interfaces equivalent to classes with ordinary instance state.

### Q219. What are lambda variable-capture rules?
**Answer:** A lambda can capture local variables only when they are final or effectively final. The captured variable cannot be reassigned after initialisation, although an object referenced by that variable may be mutable. That mutability can still introduce data races when shared between threads.

### Q220. How do you find duplicate elements with Streams?
**Answer:** One option is to use a mutable `Set` inside a filter: `Set<T> seen = new HashSet<>(); list.stream().filter(x -> !seen.add(x)).toList()`. This is appropriate for a sequential stream; the mutable set is not thread-safe for parallel use. For parallel processing use a properly designed collector or concurrent data structure.

---

# 12. Multithreading Fundamentals

### Q221. What is a thread in Java?
**Answer:** A thread is an independent path of execution within a process. Java threads can run concurrently, share heap objects, and compete for CPU time. Concurrency introduces risks such as race conditions, visibility problems, deadlocks, and contention that do not appear in the same way in purely sequential code.

### Q222. What are the common ways to execute work on a thread?
**Answer:** You can extend `Thread`, implement `Runnable`, implement `Callable<V>` and submit it to an executor, or submit a lambda to an executor. In application code, separate the task from the thread and normally use `ExecutorService` or another managed concurrency abstraction instead of creating raw threads for every task.

### Q223. `Thread` versus `Runnable`?
**Answer:** `Thread` represents a thread of execution and can also hold a task. `Runnable` represents a task with a `void run()` method and can be executed by a thread or executor. Implementing `Runnable` separates the work from thread management and leaves the class free to extend another class.

### Q224. `Runnable` versus `Callable`?
**Answer:** `Runnable.run()` returns no result and cannot declare checked exceptions. `Callable<V>.call()` returns a result and can throw checked exceptions, which an executor can report through a `Future<V>`. Use `Callable` when the task needs to produce a value or signal checked failure.

### Q225. What is the difference between `start()` and `run()`?
**Answer:** `start()` asks the JVM to start a new thread, which then invokes `run()` on that thread. Calling `run()` directly is an ordinary method call on the current thread; it does not start a separate thread. A thread object cannot be started more than once.

### Q226. What are Java thread states?
**Answer:** `Thread.State` defines `NEW`, `RUNNABLE`, `BLOCKED`, `WAITING`, `TIMED_WAITING`, and `TERMINATED`. `RUNNABLE` includes threads that are actually executing and those eligible to run; it is not split into distinct Java enum states for running and ready.

### Q227. What is the lifecycle of a thread?
**Answer:** A newly created thread is `NEW`; after `start()` it can become `RUNNABLE`, then may block or wait, and eventually reach `TERMINATED` when `run()` completes. These states are observed via `getState()` and are not a deterministic scheduling API—thread state can change immediately after it is read.

### Q228. What does `sleep()` do?
**Answer:** `Thread.sleep()` pauses the current thread for at least the requested duration subject to scheduler and timing effects. It does not release monitors the thread already owns. It throws `InterruptedException` if interrupted while sleeping and should not be used as a substitute for proper coordination.

### Q229. What does `wait()` do, and how is it different from `sleep()`?
**Answer:** `wait()` must be called while holding the monitor for that object; it releases that monitor and waits for notification, interruption, or timeout. `sleep()` pauses the current thread but keeps monitors it holds. Use `wait`/`notify` only with a correct shared-state protocol, usually inside a condition-checking loop.

### Q230. Why must `wait()`, `notify()`, and `notifyAll()` be called inside synchronized code for that monitor?
**Answer:** These methods operate on an object's monitor. Calling them without owning the object's monitor throws `IllegalMonitorStateException`. The synchronisation also protects the condition check and notification protocol; merely placing a `notify()` somewhere in code does not guarantee a waiting thread will observe a valid state transition.

### Q231. What is the difference between `notify()` and `notifyAll()`?
**Answer:** `notify()` wakes one arbitrarily chosen thread waiting on that object's monitor; `notifyAll()` wakes all such waiters, which then compete to reacquire the monitor. With multiple different conditions, `notifyAll()` is often safer because the single woken thread may not be waiting for the condition that just became true, though waking all can add contention.

### Q232. Why should `wait()` normally be inside a `while` loop?
**Answer:** A thread can wake without the condition it needs being true, including because of spurious wakeups, competition with another thread, or notification for another condition. The loop rechecks the shared-state predicate after reacquiring the monitor and waits again if necessary.

### Q233. What is synchronization in Java?
**Answer:** `synchronized` acquires an intrinsic monitor so only one thread at a time can execute a synchronised region guarded by that same monitor. It also establishes visibility ordering: unlocking a monitor happens-before a subsequent lock of the same monitor. The lock must consistently guard the shared state to provide the intended safety.

### Q234. Synchronized method versus synchronized block?
**Answer:** A synchronized instance method locks `this`; a synchronized static method locks the `Class` object. A synchronized block lets you select a particular lock object and restricts the critical section. Use a private final lock object when you want to avoid exposing the object's monitor to outside code.

### Q235. What is a race condition?
**Answer:** A race condition occurs when correctness depends on an unpredictable timing or interleaving of operations. For example, `count++` is a read-modify-write sequence, not an atomic increment; two threads may read the same old value and overwrite one another's update. Use locking, atomic variables, or an appropriate concurrent abstraction.

### Q236. What is a critical section?
**Answer:** A critical section is the part of a program that accesses shared mutable state and must be coordinated to preserve invariants. Keep it as small as practical but large enough to make the whole logical operation atomic; splitting a multi-step invariant across unrelated locks can reintroduce races.

### Q237. What is a deadlock?
**Answer:** A deadlock occurs when two or more threads wait forever for resources held by one another. A common pattern is thread A holding lock 1 while waiting for lock 2, and thread B holding lock 2 while waiting for lock 1. Prevent it by using a consistent lock ordering, reducing nested locking, and analysing thread dumps when it occurs.

### Q238. What is livelock?
**Answer:** In a livelock, threads remain active and respond to each other but make no useful progress—for example, both repeatedly back off and retry in sync. Randomised/exponential backoff, better coordination, or a different algorithm can reduce livelock; it differs from deadlock because the threads are not necessarily blocked.

### Q239. What is starvation?
**Answer:** Starvation occurs when a thread repeatedly fails to get CPU time or a required lock/resource because other work is continually favoured. Fair locks can reduce some forms of lock starvation, but fairness can reduce throughput and does not solve every scheduling problem.

### Q240. What is a daemon thread?
**Answer:** A daemon thread is background work that does not prevent the JVM from exiting once only daemon threads remain. Set daemon status before calling `start()`. Daemon threads are suitable for some background services but not for essential cleanup or data persistence, because the JVM may exit without waiting for them.

### Q241. What is interruption in Java?
**Answer:** Interruption is a cooperative cancellation signal. Calling `interrupt()` sets a thread's interrupt status and may cause methods such as `sleep`, `wait`, or `join` to throw `InterruptedException`, clearing the status as specified. Code should respond by stopping or propagating interruption rather than swallowing it silently.

### Q242. How should code handle `InterruptedException`?
**Answer:** If the method can propagate it, declare and rethrow it. If it must handle the exception, usually restore the interrupt status using `Thread.currentThread().interrupt()` and exit or cancel the work where appropriate. Ignoring interruption can make shutdown and cancellation unreliable.

### Q243. What is thread safety?
**Answer:** A component is thread-safe when it behaves correctly under the concurrent access covered by its contract. Thread safety can be achieved through immutability, confinement, synchronisation, atomics, or concurrent data structures. A class having some synchronised methods does not automatically make every compound operation on it thread-safe.

### Q244. What is thread confinement?
**Answer:** Thread confinement means data is accessed by only one thread, so it does not need inter-thread synchronisation for that access pattern. Local variables and carefully managed thread-local state are examples. Passing a confined mutable object to another thread breaks the assumption unless ownership is transferred safely.

---

# 13. Executors, Thread Pools, and Async Results

### Q245. What is ExecutorService?
**Answer:** `ExecutorService` separates task submission from the mechanics of running tasks. It can manage worker threads, return `Future` handles, shut down gracefully, and reject submissions after shutdown. Prefer a managed executor to creating an unbounded number of raw threads in request-handling code.

### Q246. What is a thread pool?
**Answer:** A thread pool reuses worker threads to execute many submitted tasks, avoiding the overhead and resource cost of creating a new platform thread for every task. A bounded pool and bounded queue also provide resource limits, but the pool must be configured according to the workload and downstream capacity.

### Q247. How does ThreadPoolExecutor decide what to do with a submitted task?
**Answer:** In the general JDK `ThreadPoolExecutor` policy, it creates workers until `corePoolSize`, then queues tasks; when the queue is full it may create more workers up to `maximumPoolSize`; if both the pool and queue are saturated, it invokes the configured rejection handler. An unbounded queue can mean the maximum pool size is never meaningfully reached and queued work grows without bound.

### Q248. What are core pool size, maximum pool size, and keep-alive time?
**Answer:** `corePoolSize` is the baseline worker count, `maximumPoolSize` is the upper bound for workers when queueing policy allows it, and keep-alive time controls how long excess idle workers wait before termination (with core-thread time-out configurable). These settings interact with the queue type, so they should not be tuned independently.

### Q249. What are common thread-pool rejection policies?
**Answer:** `AbortPolicy` throws `RejectedExecutionException`; `CallerRunsPolicy` executes the task in the submitting thread (unless the executor is shut down); `DiscardPolicy` silently drops it; `DiscardOldestPolicy` drops the queue head and retries. Dropping tasks is dangerous unless the task is explicitly disposable; choose an observable, deliberate overload policy.

### Q250. How should you size a thread pool?
**Answer:** For CPU-bound work, a pool near the number of available processors is a starting hypothesis, not a universal rule. For blocking I/O, more concurrent tasks may be reasonable, but sizing must consider response time, memory, connection pools, rate limits, and downstream capacity. Measure throughput and latency under realistic load rather than relying on one fixed formula.

### Q251. What is `Future`?
**Answer:** A `Future<V>` represents the eventual result of a computation. It supports status checks, cancellation, and retrieval using `get()`. `get()` blocks until the result is ready (or times out when using the timed overload), so a caller can accidentally turn an asynchronous submission into synchronous waiting.

### Q252. What is `CompletableFuture`?
**Answer:** `CompletableFuture<T>` implements both `Future<T>` and `CompletionStage<T>`. It supports callback chains, combining independent work, manual completion, and structured exception-handling stages. It does not automatically make a blocking operation non-blocking, and executor choice matters for execution and isolation.

### Q253. `Future` versus `CompletableFuture`?
**Answer:** `Future` mainly provides a handle to check, cancel, and retrieve a computation result. `CompletableFuture` adds a composable pipeline through operations such as `thenApply`, `thenCompose`, `thenCombine`, `handle`, and `exceptionally`. It is typically easier to coordinate asynchronous tasks without blocking on every intermediate result.

### Q254. What is the difference between `get()` and `join()` on CompletableFuture?
**Answer:** Both wait for completion if needed. `get()` declares checked `InterruptedException` and `ExecutionException` (and has a timed form); `join()` reports exceptional completion via unchecked `CompletionException` and has no checked interruption signature. This affects API design, error handling, and interruption propagation.

### Q255. `thenApply()` versus `thenCompose()`?
**Answer:** `thenApply` transforms a result into another value. `thenCompose` chains a function that itself returns a `CompletionStage`, flattening the nested asynchronous result. It is similar to the difference between `map` and `flatMap` on other APIs.

### Q256. What does `thenCombine()` do?
**Answer:** It combines results from two independent completion stages after both complete normally. Use it when tasks can run independently and a final function requires both values; if the second task depends on the first task's result, use a chaining operation such as `thenCompose` instead.

### Q257. How does `CompletableFuture` choose a thread?
**Answer:** Non-async continuation methods may execute on the thread that completes the previous stage or another thread participating in completion. Async methods without an explicit executor generally use the common ForkJoinPool. Pass an explicit executor when you need resource isolation or want to control where work runs.

### Q258. How do you handle CompletableFuture exceptions?
**Answer:** `exceptionally` maps failure to a fallback value, `handle` processes either a value or exception, and `whenComplete` observes completion while preserving the original result/failure unless the callback itself fails. Pick based on whether the intent is recovery, transformation, or observation; avoid converting every failure into a misleading default.

### Q259. Does `@Async` belong to Core Java?
**Answer:** No. `@Async` is a Spring Framework feature that schedules method execution through Spring's proxy/executor configuration. The underlying concurrency concepts—executors, task submission, thread pools, `Future`, and `CompletableFuture`—are Core Java. Keep framework-specific annotation questions in a Spring guide.

### Q260. Why is `Executors.newFixedThreadPool()` not always safe for production?
**Answer:** It uses a shared unbounded work queue by default, so if tasks arrive faster than they complete, pending work can grow without a hard bound and cause latency and memory pressure. For overload-sensitive services, explicitly configure a `ThreadPoolExecutor` with a bounded queue and a suitable rejection/backpressure policy.

### Q261. How do you shut down an ExecutorService correctly?
**Answer:** Call `shutdown()` to reject new tasks while allowing submitted tasks to complete; wait with `awaitTermination`. If the timeout expires, call `shutdownNow()` to attempt interruption of active tasks and return queued tasks that never started. Tasks must cooperate with interruption for prompt shutdown.

### Q262. What is ScheduledExecutorService?
**Answer:** It supports delayed execution and periodic tasks, for example `schedule`, `scheduleAtFixedRate`, and `scheduleWithFixedDelay`. Fixed-rate scheduling targets a regular cadence; fixed-delay scheduling waits a delay after one execution completes before scheduling the next. Handle exceptions carefully because an uncaught exception can suppress later executions of a periodic task.

### Q263. What is ForkJoinPool?
**Answer:** `ForkJoinPool` is designed for tasks that split into smaller subtasks and later combine results, using work-stealing so idle workers can take tasks from other workers' queues. It underpins common parallel-stream execution in standard Java. Blocking operations can impair worker utilisation unless handled deliberately.

### Q264. What is work-stealing?
**Answer:** Each worker often processes tasks from its own deque and may steal tasks from other workers when idle. This supports load balancing for many small independent tasks. It is especially effective for fork/join computations but is not a general cure for blocking I/O or badly partitioned work.

---

# 14. Java Memory Model, Locks, CAS, and Advanced Concurrency

### Q265. What is the Java Memory Model (JMM)?
**Answer:** The JMM defines when writes made by one thread become visible to another and which instruction reorderings are permitted. It provides rules such as happens-before relationships through synchronisation, volatile access, thread start/join, and safe publication. Correct concurrent code must rely on these guarantees rather than assuming a particular CPU execution order.

### Q266. What does `volatile` guarantee?
**Answer:** A volatile write happens-before subsequent reads of that same variable, and volatile accesses provide visibility and ordering guarantees. It does not make a multi-step operation such as `count++` atomic, nor does it automatically make other fields guarded by that variable thread-safe unless the design establishes the required protocol.

### Q267. `volatile` versus `synchronized`?
**Answer:** `volatile` is suited to visibility and ordering for individual variable reads/writes, while `synchronized` provides mutual exclusion and visibility around a critical section. Use a lock when correctness depends on an invariant across multiple operations or fields; don't replace a lock with volatile merely to reduce overhead.

### Q268. What is happens-before?
**Answer:** Happens-before is a JMM ordering and visibility relationship. For example, actions before releasing a monitor happen-before actions after another thread acquires that same monitor; a volatile write happens-before a subsequent read of that variable; and actions before `Thread.start()` happen-before actions in the started thread. It does not mean one event must physically occur much earlier in wall-clock time.

### Q269. What is safe publication?
**Answer:** Safe publication ensures another thread observes an object in a correctly initialised state. Techniques include publishing through a volatile field, a final field safely constructed and not leaking `this`, a synchronised handoff, or a thread-safe collection. Merely assigning a reference to a shared non-volatile field without coordination can be insufficient.

### Q270. What are atomic classes such as AtomicInteger?
**Answer:** `AtomicInteger`, `AtomicLong`, and related classes offer atomic operations such as increment, compare-and-set, and update. They are useful for independently updated values without a user-managed lock, but a group of separate atomic variables does not automatically provide an atomic transaction across all of them.

### Q271. What is CAS (Compare-And-Swap)?
**Answer:** CAS atomically compares a memory location with an expected value and, only if it matches, changes it to a new value. It allows lock-free algorithms to retry on contention, as used by atomic classes and concurrent collections. CAS can fail because another thread changed the value, so code often loops and retries; it does not itself guarantee fairness or eliminate all contention.

### Q272. What is the ABA problem in CAS?
**Answer:** A CAS operation may observe value A, then another thread changes A to B and back to A. The CAS sees A again and may incorrectly assume nothing changed. Version stamps or stamped/marked references can detect the intermediate change when the algorithm needs that distinction.

### Q273. Synchronized versus ReentrantLock?
**Answer:** Both provide mutual exclusion. `ReentrantLock` supports features such as timed/interruptible lock acquisition and optional fairness, and it must be unlocked in `finally`. `synchronized` is simpler and automatically releases the monitor when control exits; choose the extra capabilities of `Lock` only when they solve a real need.

### Q274. What is ReadWriteLock?
**Answer:** A `ReadWriteLock` allows multiple read-lock holders but generally grants exclusive write access. It can improve throughput for read-heavy data with meaningful read duration, but bookkeeping and writer contention can make it slower than a simple lock for small critical sections. Measure before using it.

### Q275. What is Semaphore?
**Answer:** A semaphore maintains a count of permits. A thread acquires a permit before entering a constrained region and releases it after; this can limit concurrent access to a resource such as a connection pool or external endpoint. Unlike a mutex, a semaphore can allow more than one concurrent permit holder.

### Q276. What is CountDownLatch versus CyclicBarrier?
**Answer:** `CountDownLatch` lets threads wait until a one-shot count reaches zero and cannot be reset. `CyclicBarrier` lets a fixed group of threads meet at a barrier and can be reused for another phase. `Phaser` provides a more flexible number of participants and phases.

### Q277. What is ThreadLocal?
**Answer:** `ThreadLocal<T>` gives each thread its own independently initialised value. It can carry thread-confined context such as a request identifier, but values in pooled worker threads can outlive one task unless removed. Use `try/finally` cleanup with `remove()` when per-task state must not leak across tasks.

### Q278. Why can ThreadLocal cause a memory leak?
**Answer:** Pooled threads may live for a long time, and their thread-local values can remain reachable after a request completes if the value is not removed. Weak references to ThreadLocal keys do not necessarily remove the associated value immediately. Clean up in a `finally` block and avoid storing large request-specific object graphs indefinitely.

### Q279. What is a virtual thread?
**Answer:** A virtual thread is a lightweight Java thread managed by the JVM rather than being permanently mapped one-to-one to an operating-system thread. It makes thread-per-task programming practical for many blocking-I/O workloads. Virtual threads do not make CPU-bound work execute faster and are not intended to be pooled as scarce worker resources.

### Q280. Platform thread versus virtual thread?
**Answer:** Platform threads are backed more directly by OS threads and are comparatively heavyweight. Virtual threads are cheap to create at high counts and can unmount while waiting on supported blocking operations so the carrier can run other virtual threads. In Java 21, some blocking while a virtual thread is pinned (for example, in certain `synchronized` or native-code situations) can keep its carrier occupied; pinning behaviour changed in later JDK releases, so state the version when discussing it. Application design should still bound database connections, API concurrency, memory, and other scarce resources.

### Q281. How do you create virtual threads in Java 21?
**Answer:** Use `Thread.startVirtualThread(task)`, `Thread.ofVirtual().start(task)`, or an executor such as `Executors.newVirtualThreadPerTaskExecutor()`. Virtual threads were finalised in Java 21 by JEP 444. Do not confuse this with preview status in earlier releases.

### Q282. Should you pool virtual threads?
**Answer:** Usually no. Virtual threads are designed to be created per task rather than reused as a constrained worker pool. Limit access to scarce resources using semaphores, connection pools, rate limits, or other domain controls instead of using a thread pool to cap virtual-thread count.

### Q283. What is a thread dump, and how does it help with concurrency debugging?
**Answer:** A thread dump is a snapshot of thread states and stack traces, including monitor/lock information. It can reveal deadlocks, many blocked threads, pool starvation, stuck requests, and repeated hot stack frames. Several dumps taken over time are often more useful than a single snapshot because they show whether stacks are progressing.

### Q284. What is the difference between concurrency and parallelism?
**Answer:** Concurrency means multiple tasks make progress over overlapping time periods; parallelism means tasks execute at the same instant on different execution resources. A single-core system can support concurrency by interleaving tasks without executing them in parallel.

---

# 15. JVM Memory, Garbage Collection, and Class Loading

### Q285. What are the main JVM runtime memory areas?
**Answer:** The JVM specification defines per-thread program counters and JVM stacks, plus shared areas including the heap and method area. A practical HotSpot JVM also uses native memory areas such as Metaspace and code cache. The specification describes logical runtime areas; exact physical layout is implementation-dependent.

### Q286. Stack versus heap memory?
**Answer:** Each thread has its own JVM stack containing frames for method calls, local variables, and intermediate computation state. The heap is shared and is the normal allocation area for objects and arrays. Do not oversimplify by saying every local variable is always physically on the stack: JIT optimisation can keep values in registers or eliminate allocations.

### Q287. What is Metaspace, and how does it differ from PermGen?
**Answer:** Metaspace stores class metadata in native memory in HotSpot and replaced PermGen starting in Java 8. PermGen was a HotSpot implementation area in older Java versions. Metaspace can still exhaust available memory or hit a configured limit; removing PermGen did not make class metadata use unlimited free memory.

### Q288. What is a Java memory leak if Java has garbage collection?
**Answer:** A leak occurs when objects that the application no longer needs remain reachable from GC roots, so the collector cannot reclaim them. Typical causes include static collections that continually grow, caches without eviction, retained listeners, unremoved ThreadLocal values, and accidental references in long-lived objects.

### Q289. What are GC roots?
**Answer:** GC roots are starting points used by the collector to determine object reachability. They include references from active thread stacks/registers, static references, JNI references, and other JVM/runtime structures. An object reachable transitively from a GC root is normally considered live even if the business logic no longer needs it.

### Q290. How does garbage collection work at a high level?
**Answer:** A tracing collector identifies reachable objects from roots and reclaims memory occupied by unreachable objects. Generational collectors exploit the observation that many objects die young, so they collect young regions frequently and older regions less often. The exact algorithms and pause/concurrency characteristics depend on the selected collector and JVM version.

### Q291. What are common garbage collectors in HotSpot?
**Answer:** Common HotSpot collectors include Serial, Parallel, G1, and ZGC; availability and maturity vary by Java version and build. G1 is the general-purpose default in many modern HotSpot configurations, while ZGC targets very low pause times. Choose based on latency, throughput, heap size, and measured behaviour—not by assuming one collector is always best.

### Q292. What is the difference between minor, major, and full GC?
**Answer:** These labels are commonly used in collector logs and tuning discussions, but exact meanings are collector-specific rather than a universal set of JVM operations. A young/ minor collection focuses on young-generation regions; a full GC typically examines or compacts a broader heap and often has greater pause impact. Read the actual collector's logs and documentation for precise semantics.

### Q293. When does garbage collection run?
**Answer:** The JVM decides when to collect based on allocation pressure, collector heuristics, available memory, and configured policy. `System.gc()` is only a request/hint and does not guarantee a collection or that a particular object will be reclaimed immediately. Never write correctness logic that depends on GC timing.

### Q294. How can an object become eligible for garbage collection?
**Answer:** It becomes eligible when it is no longer strongly reachable from GC roots, assuming no other mechanism keeps it alive. Assigning one reference to null is not sufficient if aliases or other object graphs still refer to the object. Eligibility also does not mean collection occurs immediately.

### Q295. Soft, weak, and phantom references: what is the difference?
**Answer:** Strong references keep objects reachable. Soft references may be cleared under memory pressure and have historically been used for caches, though explicit bounded caches are usually more predictable. Weak references do not keep referents alive for ordinary reachability, while phantom references support post-mortem cleanup coordination through a `ReferenceQueue` and cannot retrieve the referent through `get()`.

### Q296. What is `OutOfMemoryError`?
**Answer:** It means the JVM or runtime could not satisfy a memory allocation. It may occur because the Java heap is full, Metaspace is exhausted, native threads cannot be created, direct/native memory is exhausted, or another runtime resource is depleted. Diagnose the exact message, GC logs, heap dumps, native-memory information, and process limits rather than increasing `-Xmx` automatically.

### Q297. What causes `StackOverflowError`?
**Answer:** It usually occurs when a thread's stack cannot grow enough for additional frames, often because of deep or infinite recursion. Fix the recursion termination or use an iterative algorithm where appropriate. Increasing the stack size may postpone the error but does not fix unbounded recursion.

### Q298. What is the difference between a heap dump and a thread dump?
**Answer:** A heap dump captures object allocations, retained references, and heap state for memory analysis. A thread dump captures thread stacks, states, monitors, and locks for diagnosing stalls or deadlocks. Use a heap analyzer such as Eclipse MAT for a heap dump and inspect thread dumps over time for stuck execution.

### Q299. How do you investigate a memory leak in production?
**Answer:** Correlate steadily rising post-GC heap occupancy with traffic and workload; collect GC logs, heap dumps, and allocation/retention profiles; identify large dominators and their paths to GC roots; then fix the retaining reference or unbounded resource. Validate by repeating the workload and checking that live-set size stabilises.

### Q300. What is the class-loading lifecycle?
**Answer:** Broadly, classes are loaded, linked, and initialized. Linking includes verification, preparation, and resolution (which can be lazy within specification constraints). Initialization executes static field initializers and static initializer blocks in the required order before certain active uses of the class.

### Q301. What is the parent-delegation model of ClassLoader?
**Answer:** A typical class loader delegates a class-loading request to its parent before trying to load the class itself. This helps avoid duplicate loading of core classes and supports shared type identity. Custom loaders can use different delegation policies for specialised environments, but breaking parent delegation requires careful isolation and security consideration.

### Q302. What is the usual ClassLoader hierarchy in modern Java?
**Answer:** The Bootstrap ClassLoader loads core platform classes; the Platform ClassLoader loads platform modules and libraries outside the bootstrap set; and the Application (System) ClassLoader loads application classes from the classpath or configured application locations. Parent delegation normally asks the parent first, helping preserve a consistent identity for core types. Exact loader implementations and module configurations vary by runtime.

**Version trap:** Java 9 replaced the old Extension ClassLoader model with the Platform ClassLoader as part of the module-system changes.

### Q303. What is the difference between `ClassNotFoundException` and `NoClassDefFoundError`?
**Answer:** `ClassNotFoundException` is a checked exception often thrown when code explicitly tries to load a class by name and the loader cannot find it. `NoClassDefFoundError` is a linkage error raised when the JVM or loader needs a class definition that was available/expected at compile time but cannot be resolved at runtime, or class initialization previously failed. Check dependencies, packaging, classpath/module path, and earlier initialization errors.

### Q304. What is static class initialization?
**Answer:** A class is initialized when the JVM determines its initialization is required by an active use, such as certain static member accesses or instance creation. Static field initializers and static blocks run in textual order, with superclass initialization rules. Loading a class does not always immediately initialise it.

### Q305. What is static versus dynamic class loading?
**Answer:** “Static loading” is an informal phrase for classes referenced and resolved through ordinary program linkage, while “dynamic loading” commonly means requesting a class by name at runtime using mechanisms such as `Class.forName` or a custom `ClassLoader`. JVM resolution can be lazy, so these labels are simplified interview terminology rather than two formal class-loading phases.

### Q306. Can a class be unloaded?
**Answer:** Class unloading is possible when the class's defining class loader becomes reclaimable and the runtime can reclaim its loaded classes. Classes loaded by long-lived loaders—especially the bootstrap loader—are generally not unloaded during ordinary application life. ClassLoader leaks can therefore cause Metaspace growth in application servers and plugin systems.

### Q307. What is JIT compilation?
**Answer:** A just-in-time compiler compiles bytecode into native code during execution, typically focusing on frequently executed code. It can use runtime profiling for optimisations such as inlining and speculative optimisation with deoptimisation when assumptions fail. Warm-up can affect benchmark results, so measure Java performance with suitable tools and warm-up methodology.

### Q308. What is escape analysis?
**Answer:** Escape analysis lets a JIT compiler estimate whether an object reference can escape a method or thread. When safe, the JVM may eliminate an allocation through scalar replacement or optimise locking. It is an optimisation opportunity, not a promise that an object's source-level allocation always corresponds to a physical heap allocation.

### Q309. What is direct memory?
**Answer:** Direct byte buffers can use memory outside the ordinary Java heap, which can be useful for I/O operations. This memory still consumes process resources and can lead to allocation failures even when Java heap usage appears low. Monitor direct-buffer usage and native memory as well as heap usage.

### Q310. Why is `finalize()` deprecated, and what should replace it?
**Answer:** Finalization has unpredictable timing, performance costs, security problems, and no reliable guarantee that cleanup happens promptly. Use try-with-resources for deterministic cleanup of `AutoCloseable` resources; for specialised native-resource management, consider `Cleaner` as a fallback safety net, not the primary lifecycle mechanism.

---

# 16. Java 8, 11, 17, and 21 Features

### Q311. What were the most important Java 8 features?
**Answer:** Java 8 introduced lambda expressions, method references, functional interfaces, the Stream API, `Optional`, default/static interface methods, the modern Date-Time API (`java.time`), and several library improvements. These features made collection transformation and functional-style composition substantially more expressive.

### Q312. What notable features came with Java 9?
**Answer:** Java 9 introduced the Java Platform Module System, factory methods for unmodifiable collection instances such as `List.of`, private interface methods, JShell, and several runtime and library updates. It also began the modern six-month feature-release cadence.

### Q313. What are notable Java 11 features?
**Answer:** Java 11 is an LTS release. Notable features include standardisation of the HTTP Client API, local-variable syntax for lambda parameters, new `String` and `Files` methods, and running single-file source programs with the launcher. Many features had appeared in earlier releases or incubator/preview forms, so distinguish “introduced” from “standardised.”

### Q314. What are notable Java 17 features?
**Answer:** Java 17 is an LTS release. It finalised sealed classes, delivered pattern matching for `instanceof` and records from earlier releases, and included strong encapsulation of JDK internals as a key platform change. It also contains many APIs and language improvements from intermediate releases; avoid saying all these features first appeared in Java 17.

### Q315. What are notable Java 21 features?
**Answer:** Java 21 is an LTS release. Major features include virtual threads, sequenced collections, record patterns, and pattern matching for `switch`. It also includes other finalized and preview/incubator features; clearly label preview features instead of presenting them as ordinary stable APIs.

### Q316. Java 17 versus Java 21: what is the most important difference for backend developers?
**Answer:** Java 21 brings virtual threads as a finalized feature, along with sequenced collection interfaces and additional pattern matching capabilities. Both are LTS releases, but the exact support term depends on the JDK vendor and distribution. Upgrade decisions should also account for dependencies, runtime support, observability, and performance testing.

### Q317. What are records?
**Answer:** Records provide concise syntax for transparent data-carrier classes, generating component fields, accessors, canonical construction, `equals`, `hashCode`, and `toString`. They are shallowly immutable: the component references are final, but referenced mutable objects may still be changed unless defensively copied.

### Q318. What are sealed classes and interfaces?
**Answer:** Sealed types restrict which classes may extend or implement them, using `permits` or permitted declarations. Direct permitted subclasses must follow Java's sealed/non-sealed/final rules. Sealed hierarchies make a controlled set of subtypes explicit and work well with exhaustive pattern matching.

### Q319. What are switch expressions?
**Answer:** Switch expressions return a value and can use arrow rules, reducing fall-through mistakes: `String label = switch (status) { case PAID -> "done"; case NEW -> "pending"; };`. Exhaustiveness is checked in suitable enum/sealed contexts; `yield` returns a value from a block rule.

### Q320. What are text blocks?
**Answer:** Text blocks use triple quotes to represent multi-line strings with more readable formatting. They reduce escaping for JSON, SQL snippets, and other structured text, but they do not automatically validate the embedded language or make it safe from injection.

### Q321. What is pattern matching for `instanceof`?
**Answer:** Instead of checking the type and then separately casting, `if (obj instanceof String s)` checks the type and introduces a pattern variable `s` in the appropriate scope. It reduces boilerplate and prevents accidental use of a cast without the corresponding type test.

### Q322. What is pattern matching for switch in Java 21?
**Answer:** It allows switch constructs to dispatch based on patterns and types, and can work with guarded patterns and sealed hierarchies. The compiler can check exhaustiveness for supported type hierarchies, reducing missed cases when modelling closed sets of variants.

### Q323. What is the Sequenced Collections API in Java 21?
**Answer:** It introduces common interfaces such as `SequencedCollection`, `SequencedSet`, and `SequencedMap` for collections with a defined encounter order, with operations for first/last elements and reversed views. It gives a shared API for encounter-order operations previously handled differently by collection types.

### Q324. What is the Java Platform Module System?
**Answer:** Introduced in Java 9, the module system lets applications declare dependencies and which packages they export or open. It improves strong encapsulation and reliable configuration, though classpath-based applications remain supported. Reflection across module boundaries may require packages to be opened explicitly.

### Q325. What is the difference between LTS and non-LTS Java releases?
**Answer:** LTS means a vendor designates a release for extended support; support dates and availability depend on the vendor. Non-LTS releases deliver features on the regular release cadence but generally have shorter support windows. LTS is a support policy distinction, not a different Java language.

### Q326. Which features are preview features, and why does the distinction matter?
**Answer:** Preview features are released for evaluation and may change before finalisation; using them commonly requires explicit compiler/runtime flags and source-version controls. Always verify the status for the chosen JDK release. Do not present a feature that was preview in Java 21 as a finalized feature in that release.

---

# 17. Frequently Tested API Return Types and Traps

> Interviewers sometimes test return types directly. This is a high-value subset of common Java APIs, not a list of every method in the Java platform.

### Q327. What is the return type of `Object.equals()`?
**Answer:** `boolean`. It indicates whether the receiver and argument satisfy the class's equality semantics. The default `Object.equals()` performs identity equality.

### Q328. What is the return type of `Object.hashCode()`?
**Answer:** `int`. Equal objects must have equal hash codes; the integer is not guaranteed unique and should not be interpreted as an address.

### Q329. What is the return type of `Object.toString()`?
**Answer:** `String`. The default implementation returns a class-name/identity-style representation, and classes can override it for diagnostic output.

### Q330. What is the return type of `List.add(E)` versus `List.add(int, E)`?
**Answer:** `boolean` for `add(E)`, typically indicating whether the collection changed; `void` for `add(index, element)`. Do not confuse the overloads when answering collection API questions.

### Q331. What is the return type of `Set.add(E)`?
**Answer:** `boolean`. It returns true if the set did not already contain the element and it was added, and false if the element was already present according to the set's equality/ordering semantics.

### Q332. What does `Map.put(K, V)` return?
**Answer:** It returns the previous value associated with the key, or `null` if there was no previous mapping. Because HashMap allows a key to map to null, a null return can be ambiguous; use `containsKey` if that distinction matters. ConcurrentHashMap rejects null values and removes this particular ambiguity.

### Q333. What does `Map.remove(Object key)` return?
**Answer:** It returns the previous value associated with the key, or `null` if there was no mapping. It does not return a boolean. `Collection.remove(Object)` has a different contract and returns boolean.

### Q334. What is the return type of `Collection.remove(Object)`?
**Answer:** `boolean`, indicating whether an element was removed. Overloads or similarly named methods in other APIs may have different return types, so always identify the declaring interface and exact signature.

### Q335. What does `Map.containsKey()` return?
**Answer:** `boolean`. `containsKey(key)` answers whether a mapping exists for the key, even if that mapping's value is null in a map implementation that allows nulls.

### Q336. What does `Collection.size()` return?
**Answer:** `int`, representing the number of elements. A map's `size()` also returns `int`, and implementations may saturate at `Integer.MAX_VALUE` if they somehow contain more mappings than that.

### Q337. What does `List.indexOf()` return?
**Answer:** `int`. It returns the index of the first matching element, or `-1` when no match exists. It uses the list's equality semantics.

### Q338. What is the return type of `Collections.sort()`?
**Answer:** `void` for its traditional list-sorting overloads; it sorts the supplied list in place. By contrast, Stream `sorted()` returns a new Stream stage and does not mutate the source collection.

### Q339. What does `String.compareTo()` return?
**Answer:** `int`, negative, zero, or positive according to lexicographic comparison. It is not guaranteed to return exactly `-1`, `0`, or `1`; interview answers should say negative/zero/positive.

### Q340. What does `Comparator.compare(a, b)` return?
**Answer:** `int`, where a negative result means the first value sorts before the second, zero means equivalent for this ordering, and positive means it sorts after. A comparator should obey a consistent ordering contract.

### Q341. What does `Optional.isPresent()` return?
**Answer:** `boolean`. It indicates whether a non-null value is present. Prefer transformations such as `map`, `flatMap`, and `orElseThrow` where they make the flow clearer than `isPresent()` followed by `get()`.

### Q342. What does `Optional.get()` return?
**Answer:** The contained value of type `T`, but it throws `NoSuchElementException` if the Optional is empty. Prefer `orElse`, `orElseGet`, `orElseThrow`, or transformation methods where they better express the intended fallback or failure.

### Q343. What do `Stream.count()` and `Stream.toList()` return?
**Answer:** `count()` returns `long`. `Stream.toList()` returns a `List<T>` that is unmodifiable, available since Java 16. It does not promise a particular concrete list implementation.

### Q344. What does `Future.isDone()` return?
**Answer:** `boolean`, true when the task is completed, cancelled, or otherwise in a terminal state. It does not itself retrieve the result or indicate that the computation completed successfully.

### Q345. What does `Thread.getState()` return?
**Answer:** A `Thread.State` enum value. It is only a snapshot and can change immediately, so it should not be used as a synchronisation mechanism or as a reliable way to control another thread.

### Q346. What are the return types of `wait`, `notify`, and `notifyAll`?
**Answer:** All three return `void`. `wait` can throw `InterruptedException`, while `notify` and `notifyAll` require the current thread to own the object's monitor and otherwise throw `IllegalMonitorStateException`.

### Q347. What is the return type of `Thread.join()`?
**Answer:** `void`. `join()` waits for a thread to terminate (with overloads for timeouts) and can throw `InterruptedException` while the waiting thread is interrupted.

### Q348. What does `ExecutorService.submit()` return?
**Answer:** It returns a `Future` (often `Future<?>` for a Runnable submission or `Future<T>` for a Callable). This handle allows the caller to check status, cancel, or retrieve the result.

### Q349. What does `CompletableFuture.supplyAsync()` return?
**Answer:** `CompletableFuture<U>`, where `U` is the supplier's result type. It submits asynchronous work using the common pool by default or an explicit `Executor` if supplied.

### Q350. What does `AtomicInteger.incrementAndGet()` return?
**Answer:** It returns the updated integer value after incrementing atomically. `getAndIncrement()` also increments atomically but returns the previous value. This distinction is a common output-question trap.

### Q351. What does `String.substring()` return?
**Answer:** A `String` containing the requested range. The start index is inclusive and end index exclusive; invalid indexes cause `IndexOutOfBoundsException`. Since modern Java, callers should not rely on the result sharing the original string's backing storage.

### Q352. What does `Arrays.asList()` return?
**Answer:** A fixed-size `List` backed by the supplied array. Replacing elements in the list affects the array and vice versa, while add/remove operations are unsupported. For an independently resizable list, use `new ArrayList<>(Arrays.asList(...))`.

### Q353. What is the return type of `Class.forName()`?
**Answer:** `Class<?>`. The one-argument form can throw `ClassNotFoundException` and initializes the class as specified by the API. Use the overload that accepts a class loader and an initialization flag when explicit control is needed.

---

# 18. Core Java Coding Questions with Solutions

These solutions illustrate common interview techniques. Explain complexity, edge cases, and assumptions rather than only memorising code. The examples use modern Java syntax unless noted.

### Q354. Find the first non-repeating character in a string.
**Answer:** Count characters while preserving encounter order, then return the first character whose count is one. Complexity is O(n) time and O(k) space, where k is the number of distinct characters.

```java
static Optional<Character> firstNonRepeating(String s) {
    Map<Character, Long> counts = s.chars()
        .mapToObj(c -> (char) c)
        .collect(Collectors.groupingBy(
            Function.identity(), LinkedHashMap::new, Collectors.counting()));

    return s.chars()
        .mapToObj(c -> (char) c)
        .filter(c -> counts.get(c) == 1L)
        .findFirst();
}
```
**Trap:** `char` represents a UTF-16 code unit, not always a full Unicode code point. If full Unicode characters matter, iterate by code point instead.

### Q355. Count the frequency of each character in encounter order.
**Answer:** Use `LinkedHashMap` so keys retain first-seen order. This is a common exercise that checks both map selection and correct frequency updates.

```java
static Map<Character, Long> characterFrequency(String s) {
    return s.chars().mapToObj(c -> (char) c)
        .collect(Collectors.groupingBy(
            Function.identity(), LinkedHashMap::new, Collectors.counting()));
}
```

### Q356. Find duplicate characters in a string.
**Answer:** Count each character, then retain entries whose frequency exceeds one.

```java
static Set<Character> duplicateChars(String s) {
    Map<Character, Long> counts = characterFrequency(s);
    return counts.entrySet().stream()
        .filter(e -> e.getValue() > 1)
        .map(Map.Entry::getKey)
        .collect(Collectors.toCollection(LinkedHashSet::new));
}
```

### Q357. Remove duplicate elements from a list while preserving order.
**Answer:** `distinct()` preserves encounter order for an ordered stream. Complexity is typically O(n) expected time and O(k) memory for n inputs and k unique values.

```java
List<Integer> unique = values.stream().distinct().toList();
```
**Trap:** `toList()` is unmodifiable. Use `collect(Collectors.toCollection(ArrayList::new))` if the result must be mutable.

### Q358. Find the second-highest distinct number.
**Answer:** Remove duplicates, sort descending, and skip the highest value. This readable approach is O(n log n); a one-pass algorithm can do O(n) time if performance matters.

```java
Optional<Integer> secondHighest = numbers.stream()
    .distinct()
    .sorted(Comparator.reverseOrder())
    .skip(1)
    .findFirst();
```
**Trap:** Clarify whether “second highest” means the second distinct value. If all values are equal or fewer than two distinct values exist, the result is empty.

### Q359. Find the Nth-highest distinct salary using Streams.
**Answer:** Sort distinct salaries in descending order and take the element at position N (1-based).

```java
static Optional<Integer> nthHighestSalary(List<Employee> employees, int n) {
    if (n < 1) return Optional.empty();
    return employees.stream()
        .map(Employee::getSalary)
        .distinct()
        .sorted(Comparator.reverseOrder())
        .skip(n - 1L)
        .findFirst();
}
```
**Trade-off:** Sorting is simple to explain. For huge input and small N, a bounded min-heap can be more efficient.

### Q360. Group employees by department.
**Answer:** `groupingBy` uses the department as a classification key and collects each department's employees into a list.

```java
Map<String, List<Employee>> byDepartment = employees.stream()
    .collect(Collectors.groupingBy(Employee::getDepartment));
```

### Q361. Find the highest-paid employee in each department.
**Answer:** Group by department and use a downstream `maxBy` collector; the map values are Optional because a maximum may be absent for an empty group in general collector semantics.

```java
Map<String, Optional<Employee>> highestPaid = employees.stream()
    .collect(Collectors.groupingBy(
        Employee::getDepartment,
        Collectors.maxBy(Comparator.comparingInt(Employee::getSalary))));
```

### Q362. Partition numbers into even and odd.
**Answer:** `partitioningBy` creates the boolean partitions of numbers based on the predicate.

```java
Map<Boolean, List<Integer>> groups = numbers.stream()
    .collect(Collectors.partitioningBy(n -> n % 2 == 0));
// true = even, false = odd
```

### Q363. Convert a list of strings to uppercase.
**Answer:** Use `map` to transform every element.

```java
List<String> upper = words.stream()
    .map(String::toUpperCase)
    .toList();
```

### Q364. Flatten a nested list of integers.
**Answer:** `flatMap` turns each inner list into a stream and combines them into a single stream.

```java
List<Integer> flat = nested.stream()
    .flatMap(Collection::stream)
    .toList();
```

### Q365. Find the sum of a list of integers.
**Answer:** For primitive integers, use `mapToInt` and `sum()` to avoid unnecessary boxing in the reduction.

```java
int sum = values.stream().mapToInt(Integer::intValue).sum();
```

### Q366. Find the first repeated character.
**Answer:** Track characters already seen and return the first one encountered twice.

```java
static Optional<Character> firstRepeated(String s) {
    Set<Character> seen = new HashSet<>();
    for (char c : s.toCharArray()) {
        if (!seen.add(c)) return Optional.of(c);
    }
    return Optional.empty();
}
```
**Complexity:** O(n) expected time and O(k) extra space.

### Q367. Reverse a string.
**Answer:** For ordinary UTF-16 string reversal, `StringBuilder` is concise.

```java
String reversed = new StringBuilder(input).reverse().toString();
```
**Trap:** `StringBuilder.reverse()` preserves surrogate pairs, but it does not reverse user-perceived grapheme clusters as a unit. Combining marks, emoji modifiers, and joined emoji sequences can still require Unicode-aware text handling if the task defines “character” as a grapheme cluster.

### Q368. Reverse the order of words in a sentence.
**Answer:** Split the text into words, reverse the sequence, and join them. Clarify whether repeated whitespace and punctuation should be preserved; the simple solution normalises spacing.

```java
static String reverseWords(String s) {
    String trimmed = s.trim();
    if (trimmed.isEmpty()) return "";
    String[] words = trimmed.split("\\s+");
    Collections.reverse(Arrays.asList(words));
    return String.join(" ", words);
}
```

### Q369. Check whether a string is a palindrome.
**Answer:** Compare matching characters from both ends and move inward. Decide first whether comparison is case-sensitive and whether spaces/punctuation should be ignored.

```java
static boolean isPalindrome(String s) {
    int left = 0, right = s.length() - 1;
    while (left < right) {
        if (s.charAt(left++) != s.charAt(right--)) return false;
    }
    return true;
}
```

### Q370. Find the longest common prefix.
**Answer:** Use the first string as the candidate prefix and shorten it until every other string starts with it. This simple implementation is easy to reason about and handles an empty input list.

```java
static String longestCommonPrefix(String[] words) {
    if (words == null || words.length == 0) return "";
    String prefix = words[0];
    for (int i = 1; i < words.length; i++) {
        while (!words[i].startsWith(prefix)) {
            prefix = prefix.substring(0, prefix.length() - 1);
            if (prefix.isEmpty()) return "";
        }
    }
    return prefix;
}
```

### Q371. Find the maximum element in an array.
**Answer:** Scan once and keep the maximum. This is O(n) time and O(1) extra space.

```java
static OptionalInt max(int[] a) {
    return Arrays.stream(a).max();
}
```
**Trap:** `OptionalInt` represents the empty-array case without inventing a sentinel value.

### Q372. Find the longest sequence of consecutive integers in an unsorted array.
**Answer:** Store all numbers in a set. Start a sequence only at numbers whose predecessor is absent, then count forward. Average time is O(n) under expected constant-time hashing.

```java
static int longestConsecutive(int[] nums) {
    Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
    int best = 0;
    for (int n : set) {
        if (n == Integer.MIN_VALUE || !set.contains(n - 1)) {
            int current = n;
            int length = 1;
            while (current != Integer.MAX_VALUE && set.contains(current + 1)) {
                current++;
                length++;
            }
            best = Math.max(best, length);
        }
    }
    return best;
}
```

### Q373. Find duplicate numbers in a list.
**Answer:** A set detects values already encountered. This solution preserves duplicate encounter order in the result.

```java
static Set<Integer> duplicates(List<Integer> values) {
    Set<Integer> seen = new HashSet<>();
    Set<Integer> duplicates = new LinkedHashSet<>();
    for (Integer value : values) {
        if (!seen.add(value)) duplicates.add(value);
    }
    return duplicates;
}
```

### Q374. Sort employees by salary, then by name.
**Answer:** Chain comparators; use a null policy if salary or names can be null.

```java
employees.sort(Comparator.comparingInt(Employee::getSalary)
    .thenComparing(Employee::getName));
```
**Trap:** `List.sort` mutates the list and returns `void`. To produce a separate sorted result, sort a copy or use `stream().sorted(...)`.

### Q375. Implement a thread-safe counter.
**Answer:** If only an independent increment and read are required, `AtomicInteger` offers an atomic update.

```java
AtomicInteger counter = new AtomicInteger();
counter.incrementAndGet();
int current = counter.get();
```
**Trap:** If the counter must update together with other fields under one invariant, use a shared lock or another atomic state design instead of assuming several independent atomic operations form a transaction.

### Q376. Create a bounded thread pool.
**Answer:** Configure `ThreadPoolExecutor` explicitly so task backlog is bounded and overload behaviour is intentional.

```java
int workers = Math.max(1, Runtime.getRuntime().availableProcessors());
ThreadPoolExecutor pool = new ThreadPoolExecutor(
    workers,
    workers,
    0L,
    TimeUnit.MILLISECONDS,
    new ArrayBlockingQueue<>(500),
    Executors.defaultThreadFactory(),
    new ThreadPoolExecutor.AbortPolicy());
```
**Interview follow-up:** Explain why the queue is bounded, how rejected tasks are surfaced, why downstream capacity matters, and how the pool is shut down.

### Q377. Run two independent tasks and combine their results.
**Answer:** `thenCombine` composes two stages once both complete normally.

```java
CompletableFuture<Integer> a = CompletableFuture.supplyAsync(() -> 10);
CompletableFuture<Integer> b = CompletableFuture.supplyAsync(() -> 20);
CompletableFuture<Integer> total = a.thenCombine(b, Integer::sum);
int result = total.join(); // 30; blocks here if not completed
```
**Trap:** `join()` is a blocking call if the result is not ready; the pipeline itself does not force the caller to wait until the terminal retrieval.

### Q378. Safely initialise a lazy singleton.
**Answer:** The holder idiom uses class initialisation, which Java guarantees to be thread-safe.

```java
final class AppConfig {
    private AppConfig() {}
    private static class Holder {
        private static final AppConfig INSTANCE = new AppConfig();
    }
    static AppConfig getInstance() {
        return Holder.INSTANCE;
    }
}
```
**Trap:** A singleton pattern is about one instance within a defined class-loader/runtime scope. Multiple class loaders, reflection, or serialization can complicate simplistic singleton implementations.

---

# 19. Topics from the Supplied List That Are Not Core Java

Your source contains many useful backend interview questions. To keep this repository focused, study them in separate repos or sections:

- **Spring / Spring Boot:** `@Component`, `@Service`, `@Transactional`, dependency injection, bean lifecycle, AOP, MVC, `@Async`, Actuator, Spring Security, Feign Client.
- **Microservices / distributed systems:** API Gateway, Saga, circuit breaker, transactional outbox, idempotency, JWT architecture, retries, Kafka-based event delivery, eventual consistency, service discovery.
- **Databases:** SQL joins, indexing, stored procedures, transactions, MySQL versus MongoDB, JPA/Hibernate, query optimisation.
- **Cloud / DevOps:** AWS EC2/S3/Lambda, IAM, Docker, Kubernetes, CI/CD, Jenkins, deployment and monitoring.
- **Interview coding outside Core Java:** tree height, linked-list reversal, kth-largest element, longest common prefix, numeric string multiplication, and SQL salary queries can have their own Data Structures & Algorithms or database practice section. Some were included here when they directly reinforce standard Java API knowledge.

This separation is intentional: a strong Core Java repository should not mix language/runtime semantics with framework conventions and distributed-system design as if they were the same subject.

---

# 20. References

## Official Java documentation and specifications

- [Java SE 21 API documentation](https://docs.oracle.com/en/java/javase/21/docs/api/)
- [`Object`: equals, hashCode, clone, finalization](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Object.html)
- [`ConcurrentHashMap`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/concurrent/ConcurrentHashMap.html)
- [`ConcurrentMap` memory-consistency guarantees](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/concurrent/ConcurrentMap.html)
- [`Future`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/concurrent/Future.html)
- [`CompletableFuture`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/concurrent/CompletableFuture.html)
- [`ThreadLocal`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/ThreadLocal.html)
- [`WeakHashMap`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/WeakHashMap.html)
- [`Optional`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Optional.html)
- [Stream API](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/stream/Stream.html)
- [Java Language Specification, Chapter 8: Classes](https://docs.oracle.com/javase/specs/jls/se21/html/jls-8.html)
- [Java Language Specification, Chapter 12: Execution and class initialisation](https://docs.oracle.com/javase/specs/jls/se21/html/jls-12.html)
- [JEP 444: Virtual Threads (Java 21)](https://openjdk.org/jeps/444)
- [JEP 395: Records](https://openjdk.org/jeps/395)
- [JEP 409: Sealed Classes](https://openjdk.org/jeps/409)
- [Oracle JDK 17 release notes](https://www.oracle.com/java/technologies/javase/17all-relnotes.html)
- [Java SE 21 language changes](https://docs.oracle.com/en/java/javase/21/language/java-language-changes-release.html)
- [JEP 491: Synchronize Virtual Threads without Pinning (targeted to JDK 24)](https://openjdk.org/jeps/491)

## Public LinkedIn discussion themes used for topic selection

These posts are treated as **signals about interview-discussion topics**, not as authoritative Java specifications. Technical answers above follow Java API documentation and language rules where available.

- [Core Java questions: JVM, multithreading, collections, OOP, exceptions](https://www.linkedin.com/posts/java-by-madhu-vundavalli_sharing-real-core-java-questions-if-you-activity-7415779330338861056-BLwZ)
- [Java multithreading questions for senior engineers](https://www.linkedin.com/posts/bhanu-prakash-5637a2183_java-multithreading-interview-questions-senior-activity-7427235268392534016-Ir0m)
- [Core Java interview questions and answers](https://www.linkedin.com/posts/sahil-wankhade-858015185_java-corejava-fullstackdeveloper-activity-7371774542878441472-A6W6)
- [Recently discussed Java interview topics: collections and concurrency](https://www.linkedin.com/posts/vitthal-chandankar_java-collections-javadeveloper-activity-7429011671253295104-Uvwe)

## How this guide was assembled

The supplied interview dump was reviewed for actual Core Java coverage: Java platform basics, OOP, method dispatch, object contracts, collections and map internals, Java 8 functional programming, exceptions, generics, reflection, serialization, threading, executors, concurrency, JVM memory, class loading, and Java version differences. Spring, SQL, Kafka, cloud, and system-design material was separated rather than passed off as Core Java.
