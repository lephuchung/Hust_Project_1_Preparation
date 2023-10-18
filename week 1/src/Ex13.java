import java.util.Scanner;

public class Ex13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dem=0;
        while (sc.hasNextLine()){
            String chuoi = sc.nextLine();
            for(int i =0;i< chuoi.length();i++)
            {
                if (chuoi.charAt(i) == ' ' && chuoi.charAt(i+1)!=' ')
                {
                    dem++;
                }
            }
            if(chuoi.charAt(0)!=' '){
                dem++;
            }
        }
        System.out.println(dem);
    }
}
