
import java.util.*;
public class Ex2 {
    static class So {
        int a, b, c;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        So[] d = new So[n + 1];

        for (int i = 1; i <= n; i++) {
            d[i] = new So();
            d[i].a = scanner.nextInt();
            d[i].b = i;
        }

        Arrays.sort(d, 1, n + 1, (x, y) -> {
            if (x.a != y.a) {
                return Integer.compare(x.a, y.a);
            } else {
                return Integer.compare(x.b, y.b);
            }
        });

        for (int i = 2; i <= n; i++) {
            if (d[i].a == d[i - 1].a) {
                d[i].c = 1;
            } else {
                d[i].c = 0;
            }
        }

        Arrays.sort(d, 1, n + 1, (x, y) -> Integer.compare(x.b, y.b));

        for (int i = 1; i <= n; i++) {
            System.out.println(d[i].c);
        }
    }
}
