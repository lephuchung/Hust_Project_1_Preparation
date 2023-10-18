import java.util.Scanner;

public class Ex4 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
//        System.out.println("Nhap vao so phan tu cua mang: ");
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        Ex4 k = new Ex4();
        k.layHoanVi(a);
    }

    public void layHoanVi(int a[]){
        inHoanVi(a, 0, true);
    }

    private void inHoanVi(int a[], int start, boolean in){
        if(in){
            for(int i = 0; i < a.length; i++){
                System.out.print(a[i] + " ");
            }
            System.out.println("");
        }

        for(int j = start; j < a.length; j++){
            int tam = a[start];
            a[start] = a[j];
            a[j] = tam;
            if(j == start){
                inHoanVi(a, start+1, false);
            }
            else{
                inHoanVi(a, start+1, true);
            }
//            tam = a[start];
//            a[start] = a[j];
            a[j] = tam;
        }
    }
}
