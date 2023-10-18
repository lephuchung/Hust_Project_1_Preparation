import java.util.Scanner;

public class Ex6 {
    static int[] a = new int[50];
    static int n, m;
    static boolean[] f = new boolean[50];
    static int d;
    static boolean kt;
    static int tong;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        d = 1;
        tong = 0;
        for (int i = 1; i <= 49; i++) {
            f[i] = false;
        }
        dequy(1);
    }

    public static void in() {
        for (int i = 1; i <= n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void dequy(int k) {
        for (int i = 1; i <= m; i++) {
            a[k] = i;
            tong = tong + a[k];
            if (k == n && tong == m)
                in();
            else if (k < n)
                dequy(k + 1);
            tong = tong - a[k];
        }
    }
}
