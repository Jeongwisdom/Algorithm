import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        int answer = 0;
        int sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            while (sum + arr[i] <= k) {
                sum += arr[i];
                answer++;
            }
            if (sum == k) break;
        }
        System.out.println(answer);
    }
}