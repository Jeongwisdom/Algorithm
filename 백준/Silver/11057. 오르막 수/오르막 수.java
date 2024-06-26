import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n][10];
        for (int i = 0; i <= 9; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i - 1][k];
                }
                dp[i][j] %= 10007;
            }
        }
        long answer = 0;
        for (int i = 0; i <= 9; i++) {
            answer += dp[n - 1][i];
        }
        System.out.println(answer % 10007);
    }
}