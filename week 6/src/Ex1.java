// Shortest Path between 2 nodes on a directed graph with non-negative weights
import java.util.*;

class Edge {
    int v, w;
    Edge(int v, int w) {
        this.v = v;
        this.w = w;
    }
}

public class Ex1 {
    static final int inq = Integer.MAX_VALUE;
    static int dijkstra(List<List<Edge>> graph, int s, int t, int n) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, inq);
        dist[s] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.w - b.w);
        pq.add(new Edge(s, 0));

        while (!pq.isEmpty()) {
            Edge c = pq.poll();
            if (c.v == t) return c.w;
            if (c.w > dist[c.v]) continue;
            for (Edge next : graph.get(c.v)) {
                if (dist[next.v] > dist[c.v] + next.w) {
                    dist[next.v] = dist[c.v] + next.w;
                    pq.add(new Edge(next.v, dist[next.v]));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Edge>> graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph.get(u).add(new Edge(v, w));
        }
        int s = sc.nextInt();
        int t = sc.nextInt();
        int kq = dijkstra(graph, s, t, n);
        System.out.println(kq);
    }
}