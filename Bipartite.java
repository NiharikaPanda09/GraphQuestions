import java.util.*;
public class Bipartite {
    public static void main(String[] args) {
    int[][] graph = {{1,2,3},{0,2},{0,1,3},{0,2}};
        System.out.println(isBipartite(graph));
    }
    public static boolean isBipartite(int[][] graph) {
     int n = graph.length;
     int[] col = new int[n];
     Arrays.fill(col,-1);
     for(int i=0;i<n;i++){
         if(col[i] == -1){
             if(!dfs(i,0,col,graph)){
                 return false;
             }
         }

     }
        return true;
    }
    public static  boolean dfs(int node,int col,int[] color,int [][] graph){
        color[node] = col;
        for(int neighbour:graph[node]){
            if(color[neighbour]  == -1){
                if(!dfs(neighbour,1-col,color,graph)){
                    return false;
                }
            }
            if(color[neighbour]== col){
                return  false;
            }
        }
        return true;
    }
}
