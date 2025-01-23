import java.util.*;
public class SetDikjstra {
    public static void main(String[] args) {
        int V = 5; // Number of vertices
        ArrayList<ArrayList<iPair>> adj = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(new iPair(1, 2)); // Edge 0 -> 1 with weight 2
        adj.get(0).add(new iPair(3, 6)); // Edge 0 -> 3 with weight 6
        adj.get(1).add(new iPair(2, 3)); // Edge 1 -> 2 with weight 3
        adj.get(1).add(new iPair(3, 8)); // Edge 1 -> 3 with weight 8
        adj.get(1).add(new iPair(4, 5)); // Edge 1 -> 4 with weight 5
        adj.get(2).add(new iPair(4, 7)); // Edge 2 -> 4 with weight 7

        SetDikjstra algo = new SetDikjstra();
        ArrayList<Integer> distances = algo.dijkstra(adj, 0);
        System.out.println(distances);
    }
   static  class iPair {
        int first, second;

        iPair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
     int V = adj.size();
     ArrayList<Integer> dist = new ArrayList<>(Collections.nCopies(V,Integer.MAX_VALUE));
        dist.set(src,0);
      TreeSet<iPair> set = new TreeSet<>((a,b)->{
          if(a.second != b.second) return Integer.compare(a.second, b.second);
          return Integer.compare(a.first,b.first);
      });
      set.add(new iPair(src,0));

      while(!set.isEmpty()){
          iPair curr = set.pollFirst();
          int currNode = curr.first;
          int Edge = curr.second;

          for(iPair neighbour:adj.get(currNode)){
              int neighNode =  neighbour.first;
              int neighEdge = neighbour.second;


              if(dist.get(currNode) + neighEdge < dist.get(neighNode)){
                  set.remove(new iPair(neighNode,dist.get(neighNode)));
                  dist.set(neighNode,dist.get(currNode)+neighEdge);
                  set.add(new iPair(neighNode,dist.get(neighNode)));
              }
          }

      }
      return dist;

    }
}
