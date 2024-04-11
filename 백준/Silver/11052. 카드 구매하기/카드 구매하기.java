import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int p = Integer.parseInt(st.nextToken());
            for (int j = i; j <= n; j++) {
                int v = dp[j - i] + p;
                if (dp[j] < v) dp[j] = v;
            }
        }
        System.out.println(dp[n]);
    }
}