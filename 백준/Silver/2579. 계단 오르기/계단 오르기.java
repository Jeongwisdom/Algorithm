class Main {
    static int read() throws Exception {
        int r, c = System.in.read() & 15;
        while ((r = System.in.read()) > 47) c = (c << 3) + (c << 1) + (r & 15);
        return c;
    }

    public static void main(String[] args) throws Exception {
        int n = read();
        int[] stair = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            stair[i] = read();
        }

        int[] dp = new int[n + 1];
        dp[1] = stair[1];
        if (n >= 2) dp[2] = dp[1] + stair[2];
        for (int i = 3; i <= n; i++) {
            dp[i] = stair[i] + Math.max(dp[i - 2], dp[i - 3] + stair[i - 1]);
        }
        System.out.println(dp[n]);
    }
}