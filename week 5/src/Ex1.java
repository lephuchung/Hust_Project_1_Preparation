
import java.io.*;
import java.util.*;
// Minimum Spanning Tree - Kruskal
class Edge implements Comparable<Edge> {
    int u, v, c;
    public Edge(int u, int v, int c) {
        this.u = u;
        this.v = v;
        this.c = c;
    }
    @Override
    public int compareTo(Edge other) {
        return this.c - other.c;
    }
}
class Kruskal {
    int N;
    ArrayList<Edge> edges;
    public Kruskal(int N, ArrayList<Edge> edges) {
        this.N = N;
        this.edges = edges;
    }
    public int MST() {
        int minSpanningTreeWeight = 0;
        int[] parent = new int[N + 1];
        int[] rank = new int[N + 1];
        PriorityQueue<Edge> pq = new PriorityQueue<>(edges);
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int u = edge.u;
            int v = edge.v;
            int c = edge.c;
            int rootU = find(parent, u);
            int rootV = find(parent, v);
            if (rootU != rootV) {
                minSpanningTreeWeight += c;
                union(parent, rank, rootU, rootV);
            }
        }
        return minSpanningTreeWeight;
    }

    public int find(int[] parent, int node) {
        if (parent[node] == node)
            return node;
        parent[node] = find(parent, parent[node]);
        return parent[node];
    }

    public void union(int[] parent, int[] rank, int rootU, int rootV) {
        if (rank[rootU] < rank[rootV]) {
            parent[rootU] = rootV;
        } else if (rank[rootU] > rank[rootV]) {
            parent[rootV] = rootU;
        } else {
            parent[rootV] = rootU;
            rank[rootU]++;
        }
    }
}
public class Ex1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);

            int c = Integer.parseInt(input[2]);
            edges.add(new Edge(u, v, c));
        }
        Kruskal kr = new Kruskal(n, edges);
        int result = kr.MST();
        System.out.println(result);
    }
}
