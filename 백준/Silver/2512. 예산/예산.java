import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int min = 1;
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (max < arr[i]) max = arr[i];
        }
        int m = Integer.parseInt(br.readLine());
        while (min <= max) {
            int mid = (min + max) / 2;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] > mid) sum += mid;
                else sum += arr[i];
            }
            if (sum <= m) min = mid + 1;
            else max = mid - 1;
        }
        System.out.println(max);
    }
}