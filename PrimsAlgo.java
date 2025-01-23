import java.util.*;
public class PrimsAlgo {
    public static void main(String[] args) {
        int V = 3;
        int E = 3;
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        adj.get(0).add(new int[]{1, 5}); // Edge 0-1 with weight 5
        adj.get(1).add(new int[]{0, 5}); // Edge 1-0 with weight 5

        adj.get(1).add(new int[]{2, 3}); // Edge 1-2 with weight 3
        adj.get(2).add(new int[]{1, 3}); // Edge 2-1 with weight 3

        adj.get(0).add(new int[]{2, 1}); // Edge 0-2 with weight 1
        adj.get(2).add(new int[]{0, 1});

        System.out.println(spanningTree(V,E,adj));
    }
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);

        boolean[] visited = new boolean[V];
        int sum = 0;
        pq.offer(new int[]{0,0});

        while(!pq.isEmpty()){
            int [] edge = pq.poll();

            int wt = edge[0];
            int node = edge[1];

            if(visited[node]) continue;

            visited[node] = true;
            sum += wt;


            for(int [] neigh:adj.get(node)){
                int neighNode = neigh[0];
                int neighWt = neigh[1];
                if(!visited[neighNode]){
                    pq.offer(new int[]{neighWt,neighNode});
                }
            }
        }
        return sum;

    }
}
