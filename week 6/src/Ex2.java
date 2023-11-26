// Max Flow
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex2 {
    static final int maxn = 1005;

    static int n, m, s, t;
    static int[][] c = new int[maxn][maxn];
    static int[][] f = new int[maxn][maxn];
    static int[] tr = new int[maxn];
    static int mf;

    static void DFS(int u) {
        for (int v = 1; v <= n; ++v) {
            if (tr[v] == 0 && c[u][v] > f[u][v]) {
                tr[v] = u;
                DFS(v);
            }
        }
    }

    static void BFS() {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(s);
        while (!Q.isEmpty()) {
            int u = Q.poll();
            for (int v = 1; v <= n; ++v)
                if (tr[v] == 0 && c[u][v] > f[u][v]) {
                    tr[v] = u;
                    Q.add(v);
                }
        }
    }

    static boolean FindP() {
        Arrays.fill(tr, 0);
        tr[s] = -1;
        // DFS(s);
        BFS();
        return (tr[t] != 0);
    }

    static void IncFlow() {
        int v = t;
        int delta = 2_000_000_000;
        while (v != s) {
            int u = tr[v];
            delta = Math.min(delta, c[u][v] - f[u][v]);
            v = u;
        }
        v = t;
        while (v != s) {
            int u = tr[v];
            f[v][u] -= delta;
            f[u][v] += delta;
            v = u;
        }
        mf += delta;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        s = scanner.nextInt();
        t = scanner.nextInt();

        for (int i = 1; i <= m; ++i) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            c[u][v] = w;
        }

        while (FindP()) {
            IncFlow();
        }

        System.out.println(mf);
    }
}