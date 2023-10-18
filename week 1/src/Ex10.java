import java.text.DecimalFormat;
import java.util.Scanner;

public class Ex10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("Giai phuong trinh ax^2+bx+c=0");
        System.out.print("Nhap vao a: ");
        int a = sc.nextInt();
        System.out.print("Nhap vao b: ");
        int b = sc.nextInt();
        System.out.print("Nhap vao c: ");
        int c = sc.nextInt();
        if (a==0){
            double x0 = (double) -c/b;
            String kq = df.format(x0);
            System.out.println(kq);
        }
        else{
            double delta = b*b - 4*a*c;
            if (delta > 0){
                double x1 = (double) (-b-Math.sqrt(delta))/(2*a);
                double x2 = (double) (-b+Math.sqrt(delta))/(2*a);
                String kq1 = df.format(x1);
                String kq2 = df.format(x2);
                System.out.println(kq1+" "+kq2);
            }
            if (delta == 0){
                double x3 = (double) -b/(2*a);
                String kq3 = df.format(x3);
                System.out.println(kq3);
            }
            else if(delta < 0)
                System.out.println("NO SOLUTION");
        }

    }
}
