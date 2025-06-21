// Parcel.java
// Represents a delivery request (parcel)

public class Parcel implements Comparable<Parcel> {
    String id; // Parcel ID
    String location; // Delivery location
    int deadline; // Delivery deadline (e.g. 12 = 12 PM)
    int orderTime; // When the parcel was ordered
    int priority; // Higher value = more important

    public Parcel(String id, String location, int deadline, int orderTime, int priority) {
        this.id = id;
        this.location = location;
        this.deadline = deadline;
        this.orderTime = orderTime;
        this.priority = priority;
    }

    // Used by MaxHeap to compare parcels
    // Higher priority comes first. If same, earlier orderTime is preferred.
    public int compareTo(Parcel other) {
        if (this.priority == other.priority)
            return Integer.compare(this.orderTime, other.orderTime);
        return Integer.compare(other.priority, this.priority); // descending priority
    }
}
