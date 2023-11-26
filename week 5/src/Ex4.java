import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int tes = 1; tes <= test; tes++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] deg = new int[1000005];
            boolean check = true;

            for (int i = 1; i <= n; i++) {
                deg[i] = 0;
            }

            for (int i = 1; i <= m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                deg[u]++;
                deg[v]++;
            }

            for (int i = 1; i <= n; i++) {
                if (deg[i] < 2) {
                    check = false;
                }
            }

            if (check) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }
}
