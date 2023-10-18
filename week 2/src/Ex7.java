import java.util.Scanner;

public class Ex7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[50];
        arr[0] = 1;
        arr[1] = 1;
        for(int i = 2; i<30; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
//        System.out.println("Nhap vao so thu tu so fibo muon tim: ");
        int n = sc.nextInt();
        System.out.println(arr[n-1]);
    }
}
