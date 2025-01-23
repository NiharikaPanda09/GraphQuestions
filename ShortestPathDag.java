import java.util.*;
public class ShortestPathDag {
    public static void main(String[] args) {

    }

    class Pair {
        int frst, secnd;

        Pair(int first, int second) {
            this.frst = first;
            this.secnd = second;
        }

    }

    public int[] shortestPath(int V, int E, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            ArrayList<Pair> temp = new ArrayList<>();
            adj.add(temp);
        }
        for (int i = 0; i < E; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v, wt));
        }
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                topoSort(i, adj, vis, st);
            }
        }
        int [] dis = new int[V];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[0]= 0;

        while(!st.isEmpty()){
            int node = st.pop();

            for(Pair neighbour:adj.get(node)){
                int v = neighbour.frst;
                int wt = neighbour.secnd;

                if(dis[node]+wt < dis[v]){
                    dis[v] = dis[node] + wt;
                }
            }
        }
        return dis;

    }


    private void topoSort(int node,ArrayList<ArrayList<Pair>> adj,int[] vis,Stack<Integer> st) {

        vis[node] = 1;
        for(Pair neighbor : adj.get(node)){
        if(vis[neighbor.frst] == 0){
            topoSort(neighbor.frst,adj,vis,st);
        }
        }
        st.add(node);
    }

}
