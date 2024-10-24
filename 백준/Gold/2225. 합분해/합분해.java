class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        int n = read();
        int k = read();
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= k; i++) dp[0][i] = 1;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000000;
            }
        }
        System.out.println(dp[n][k]);
    }
}