import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        
        int ex = (int) Math.round(n * 0.15);
        double sum = 0;
        for (int i = ex; i < n - ex; i++) {
            sum += arr[i];
        }
        int avg = (int) Math.round(sum / (n - 2 * ex));
        System.out.println(avg);
    }
}