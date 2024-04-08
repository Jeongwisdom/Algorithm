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
            int[][] dp = new int[2][n + 2];
            for (int j = 2; j < n + 2; j++) {
                int ex = Math.max(dp[0][j - 2], dp[1][j - 2]);
                dp[0][j] = Math.max(ex, dp[1][j - 1]) + arr[0][j - 2];
                dp[1][j] = Math.max(ex, dp[0][j - 1]) + arr[1][j - 2];
            }
            sb.append(Math.max(dp[0][n + 1], dp[1][n + 1])).append("\n");
        }
        System.out.println(sb);
    }
}