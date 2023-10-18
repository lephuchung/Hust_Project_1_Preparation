import java.text.DecimalFormat;
import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        // Khai bao bien
        int n;//so dien su dung
        Scanner sc = new Scanner(System.in);
//        System.out.print("Nhap vao so dien su dung");
        n = sc.nextInt();
        double khac = 0.00f ;
        if (n>700)
        {
            khac = ((n-700)*3.457+300*3.111+200*2.612+100*2.074+100*1.728)-((n-400)*3.015+100*2.919+100*2.612+100*2.074+50*1.786+50*1.728);
        }
        else if (n>400 && n<700)
        {
            khac = ((n-400)*3.111+200*2.612+100*2.074+100*1.728)-((n-400)*3.015+100*2.919+100*2.612+100*2.074+50*1.786+50*1.728);
        }
        else if (n>300 && n<400)
        {
            khac = ((n-200)*2.612+100*2.074+100*1.728)-((n-300)*2.919+100*2.612+100*2.074+50*1.786+50*1.728);
        }
        else if (n>200 && n<300)
        {
            khac = ((n-200)*2.612+100*2.074+100*1.728)-((n-200)*2.612+100*2.074+50*1.786+50*1.728);
        }
        else if (n>100 && n<200)
        {
            khac = ((n-100)*2.074+100*1.728)-((n-100)*2.074+50*1.786+50*1.728);
        }
        else if (n>50 && n<100)
        {
            khac = (n*1.728)-((n-50)*1.786+50*1.728);
        }
        else if (n<50)
        {
            khac = (n*1.728)-(n*1.728);
        }
        khac+=khac*0.10;
        khac*=1000;
        DecimalFormat df = new DecimalFormat("0.00");
        String kq = df.format(khac);
        System.out.println(kq);
    }
}
