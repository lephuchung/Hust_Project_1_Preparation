import org.w3c.dom.Node;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Ex8 {
    public static void main(String[] args) {
        int a[] = new int[1000];
        Scanner sc = new Scanner(System.in);
//        System.out.println("Nhap vao so luong node: ");
        int n = sc.nextInt();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++){
            int k = sc.nextInt();
            list.add(k);
        }
        int fl =0;
        String s1 = "addlast";
        String s2 = "remove";
        String s3 = "addfirst";
        String s4 = "addafter";
        String s5 = "addbefore";
        String s6 = "reverse";
        String s7 = "#";
        String chuoi;
        do {
            chuoi = sc.nextLine();
            String tach[] = chuoi.split(" ");
            if (tach[0].equals(s1)){
                int al = Integer.parseInt(tach[1]);
                for (int i = 0; i < list.size(); i++){
                    if(list.get(i) == al){
                        fl = 1;
                    }
                }
                if(fl == 0){
                    list.addLast(al);
                }
                fl = 0;
            } else if (tach[0].equals(s2)) {
                int rm = Integer.parseInt(tach[1]);
                for (int i = 0; i < list.size(); i++){
                    if (list.get(i) == rm){
                        list.remove(i);
                    }
                }
            } else if (tach[0].equals(s3)) {
                int af = Integer.parseInt(tach[1]);
                for (int i = 0; i < list.size(); i++){
                    if(list.get(i) == af){
                        fl = 1;
                    }
                }
                if(fl == 0){
//                    System.out.println(af);
                    list.addFirst(af);
                }
                fl = 0;
            } else if (tach[0].equals(s4)) {
                int aa = Integer.parseInt(tach[1]);
                int p = Integer.parseInt(tach[2]);
                for (int i = 0; i < list.size(); i++){
                    if(list.get(i) == aa){
                        fl = 1;
                        break;
                    }
                }
                if(fl == 0){
                    for(int i = 0; i < list.size(); i++){
                        if (list.get(i) == p){
                            list.add(i+1,aa);
                            break;
                        }
                    }
                }
                fl = 0;
            } else if (tach[0].equals(s5)) {
                int ab = Integer.parseInt(tach[1]);
                int q =  Integer.parseInt(tach[2]);
                for (int i = 0; i < list.size(); i++){
                    if(list.get(i) == ab){
                        fl = 1;
                        break;
                    }
                }
                if(fl == 0)
                {
                    for (int i = 0; i < list.size(); i++){
                        if (list.get(i) == q){
                            list.add(i,ab);
                            break;
                        }
                    }
                }
                fl=0;
            } else if (tach[0].equals(s6)) {
                for (int i = 0; i < list.size(); i++){
                    a[i]= list.get(i);
                }
                for (int i = 0; i < list.size(); i++){
                    list.set(i, a[list.size()-i-1]);
                }
            } else if (tach[0].equals(s7)){
                break;
            }
        }
        while (true);
        ListIterator<Integer> listIterator = list.listIterator();
        while (listIterator.hasNext()){
            System.out.print(listIterator.next()+" ");
        }
    }
}
