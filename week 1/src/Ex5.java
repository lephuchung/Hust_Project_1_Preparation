import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
//        System.out.print("Nhap vao ngay muon kiem tra: ");
        Scanner sc = new Scanner(System.in);
        String chuoi = sc.nextLine();
        int flag = 0;
        int i;
        if (chuoi.length()!=10)
        {
            System.out.println("INCORRECT");
            System.exit(0);
        }
        for(i=0;i<4;i++)
        {
            if(chuoi.codePointAt(i)>57||chuoi.codePointAt(i)<48)
            {
                System.out.println("INCORRECT");
                System.exit(0);
            }
        }
        for(i=5;i<7;i++)
        {
            if(chuoi.codePointAt(i)>57||chuoi.codePointAt(i)<48)
            {
                System.out.println("INCORRECT");
                System.exit(0);
            }
        }
        for(i=8;i<10;i++)
        {
            if(chuoi.codePointAt(i)>57||chuoi.codePointAt(i)<48)
            {
                System.out.println("INCORRECT");
                System.exit(0);
            }
        }
        if (chuoi.codePointAt(5)-48>1)
        {
            System.out.println("INCORRECT");
            System.exit(0);
        }

        if(chuoi.codePointAt(5)-48==1)
        {
            if(chuoi.codePointAt(6)-48>=3)
            {
                System.out.println("INCORRECT");
                System.exit(0);
            }
        }
        if(chuoi.codePointAt(8)-48>3)
        {
            System.out.println("INCORRECT");
            System.exit(0);
        }
        if(chuoi.codePointAt(8)-48==3)
        {
            if(chuoi.codePointAt(9)>=2)
            {
                System.out.println("INCORRECT");
                System.exit(0);
            }
        }
        if(chuoi.codePointAt(4)!=45||chuoi.codePointAt(7)!=45)
        {
            System.out.println("INCORRECT");
            System.exit(0);
        }
        else{
            int nam=(chuoi.codePointAt(0)-48)*1000+(chuoi.codePointAt(1)-48)*100+(chuoi.codePointAt(2)-48)*10+chuoi.codePointAt(3)-48;
            int thang=(chuoi.codePointAt(5)-48)*10+chuoi.codePointAt(6)-48;
            int ngay=(chuoi.codePointAt(8)-48)*10+chuoi.codePointAt(9)-48;
            System.out.println(nam+" "+thang+" "+ngay);
        }
    }
}
