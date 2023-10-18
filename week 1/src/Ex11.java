import java.util.*;
import java.io.*;

public class Ex11 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        //du lieu vao
        //khoi 1
        BufferedReader arrayReader = new BufferedReader(new InputStreamReader(System.in));
//        System.out.print("Nhap so phan tu cua chuoi: ");
        int n = Integer.parseInt(arrayReader.readLine());
        int[] arr = new int[10001];
        String[] input = arrayReader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
//            System.out.println(arr[i]);
        }

        String cmd = sc.nextLine() ;
        //khoi 2
        int max = arr[0];
        int min = arr[0];
        int sum = 0;
        for (int i = 0; i < n; i++){
            if(max < arr[i]){
                max = arr[i];
            }
            if(min > arr[i]){
                min = arr[i];
            }
            sum+=arr[i];
        }
        if (cmd.equals("*")){
//            System.out.println("haha");
            do{
                cmd = sc.nextLine();
                if (cmd.equals("sum"))
                {
                    System.out.println(sum);
                }
                if (cmd.equals("find-max")){
                    System.out.println(max);
                }
                if (cmd.equals("find-min")){
                    System.out.println(min);
                }
                if (cmd.contains("find-max-segment")){
                    int dau=0;
                    int cuoi=0;
                    for (int i=0;i<3;i++){
                        String[] arstr = cmd.split(" ");
                        dau = Integer.parseInt(arstr[1])-1;
                        cuoi = Integer.parseInt(arstr[2])-1;
                    }
                    int maxPlus= arr[dau];
                    for (int j=dau;j<=cuoi;j++){
                        if(maxPlus<arr[j])
                            maxPlus=arr[j];
                    }
                    System.out.println(maxPlus);
                    maxPlus = min;
                }
                if(cmd.equals("***")){
                    break;
                }
            }while (true);
        }
    }
}
