class Main {
    static int read() throws Exception {
        int r, c = System.in.read() & 15;
        while ((r = System.in.read()) > 47) c = (c << 3) + (c << 1) + (r & 15);
        return c;
    }

    public static void main(String[] args) throws Exception {
        int n = read();
        int[] stair = new int[n];
        for (int i = 0; i < n; i++) {
            stair[i] = read();
        }

        int[][] dp = new int[n][2];
        dp[0][0] = stair[0];
        dp[0][1] = 1;
        if (n >= 2) {
            dp[1][0] = stair[0] + stair[1];
            dp[1][1] = 2;
        }
        if (n >= 3) {
            if (stair[0] + stair[2] < stair[1] + stair[2]) {
                dp[2][0] = stair[1] + stair[2];
                dp[2][1] = 2;
            } else {
                dp[2][0] = stair[0] + stair[2];
                dp[2][1] = 1;
            }
        }
        for (int i = 3; i < n; i++) {
            if (dp[i - 1][1] < 2) {
                dp[i][0] = dp[i - 1][0] + stair[i];
                dp[i][1] = dp[i - 1][1] + 1;
            } else {
                dp[i][0] = dp[i - 3][0] + stair[i - 1] + stair[i];
                dp[i][1] = 2;
            }
            if (dp[i][0] <= dp[i - 2][0] + stair[i]) {
                dp[i][0] = dp[i - 2][0] + stair[i];
                dp[i][1] = 1;
            }
        }
        System.out.println(dp[n - 1][0]);
    }
}