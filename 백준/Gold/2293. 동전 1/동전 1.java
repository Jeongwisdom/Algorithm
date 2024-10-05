class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        int n = read();
        int k = read();
        int[] dp = new int[k + 1];
        dp[0] = 1;
        int coin;
        for (int i = 0; i < n; i++) {
            coin = read();
            for (int j = coin; j <= k; j++) {
                dp[j] += dp[j - coin];
            }
        }

        System.out.println(dp[k]);
    }
}