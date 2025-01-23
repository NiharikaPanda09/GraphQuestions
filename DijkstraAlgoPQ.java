import java.util.*;
public class DijkstraAlgoPQ {
    public static void main(String[] args) {
        int V = 5; // Number of vertices
        ArrayList<ArrayList<iPair>> adj = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(new iPair(1, 2)); // Edge 0 -> 1 with weight 2
        adj.get(0).add(new iPair(3, 6)); // Edge 0 -> 3 with weight 6
        adj.get(1).add(new iPair(2, 3)); // Edge 1 -> 2 with weight 3
        adj.get(1).add(new iPair(3, 8)); // Edge 1 -> 3 with weight 8
        adj.get(1).add(new iPair(4, 5)); // Edge 1 -> 4 with weight 5
        adj.get(2).add(new iPair(4, 7)); // Edge 2 -> 4 with weight 7

        DijkstraAlgoPQ algo = new DijkstraAlgoPQ();
        ArrayList<Integer> distances = algo.dijkstra(adj, 0);
        System.out.println(distances);
    }

    static class iPair {
        int first, second;

        iPair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

     ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
        // Write your code here
        int V = adj.size();
        ArrayList<Integer> dist = new ArrayList<>(Collections.nCopies(V, Integer.MAX_VALUE));
        dist.set(src, 0);
        PriorityQueue<iPair> pq = new PriorityQueue<>((a, b) -> a.first - b.first);
        pq.add(new iPair(0, src));

        while (!pq.isEmpty()) {
            iPair curr = pq.poll();
            int currDis = curr.first;
            int currNode = curr.second;


            if (currDis > dist.get(currNode)) continue;
            for (iPair neighbour : adj.get(currNode)) {
                int neighNode = neighbour.first;
                int neighEdge = neighbour.second;

                if (dist.get(currNode) + neighEdge < dist.get(neighNode)) {
                    dist.set(neighNode, dist.get(currNode) + neighEdge);
                    pq.add(new iPair(dist.get(neighNode), neighNode));
                }
            }

        }
        return dist;
    }


}
