package practice;
import java.util.*;
class Pair1{
    int dest;
    int distance;
    Pair1(int dest, int distance){
        this.dest = dest;
        this.distance = distance;
    }
}
class tuple{
    int node;
    int currentdis;
    tuple(int node, int currentdis){
        this.node = node;
        this.currentdis = currentdis;
    }
}
public class dijkistra_algo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] temp = sc.nextLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int e = Integer.parseInt(temp[1]);
        List<List<Pair1>> adjlist = new ArrayList<>();
        for(int i = 0; i<n; i++) adjlist.add(new ArrayList<>());
        System.out.println("enter the edges ");
        for(int i = 0; i<e; i++){
            String[] edge = sc.nextLine().split(" ");
            adjlist.get(Integer.parseInt(edge[0])).add(new Pair1(Integer.parseInt(edge[1]), Integer.parseInt(edge[2])));
        }
        int[] dist = new int[n];
        Arrays.fill(dist, (int)1e9);
        PriorityQueue<tuple> queue = new PriorityQueue<>((a,b) -> a.currentdis - b.currentdis);
        queue.add(new tuple(0,0));
        dist[0] = 0;
        while(!queue.isEmpty()){
            tuple ele = queue.poll();
            int node = ele.node;
            int currentdis = ele.currentdis;
            for(Pair1 it : adjlist.get(node)){
                int dest = it.dest;
                int distance = it.distance;
                if (dist[dest] > distance + currentdis){
                    dist[dest] = distance + currentdis;
                    queue.add(new tuple(dest, distance+currentdis));
                }
            }
        }
        System.out.println(Arrays.toString(dist));
    }
}
