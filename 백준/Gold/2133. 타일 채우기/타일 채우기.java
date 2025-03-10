import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        if ((n & 1) == 1) {
            System.out.println(0);
        } else {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[2] = 3;
            for (int i = 4; i <= n; i += 2) {
                dp[i] = dp[i - 2] * 4 - dp[i - 4];
            }
            System.out.println(dp[n]);
        }
    }
}