import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        System.out.println("Nhap vao so bit muon in");
        int n = sc.nextInt();
        String bit = "";
        for (int i = 0; i < n;i++){
            bit = bit + "1";
        }
        int k = Integer.parseInt(bit,2);
        for(int i=0;i<=k;i++){
            String kq = Integer.toBinaryString(i);
            while (n-kq.length() != 0)
            {
                kq = "0" + kq;
            }
            if(kq.contains("11"))
            {
                continue;
            }
            System.out.println(kq);
        }

    }
}
