import java.util.Scanner;
public class Ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);

        int m = Integer.parseInt(input[1]);

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            int hash = calcHash(s, m);
            System.out.println(hash);
        }
    }

    public static int calcHash(String s, int m) {
        int hash = 0;
        int k = s.length();
        for (int i = 0; i < k; i++) {
            char c = s.charAt(i);
            int cV = (int) c;
            hash = (hash * 256 + cV) % m;
        }
        return hash;
    }
}