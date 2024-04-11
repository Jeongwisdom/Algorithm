import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= n; i++) {
            int value = (int) Math.pow(i, 2);
            for (int j = value; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - value] + 1);
            }
        }
        System.out.println(dp[n]);
    }
}