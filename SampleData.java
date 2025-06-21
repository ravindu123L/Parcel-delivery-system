import java.util.ArrayList;
import java.util.List;

// This class provides sample data for testing: parcels, vehicles, and the city map
public class SampleData {

    // Create a sample list of parcels
    public static ArrayList<Parcel> getParcels() {
        ArrayList<Parcel> parcels = new ArrayList<>();
        parcels.add(new Parcel("P1", "Zone2", 8, 1, 4));
        parcels.add(new Parcel("P2", "Zone1", 10, 2, 2));
        parcels.add(new Parcel("P3", "Zone4", 15, 3, 5));
        System.out.println(" SampleData loaded!"); // add this inside getParcels()

        return parcels;
    }

    // Create a sample list of vehicles
    public static List<Vehicle> getVehicles() {
        return List.of(
                new Vehicle("V1", "Zone1", 10),
                new Vehicle("V2", "Zone2", 5));
    }

    // Add roads (edges) to the graph to simulate the city map
    public static void loadGraph(Graph g) {
        g.addEdge("Zone1", "Zone2", 3); // 3 minutes between Zone1 and Zone2
        g.addEdge("Zone2", "Zone3", 2); // 2 minutes between Zone2 and Zone3
        g.addEdge("Zone1", "Zone3", 5); // alternative route
        g.addEdge("Zone3", "Zone4", 4); // Zone3 to Zone4
    }

}
