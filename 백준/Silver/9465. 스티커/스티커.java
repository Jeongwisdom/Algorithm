import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n];
            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            int[][] dp = new int[3][n + 1];
            for (int j = 0; j < n; j++) {
                dp[0][j + 1] = Math.max(dp[0][j], Math.max(dp[1][j], dp[2][j]));
                dp[1][j + 1] = Math.max(dp[0][j], dp[2][j]) + arr[0][j];
                dp[2][j + 1] = Math.max(dp[0][j], dp[1][j]) + arr[1][j];
            }
            sb.append(Math.max(dp[0][n], Math.max(dp[1][n], dp[2][n]))).append("\n");
        }
        System.out.println(sb);
    }
}