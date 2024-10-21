class Main {
    public static void main(String[] args) throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 3;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] * 2 + dp[i - 2]) % 9901;
        }
        System.out.println(dp[n]);
    }
}