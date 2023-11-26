import java.util.*;
// Sequence of nodes visited by BFS
public class Ex3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[] f = new boolean[100005];
        List<List<Integer>> a = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i <= 100004; i++) {
            a.add(new ArrayList<>());
        }

        for (int i = 1; i <= m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            a.get(u).add(v);
            a.get(v).add(u);
        }

        for (int i = 1; i <= n; i++) {
            f[i] = true;
            Collections.sort(a.get(i));
        }

        for (int i = 1; i <= n; i++) {
            if (f[i]) {
                q.add(i);
                f[i] = false;
            }
            while (!q.isEmpty()) {
                System.out.print(q.peek() + " ");
                int d = q.poll();
                for (int j = 0; j < a.get(d).size(); j++) {
                    if (f[a.get(d).get(j)]) {
                        q.add(a.get(d).get(j));
                        f[a.get(d).get(j)] = false;
                    }
                }
            }
        }
    }
}
