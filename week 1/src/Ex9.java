import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Ex9 {
    public static void main(String[] args) {
        System.out.print("Nhap vao thoi gian muon chuyen: ");
        Scanner sc = new Scanner(System.in);
        String chuoi = sc.nextLine();
        if(chuoi.length()!=8)
        {
            System.out.println("INCORRECT");
            System.exit(0);
        }
        if(chuoi.codePointAt(2)!=58||chuoi.codePointAt(5)!=58)
        {
            System.out.println("INCORRECT");
            System.exit(0);
        }
        int hour=(chuoi.codePointAt(0)-48)*10+chuoi.codePointAt(1)-48;
        int minute=(chuoi.codePointAt(3)-48)*10+chuoi.codePointAt(4)-48;
        int second=(chuoi.codePointAt(6)-48)*10+chuoi.codePointAt(7)-48;
        if(hour>23||hour<0||minute>59||minute<0||second>59||second<0)
        {
            System.out.println("INCORRECT");
            System.exit(0);
        }
        System.out.println(hour*3600+minute*60+second);
    }
}
