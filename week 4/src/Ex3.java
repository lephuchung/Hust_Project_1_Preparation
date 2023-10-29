import java.util.HashSet;
import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        HashSet<String> mySet = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        String s;
        String amd;

        while (scanner.hasNext()) {
            s = scanner.next();
            if (s.equals("*")) {
                break;
            }
            mySet.add(s);
        }

        while (scanner.hasNext()) {
            s = scanner.next();
            if (s.equals("*")) {
                break;
            } else if (s.equals("find")) {
                amd = scanner.next();
                if (mySet.contains(amd)) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (s.equals("insert")) {
                amd = scanner.next();
                if (mySet.add(amd)) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            }
        }
    }
}
