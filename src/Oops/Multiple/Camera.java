package oops.multiple;

/**
 * Camera — Interface for camera functionality.
 *
 * INTERVIEW DEFINITION — Multiple Inheritance via Interfaces:
 * --------------------------------------------------------------
 * Q: What is Multiple Inheritance?
 * A: Multiple Inheritance is when a class inherits from MORE THAN ONE parent.
 *    Java does NOT support multiple inheritance with CLASSES (Diamond Problem),
 *    but SUPPORTS it with INTERFACES.
 *    Example: SmartPhone implements Camera, MusicPlayer (inherits behavior from both).
 *
 * Q: Why does Java allow Multiple Inheritance with Interfaces?
 * A: Interfaces only define BEHAVIOR contracts (abstract methods) — no state (fields).
 *    So there's no ambiguity about which field to inherit (Diamond Problem solved).
 *    Since Java 8, if two interfaces have same default method, the implementing class
 *    MUST override it to resolve the conflict.
 *
 * JAVA TYPE: interface
 * OOP PILLAR: Abstraction (used for Multiple Inheritance)
 *
 * @author Aditya
 * @version 2.0
 * @see Smartphone
 * @see MusicPlayer
 */
interface Camera {

    /**
     * Captures a photo — implementing class provides the actual logic.
     */
    void click();
}
