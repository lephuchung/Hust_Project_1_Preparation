import java.util.Scanner;

public class Ex14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap vao chuoi 1: ");
        String chuoi1 = sc.nextLine();
        System.out.print("Nhap vao chuoi 2: ");
        String chuoi2 = sc.nextLine();
        System.out.print("Nhap vao chuoi 3: ");
        String chuoi3 = sc.nextLine();
        System.out.println(chuoi3.replace(chuoi1,chuoi2));
    }
}
