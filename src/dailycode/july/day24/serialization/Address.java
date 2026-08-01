package dailycode.july.day24.serialization;

import java.io.Serializable;

/**
 * Address — A Serializable value object representing a shipping address.
 *
 * INTERVIEW: Why must Address also implement Serializable?
 * → When we serialize an Order object, Java serializes the ENTIRE object graph.
 * → If Order has a reference to Address, and Address is NOT Serializable,
 *   Java throws java.io.NotSerializableException at RUNTIME.
 * → RULE: Every object referenced by a Serializable class must ALSO be Serializable,
 *   OR the field must be marked 'transient' to skip it.
 *
 * INTERVIEW: What is serialVersionUID?
 * → It is a UNIQUE identifier for each Serializable class.
 * → Used during DESERIALIZATION to verify that the sender and receiver of a
 *   serialized object have loaded classes that are compatible.
 * → If not declared, JVM generates one based on class structure — but this can
 *   BREAK if the class changes (e.g., add a field), causing InvalidClassException.
 * → BEST PRACTICE: Always declare serialVersionUID explicitly.
 *
 * JAVA TYPE: Serializable POJO
 * MARKER INTERFACE: java.io.Serializable
 *
 * @author Aditya
 * @version 2.0
 */
public class Address implements Serializable {

    /**
     * Explicit serialVersionUID — ensures backward compatibility.
     * If you change this class (add/remove fields), you control whether
     * old serialized files are still compatible.
     */
    private static final long serialVersionUID = 1L;

    private String street;
    private String city;
    private String state;
    private String pincode;

    public Address(String street, String city, String state, String pincode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }

    // ======================== GETTERS ========================

    public String getStreet() { return street; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public String getPincode() { return pincode; }

    @Override
    public String toString() {
        return street + ", " + city + ", " + state + " - " + pincode;
    }
}
