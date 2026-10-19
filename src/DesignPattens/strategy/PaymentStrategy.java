package DesignPattens.strategy;

/**
 * Strategy Interface:
 * Defines a family of interchangeable algorithms / behaviors.
 * Marked as @FunctionalInterface since it has a single abstract method.
 */
@FunctionalInterface
public interface PaymentStrategy {
    void pay(double amount);
}
