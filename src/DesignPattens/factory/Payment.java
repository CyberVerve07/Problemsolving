package DesignPattens.factory;

/**
 * Product Interface:
 * Defines the common contract for all payment methods.
 */
public interface Payment {
    void pay(double amount);
}
