import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap vao so muon kiem tra: ");
        int n = sc.nextInt();
        int k=0;
        int mi = 100/n;
        int ma = 999/n;
        for (int i = mi;i <= ma; i++){
            if (i*n>=100 && i*n<=999)
            {
                System.out.print(i*n+ " ");
            }

        }
    }
}
