import java.util.*;
public class zero_one_matrix {
    public static void main(String[] args) {
          int [][] matrix = {{0,0,1},
                             {0,1,0},
                             {1,1,1}};

        System.out.println(Arrays.deepToString(updateMatrix(matrix)));
    }
    public static  int[][] updateMatrix(int[][] mat) {
       int[][] distance = new int[mat.length][mat[0].length];
        int maxPossible= mat.length - 1 + mat[0].length - 1;

       for(int i=0;i< mat.length;i++){
           for(int j =0;j<mat[0].length;j++) {
               if (mat[i][j] != 0) {
                   int upCell = (i > 0) ? mat[i - 1][j] : maxPossible;
                   int leftCell = (j > 0) ? mat[i][j - 1] : maxPossible;
                   distance[i][j] = Math.min(upCell, leftCell) + 1;
               }
           }
       }
        for(int i=mat.length-1;i>=0;i--) {
            for (int j = mat[0].length - 1; j >= 0; j--) {
                if (mat[i][j] != 0) {
                    int DownCell = (i < mat.length-1) ? mat[i + 1][j] : maxPossible;
                    int RightCell = (j < mat[0].length-1) ? mat[i][j + 1] : maxPossible;
                    distance[i][j] = Math.min(distance[i][j], Math.min(DownCell, RightCell) + 1);

                }
            }
        }
        return distance;
    }
}
