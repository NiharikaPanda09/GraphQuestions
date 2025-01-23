import java.util.*;
public class CourseScheduleII {
    public static void main(String[] args) {
   int[][]arr = {{0,1}};
        System.out.println(Arrays.toString(findOrder(2, arr)));
    }
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prerequisite = pre[1];
            adj.get(prerequisite).add(course);
            indegree[course]++;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        int[] topo = new int[numCourses];
        int i = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topo[i++]= node;


            for (int it : adj.get(node)) {
                indegree[it]--;

                if (indegree[it] == 0) {
                    queue.add(it);
                }
            }
        }
        if (i == numCourses) {
            return topo;
        } else {
            return new int[0];
        }
    }
}
