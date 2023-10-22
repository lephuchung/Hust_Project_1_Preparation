import java.util.Scanner;

public class Ex4 {
    static final int MAX_SIZE = 1001;
    static int a, b, c;
    static boolean[][] visited = new boolean[MAX_SIZE][MAX_SIZE];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        a = input.nextInt();
        b = input.nextInt();
        c = input.nextInt();

        if (canMeasure(a, b, c)) {
            int result = minSteps(0, 0);
            System.out.println(result);
        } else {
            System.out.println("-1");
        }
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static boolean canMeasure(int a, int b, int c) {
        if (a + b < c) return false;
        if (a == c || b == c || a + b == c || c % gcd(a, b) == 0) return true;
        return false;
    }

    public static int minSteps(int x, int y) {
        if (x == c || y == c) return 0;
        if (visited[x][y]) return -1;
        visited[x][y] = true;

        int steps = -1;

        // Fill jug a
        if (x < a) {
            int nextSteps = minSteps(a, y);
            if (nextSteps >= 0) {
                steps = (steps < 0) ? nextSteps + 1 : Math.min(steps, nextSteps + 1);
            }
        }

        // Fill jug b
        if (y < b) {
            int nextSteps = minSteps(x, b);
            if (nextSteps >= 0) {
                steps = (steps < 0) ? nextSteps + 1 : Math.min(steps, nextSteps + 1);
            }
        }

        // Empty jug a
        if (x > 0) {
            int nextSteps = minSteps(0, y);
            if (nextSteps >= 0) {
                steps = (steps < 0) ? nextSteps + 1 : Math.min(steps, nextSteps + 1);
            }
        }

        // Empty jug b
        if (y > 0) {
            int nextSteps = minSteps(x, 0);
            if (nextSteps >= 0) {
                steps = (steps < 0) ? nextSteps + 1 : Math.min(steps, nextSteps + 1);
            }
        }

        // Pour water from jug a to jug b
        if (x > 0 && y < b) {
            int pour = Math.min(x, b - y);
            int nextSteps = minSteps(x - pour, y + pour);
            if (nextSteps >= 0) {
                steps = (steps < 0) ? nextSteps + 1 : Math.min(steps, nextSteps + 1);
            }
        }

        // Pour water from jug b to jug a
        if (y > 0 && x < a) {
            int pour = Math.min(y, a - x);
            int nextSteps = minSteps(x + pour, y - pour);
            if (nextSteps >= 0) {
                steps = (steps < 0) ? nextSteps + 1 : Math.min(steps, nextSteps + 1);
            }
        }

        visited[x][y] = false;
        return steps;
    }
}