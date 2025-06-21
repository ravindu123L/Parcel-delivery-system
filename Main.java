// Main.java
// Main class to run the delivery simulation

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Setup
        MaxHeap heap = new MaxHeap(); // Priority queue for parcels
        Graph graph = new Graph(); // City map
        VehicleManager vm = new VehicleManager(); // Vehicle tracker

        // Load test data
        List<Parcel> parcels = SampleData.getParcels();
        List<Vehicle> vehicles = SampleData.getVehicles();
        parcels.forEach(heap::insert);
        vehicles.forEach(vm::addVehicle);
        SampleData.loadGraph(graph);

        int currentTime = 0; // Start time of simulation

        // Process each parcel one by one
        while (!heap.isEmpty()) {
            Parcel parcel = heap.extractMax(); // Get highest priority parcel
            Vehicle vehicle = vm.findNearestAvailable(
                    graph, parcel.location, currentTime, parcel.deadline);

            if (vehicle != null) {
                System.out.println(
                        " Vehicle " + vehicle.id + " will deliver Parcel " + parcel.id + " to " + parcel.location);
                vehicle.available = false;
                vehicle.location = parcel.location;
            } else {
                System.out.println(" No available vehicle can deliver Parcel " + parcel.id + " before deadline.");
            }
        }

        System.out.println("\n Simulation finished.");
    }
}
