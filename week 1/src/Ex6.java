import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
//        System.out.print("Nhap vao so n: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();;
        for (int i =1; i<=n;i++)
        {
            System.out.println(i + " " + i*i);
        }
    }
}
