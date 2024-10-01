class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws Exception {
        int n = read();
        int[][] RGB = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 3; j++) {
                RGB[i][j] = read();
            }
        }

        int[][] dp = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + RGB[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + RGB[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + RGB[i][2];
        }

        int answer = Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2]));
        System.out.println(answer);
    }
}