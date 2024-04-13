import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n][10];
        int mod = 1000000000;
        for (int i = 1; i <= 9; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][1] % mod;
            dp[i][9] = dp[i - 1][8] % mod;
            for (int j = 1; j <= 8; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
            }
        }
        
        long answer = 0;
        for (int i = 0; i <= 9; i++) {
            answer += dp[n - 1][i];
        }
        System.out.println(answer % 1000000000);
    }
}