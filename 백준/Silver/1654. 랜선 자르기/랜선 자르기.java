import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        long max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (max < arr[i]) max = arr[i];
        }
        
        long min = 1;
        while (min <= max) {
            long mid = (min + max) / 2;
            long count = 0;
            for (int i = 0; i < n; i++) {
                count += arr[i] / mid;
            }
            if (count < k) max = mid - 1;
            else min = mid + 1;
        }
        System.out.println(max);
    }
}