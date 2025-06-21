// VehicleManager.java
// Manages all vehicles and selects the best one for each parcel

import java.util.*;

public class VehicleManager {
    ArrayList<Vehicle> vehicles = new ArrayList<>();

    public void addVehicle(Vehicle v) {
        vehicles.add(v);
    }

    // Find the best vehicle that is available and can reach the parcel before
    // deadline
    public Vehicle findNearestAvailable(Graph g, String destination, int currentTime, int deadline) {
        Vehicle best = null;
        int shortestTime = Integer.MAX_VALUE;

        for (Vehicle v : vehicles) {
            if (!v.available)
                continue;

            HashMap<String, Integer> dist = g.dijkstra(v.location);
            int travelTime = dist.getOrDefault(destination, Integer.MAX_VALUE);

            if ((currentTime + travelTime <= deadline) && travelTime < shortestTime) {
                best = v;
                shortestTime = travelTime;
            }
        }

        return best;
    }
}
