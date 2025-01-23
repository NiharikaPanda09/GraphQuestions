import java.util.*;
public class NumberOfProvinces {
    public static void main(String[] args) {
    int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum(isConnected));
    }
    public static  int findCircleNum(int[][] isConnected) {
     int provinces = 0;
     boolean[] visited = new boolean[isConnected.length];
     for(int i=0;i< isConnected.length;i++){
             if(!visited[i]){
                 provinces++;
                 dfs(i,isConnected,visited);
             }
     }
     return provinces;
    }
    private static void dfs(int u, int[][] isConnected, boolean[] visited){
          visited[u] =true;

          for(int j =0;j<isConnected.length;j++){
              if(isConnected[u][j] == 1 && !visited[j]){
                  dfs(j,isConnected,visited);
              }
          }
    }
}
