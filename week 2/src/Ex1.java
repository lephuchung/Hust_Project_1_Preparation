import java.util.Scanner;

public class Ex1 {
    public static long MOD = (long) (1e9+7);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.print("Nhap vao so k: ");
        int k = scanner.nextInt();
//        System.out.print("Nhap vao so n: ");
        int n = scanner.nextInt();
        long kq = nCk(k, n);
        System.out.println(kq);
    }

    public static long nCk(int k, int n) {
        long[][] a = new long[k + 1][n + 1];

        for (int j = 0; j <= k; j++) {
            a[0][j] = 1;
            a[j][j] = 1;
        }
        for (int i = 1; i <= k; i++) {
            for (int j = 2; j <= n; j++) {
                if (j > i) {
                    a[i][j] = (a[i - 1][j - 1] + a[i][j - 1]) % MOD;
                }
            }
        }
        return a[k][n];
    }
}