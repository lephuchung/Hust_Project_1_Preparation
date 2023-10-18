import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String kq[] = new String[1000];
        String s1 = "PUSH";
        String s2 = "POP";
        String s3 = "#";
        String chuoi;
        int n=0;
        int dau=1;
        do {
            chuoi = sc.nextLine();
            String tach[] = chuoi.split(" ");
            if (chuoi.equals(s2)){
                if(dau>n){
                    System.out.println("NULL");
                }
                else{
                    System.out.println(kq[dau]);
                    dau++;
                }

            }
            else if (chuoi.equals(s3)){
                break;
            }
            else{
                n++;
                kq[n] = tach[1];
            }
        }
        while (!chuoi.equals("#"));
    }
}
