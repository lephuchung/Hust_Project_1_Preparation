import java.util.Scanner;

public class Ex8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap vao gia tri a: ");
        int a = sc.nextInt();
        System.out.print("Nhap vao gia tri b: ");
        int b = sc.nextInt();
        System.out.println((a+b)+" "+(a-b)+" "+(a*b)+" "+(a/b));
    }
}
