import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String chuoi;
        String ptu[] = new String[1000];
        chuoi = sc.nextLine();
        ptu = chuoi.split("");
        String stack[] = new String[1000];
        int n = 0;
        if (chuoi.length() % 2 == 1){
            System.out.println("0");
            System.exit(0);
        }
        for(int i = 0; i < chuoi.length(); i++){
            if(ptu[i].equals("(")  || ptu[i].equals("[")  || ptu[i].equals("{")){
                ++n;
                stack[n] = ptu[i];
            }
            else if(n!=0 && ptu[i].equals(")") && stack[n].equals("(")){
                stack[n] = null;
                n--;
            }
            else if(n!=0 && ptu[i].equals("]") && stack[n].equals("[")){
                stack[n] = null;
                n--;
            }
            else if(n!=0 && ptu[i].equals("}") && stack[n].equals("{")){
                stack[n] = null;
                n--;
            }
            else{
                System.out.println("0");
                System.exit(0);
            }
        }
        System.out.println("1");
    }
}
