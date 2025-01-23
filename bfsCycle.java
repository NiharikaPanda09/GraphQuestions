import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class bfsCycle {
    public static void main(String[] args) {
     int[][] adjArray ={{1},{0,2,4},{1,3},{2,4},{1,3}};
        ArrayList<ArrayList<Integer>> adj = convertToAdjList(adjArray);

        boolean res = isCycle(adj);
        System.out.println("Cycle detected: " + res);
    }
    private  static ArrayList<ArrayList<Integer>> convertToAdjList(int[][] adjArray) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int[] neighbors : adjArray) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int neighbor : neighbors) {
                list.add(neighbor);
            }
            adjList.add(list);
        }
        return adjList;
    }
        // Function to detect cycle in an undirected graph.
        public static  boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
            int V = adj.size(); // Number of vertices
            int[] vis = new int[V]; // Visited array to track visited nodes

            // Loop over all nodes to handle disconnected graph components
            for (int i = 0; i < V; i++) {
                // If the node is not visited, start a BFS from this node
                if (vis[i] == 0) {
                    if (bfs(i, adj, vis)) {
                        return true; // Cycle found
                    }
                }
            }
            return false; // No cycle found in any component
        }

        // Helper function to perform BFS and check for a cycle
        private static boolean bfs(int src, ArrayList<ArrayList<Integer>> adj, int[] vis) {
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{src, -1});
            vis[src] = 1; // Mark the source node as visited

            while (!q.isEmpty()) {
                int[] info = q.poll();
                int node = info[0];
                int parent = info[1];

                // Check all adjacent nodes
                for (int neighbour : adj.get(node)) {
                    if (vis[neighbour] == 0) {
                        vis[neighbour] = 1;
                        q.add(new int[]{neighbour, node});
                    } else if (neighbour != parent) {
                        // If the neighbor is visited and not the parent, a cycle is detected
                        return true;
                    }
                }
            }
            return false; // No cycle found in this component
        }
    }

