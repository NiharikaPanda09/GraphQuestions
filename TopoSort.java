import java.util.*;
public class TopoSort {
    public static void main(String[] args) {
        int n = 6; // Number of vertices
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges
        adj.get(5).add(0);
        adj.get(5).add(2);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        // Perform topological sort
        ArrayList<Integer> topoOrder = topologicalSort(adj);

        // Print result
        System.out.println("Topological Order: " + topoOrder);
    }

    public static void dfs(int node,int[] vis,Stack<Integer> st,ArrayList<ArrayList<Integer>> adj){
      vis[node] = 1;
      for(int it:adj.get(node)){
          if(vis[it] == 0 ){
              dfs(it,vis,st,adj);
          }

      }
      st.push(node);

    }
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        // Your code here
         int n = adj.size();
        int[] vis = new int[n];
        // vis {0} == 0 dfs call
       Stack<Integer> stack = new Stack<>();
       for(int i=0;i<n;i++){
           if(vis[i] == 0){
               dfs(i,vis,stack,adj);
           }
       }
       ArrayList<Integer> ans = new ArrayList<>();
       while(!stack.isEmpty()){
           ans.add(stack.pop());
       }
        return ans;
    }
}
