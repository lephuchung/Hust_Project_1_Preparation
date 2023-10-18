import java.util.Scanner;

public class Ex7 {
    public static void main(String[] args) {
//        System.out.println("Nhap vao so luong so muon kiem tra: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int odd=0;
        int even=0;
        int k;
        for (int i = 0; i<n;i++)
        {
            k=sc.nextInt();
            if(k%2==1) odd++;
            else even++;
        }
        System.out.println(odd + " " + even);
    }
}
//Cach toi uu bai toan
//import java.util.*;
//import java.io.*;
//public class Ex7 {
//    public static void main(String[] args) throws IOException{
//        BufferedReader arrayReader = new BufferedReader(new InputStreamReader(System.in));
////        System.out.println("Nhap vao so luong so muon kiem tra: ");
//        int n = Integer.parseInt(arrayReader.readLine());
//        int odd=0;
//        int even=0;
//        String[] input = arrayReader.readLine().split(" ");
//        for (int i = 0; i<n;i++)
//        {
//            int k = Integer.parseInt(input[i]);
//            if(k%2==1) odd++;
//            else even++;
//        }
//        System.out.println(odd + " " + even);
//    }
//}

