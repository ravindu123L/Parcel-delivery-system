// Graph.java
// Graph of city zones + Dijkstra's shortest path algorithm

import java.util.*;

public class Graph {
    HashMap<String, ArrayList<Edge>> adj = new HashMap<>();

    // Add a bidirectional road (edge) between two zones
    public void addEdge(String from, String to, int time) {
        adj.putIfAbsent(from, new ArrayList<>());
        adj.putIfAbsent(to, new ArrayList<>());
        adj.get(from).add(new Edge(to, time));
        adj.get(to).add(new Edge(from, time));
    }

    // Find shortest travel time from one zone to all others
    public HashMap<String, Integer> dijkstra(String start) {
        HashMap<String, Integer> dist = new HashMap<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        dist.put(start, 0);

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            if (!adj.containsKey(current.to))
                continue;

            for (Edge neighbor : adj.get(current.to)) {
                int newDist = current.time + neighbor.time;
                if (newDist < dist.getOrDefault(neighbor.to, Integer.MAX_VALUE)) {
                    dist.put(neighbor.to, newDist);
                    pq.add(new Edge(neighbor.to, newDist));
                }
            }
        }
        return dist;
    }

    // Edge = road to another zone with time
    class Edge implements Comparable<Edge> {
        String to;
        int time;

        Edge(String to, int time) {
            this.to = to;
            this.time = time;
        }

        public int compareTo(Edge other) {
            return Integer.compare(this.time, other.time);
        }
    }
}
