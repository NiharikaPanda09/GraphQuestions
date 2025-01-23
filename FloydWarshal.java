import java.util.*;
public class FloydWarshal {
    public static void main(String[] args) {

       int[][] mat = {{0,1,43},{1,0,6},{-1,-1,0}};
        shortestDistance(mat);

        // Print the resulting shortest distance matrix
        System.out.println("Shortest distances between all pairs:");
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }


    }
    public static void shortestDistance(int[][] mat) {
        // Code here
         int n= mat.length;
         for(int i=0;i< n;i++){
             for(int j=0;j<n;j++){
                 if(mat[i][j] == -1) {
                     mat[i][j] = (int) (1e9);
                 }
                 if(i==j) mat[i][j] = 0;
             }
         }
         for(int k=0;k<n;k++){
             for(int i=0;i<n;i++){
                 for(int j=0;j<n;j++){
                     mat[i][j] = Math.min(mat[i][j],mat[i][k] + mat[k][j]);
                 }
             }
         }

//         for(int i=0;i<n;i++){
//             if(mat[i][i] == 0){
//
//             }
//         }
        for(int i=0;i< n;i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == (int) (1e9)) {
                    mat[i][j] = -1;
                }
            }
        }
    }
}
