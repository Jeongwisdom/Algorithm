import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n + 1][k + 1];
        System.out.println(calculate(dp, n, k));
    }
    
    public static int calculate(int[][] dp, int n, int k) {
        if (dp[n][k] > 0) return dp[n][k];
        if (k == 0 || n == k) return dp[n][k] = 1;
        return dp[n][k] = (calculate(dp, n - 1, k - 1) + calculate(dp, n - 1, k)) % 10007;
    }
}