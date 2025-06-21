// Vehicle.java
// Represents a delivery vehicle

public class Vehicle {
    String id;
    String location;
    int capacity;
    boolean available; // true = ready to deliver

    public Vehicle(String id, String location, int capacity) {
        this.id = id;
        this.location = location;
        this.capacity = capacity;
        this.available = true; // all vehicles start as available
    }
}
