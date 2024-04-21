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
            max += arr[i];
            if (min < arr[i]) min = arr[i];
        }
        
        while (min <= max) {
            int mid = (min + max) / 2;
            int count = 1;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (sum + arr[i] <= mid) sum += arr[i];
                else {
                    sum = arr[i];
                    count++;
                }
            }
            if (count <= m) max = mid - 1;
            else min = mid + 1;
        }
        System.out.println(min);
    }
}