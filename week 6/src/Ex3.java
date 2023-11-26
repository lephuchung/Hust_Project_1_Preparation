// All pair shortest paths
import java.util.*;

public class Ex3 {
    static int n, m, bd, kt, gt;
    static ArrayList<int[]>[] v;
    static int[] d;
    static boolean[] p;

    static class cmp implements Comparator<int[]> {
        public int compare(int[] x, int[] y) {
            return Integer.compare(x[1], y[1]);
        }
    }

    static PriorityQueue<int[]> h;

    static void dij(int bd) {
        while (!h.isEmpty())
            h.poll();
        d[bd] = 0;
        h.add(new int[] { bd, d[bd] });
        while (!h.isEmpty()) {
            int[] ds = h.poll();
            if (!p[ds[0]])
                continue;
            p[ds[0]] = false;
            for (int i = 0; i < v[ds[0]].size(); i++) {
                int dc1, dc2, dc3;
                dc1 = v[ds[0]].get(i)[0];
                dc2 = v[ds[0]].get(i)[1];
                if (d[dc1] > dc2 + ds[1]) {
                    d[dc1] = dc2 + ds[1];
                    h.add(new int[] { dc1, d[dc1] });
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        v = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            v[i] = new ArrayList<int[]>();
        }

        d = new int[n + 1];
        p = new boolean[n + 1];
        h = new PriorityQueue<>(new cmp());

        for (int i = 0; i < m; i++) {
            bd = sc.nextInt();
            kt = sc.nextInt();
            gt = sc.nextInt();
            v[bd].add(new int[] { kt, gt });
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                d[j] = 100000009;
                p[j] = true;
            }
            dij(i);
            for (int j = 1; j <= n; j++)
                System.out.print(d[j] + " ");
            System.out.println();
        }
    }
}
