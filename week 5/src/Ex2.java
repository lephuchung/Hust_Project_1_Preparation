import java.util.*;
// List order of nodes visited by a DFS
public class Ex2 {
    static int n, m;
    static boolean[] f;
    static List<Integer>[] a;

    public static void DFS(int i) {
        f[i] = false;
        System.out.print(i + " ");
        for (int j = 0; j < a[i].size(); j++) {
            int neighbor = a[i].get(j);
            if (f[neighbor]) {
                DFS(neighbor);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        f = new boolean[100005];
        a = new ArrayList[100005];

        for (int i = 0; i <= 100004; i++) {
            a[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            a[u].add(v);
            a[v].add(u);
        }

        for (int i = 1; i <= n; i++) {
            f[i] = true;
            Collections.sort(a[i]);
        }

        for (int i = 1; i <= n; i++) {
            if (f[i]) {
                DFS(i);
            }
        }
    }
}
