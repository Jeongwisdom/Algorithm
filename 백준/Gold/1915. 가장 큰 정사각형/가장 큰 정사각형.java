import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int[][] arr = new int[n + 1][m + 1];
        int[][] dp = new int[n + 1][m + 1];
        int answer = 0;
        String str;
        for (int i = 1; i <= n; i++) {
            str = br.readLine();
            for (int j = 1; j <= m; j++) {
                arr[i][j] = str.charAt(j - 1) - '0';
                if (arr[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    if (answer < dp[i][j]) answer = dp[i][j];
                }
            }
        }
        System.out.println(answer * answer);
    }
}