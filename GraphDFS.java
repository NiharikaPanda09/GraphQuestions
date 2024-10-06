import java.util.*;
public class GraphDFS {
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // List to store the DFS traversal result
        ArrayList<Integer> dfsTraversal = new ArrayList<>();

        // Visited array to mark visited nodes
        boolean[] visited = new boolean[V];

        // Start DFS from node 0
        dfs(0, adj, visited, dfsTraversal);

        return dfsTraversal;
    }

    // Recursive DFS function
    public void dfs(int u, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> dfsTraversal) {
        // If the node is already visited, return
        if (visited[u]) {
            return;
        }

        // Add this node to the result list
        dfsTraversal.add(u);

        // Mark this node as visited
        visited[u] = true;

        // Explore all adjacent vertices of the current node
        for (int v : adj.get(u)) {
            if (!visited[v]) {
                // Recursive call to visit unvisited neighbors
                dfs(v, adj, visited, dfsTraversal);
            }
        }
    }

    public static void main(String[] args) {
        GraphDFS sol = new GraphDFS();

        // Number of vertices
        int V = 4;

        // Graph adjacency list representation using ArrayList
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Initialize adjacency lists for all vertices
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges to the graph
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(2);
        adj.get(2).add(0);
        adj.get(2).add(3);

        // Perform DFS traversal
        ArrayList<Integer> dfsResult = sol.dfsOfGraph(V, adj);

        // Print the DFS traversal result
        System.out.println(dfsResult);
    }
}

