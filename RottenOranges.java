import java.util.*;
public class RottenOranges {
    public static void main(String[] args) {
   int[][] r = {{2,1,1},{0,1,1},{1,1,0}};
        System.out.println(orangesRotting(r));

    }
    public static int orangesRotting(int[][] grid) {
      int n = grid.length;
      int m = grid[0].length;
      Queue<int[]> q = new LinkedList<>();
      // have to create a 2d matrix for visited ones you know
      int[][] visited = new int[n][m];
// to count the fresh oranges
      int cntFresh = 0;
      for(int i=0;i<n;i++){
          for(int j=0;j<m;j++){
              if(grid[i][j] == 2){
                  q.offer(new int[]{i,j});
              }
              if(grid[i][j] == 1){
                  cntFresh++;
              }
          }
      }
      if(cntFresh==0){
          return 0;
      }
      if(q.isEmpty()){
          return -1;
      }
      int min =0;
      int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        // BFS to spread the rot to fresh oranges
        while (!q.isEmpty()) {
            int size = q.size();
            boolean rottenThisMinute = false;

            for (int i = 0; i < size; i++) {
                int[] cell = q.poll();
                int x = cell[0];
                int y = cell[1];

                for (int[] dir : dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];

                    // Check if the new cell is within bounds and is a fresh orange
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2; // Rot the fresh orange
                        cntFresh--; // Decrease fresh orange count
                        q.offer(new int[] {nx, ny});
                        rottenThisMinute = true;
                    }
                }
            }

            // If any oranges were rotted this minute, increase the minute count
            if (rottenThisMinute) {
                min++;
            }
        }

        // If there are still fresh oranges left, return -1 (impossible to rot all)
        return cntFresh == 0 ? min : -1;
    }
}