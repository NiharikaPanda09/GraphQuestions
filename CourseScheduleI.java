import java.util.*;
public class CourseScheduleI {
    public static void main(String[] args) {
       int[][] arr = {{1,0}};
        Boolean res = canFinish(2,arr);
        System.out.println(res);

    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = adj.size();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }


        for(int [] pre:prerequisites){
            adj.get(pre[1]).add(pre[0]);
        }


        int [] indegree = new int[numCourses];
        for(int [] pre:prerequisites){
            indegree[pre[0]]++;
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0){
                queue.add(i);

            }
        }
        int cnt=0;
        ArrayList<Integer> topo = new ArrayList<>();
        int i=0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            topo.add(node);
            cnt++;


            for(int it:adj.get(node)){
                indegree[it]--;

                if(indegree[it] ==0){
                    queue.add(it);
                }
            }

        }
        return cnt==numCourses;
    }
}



