import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        long sum=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao so hang tu: ");
        long n = sc.nextLong();
        System.out.println("Nhap vao cac hang tu: ");
        for (long i = 0; i < n; i++){
            long k = sc.nextLong();
            sum+=k;
        }
        System.out.println(sum);
    }
}
/* cach toi uu bai toan
//JAVA
import java.util.*;
import java.io.*;
@SuppressWarnings({"unchecked", "deprecation"})
public class Main {
    public static void main(String[] args) throws IOException {
    BufferedReader arrayReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(arrayReader.readLine());
        long sum = 0;
        String[] input = arrayReader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(input[i]);
            sum += num;
        }
        System.out.println(sum);
    }
}

 */
