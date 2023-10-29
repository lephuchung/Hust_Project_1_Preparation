import java.util.*;
import java.io.*;
public class Ex4 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Map<Integer, Integer> count = new HashMap<>();
        int kq = 0;
        for (int i = 0; i < n; i++) {
            int complement = m - arr[i];
            if (count.containsKey(complement)) {
                kq += count.get(complement);
            }
            count.put(arr[i], count.getOrDefault(arr[i], 0) + 1);
        }
        System.out.println(kq);
    }
}