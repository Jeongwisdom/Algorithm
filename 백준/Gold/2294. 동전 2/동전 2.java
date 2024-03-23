import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] dp = new int[k + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE - 1;
        }
        
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            for (int j = num; j < dp.length; j++) {
                dp[j] = Math.min(dp[j], dp[j - num] + 1);
            }
        }
        
        int answer = dp[k] == Integer.MAX_VALUE - 1? -1: dp[k];
        System.out.println(answer);
    }
}