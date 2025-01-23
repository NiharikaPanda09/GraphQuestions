import java.util.*;
public class KanhBfsTopo {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int nodes = 6; // Example for a graph with 6 nodes (0 to 5)

        // Initialize adjacency list
        for (int i = 0; i < nodes; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges (directed graph)
        adj.get(5).add(0);
        adj.get(5).add(2);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        // Perform topological sort
        ArrayList<Integer> result = topologicalSort(adj);
        System.out.println("Topological Order: " + result);
    }
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        int [] indegree = new int[n];
        for(int i=0;i<n;i++){
            for(int it:adj.get(i)){
              indegree[it]++;
            }
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i=0;i<n;i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
      ArrayList<Integer> topo = new ArrayList<>();
        int i=0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            topo.add(node);


            for(int it:adj.get(node)){
                indegree[it]--;

                if(indegree[it] ==0){
                    queue.add(it);
                }
            }

        }
           return topo;
    }
}
