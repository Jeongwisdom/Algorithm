import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int min = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (max < arr[i]) max = arr[i];
        }
        while (min <= max) {
            int mid = (min + max) / 2;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                int remain = arr[i] - mid;
                if (remain > 0) sum += remain;
            }
            if (sum >= m) min = mid + 1;
            else max = mid - 1;
        }
        System.out.println(max);
    }
}