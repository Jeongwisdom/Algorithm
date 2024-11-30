class Main {
    static int read() throws Exception {
        int r, c = System.in.read() & 15;
        while ((r = System.in.read()) > 47) c = (c << 3) + (c << 1) + (r & 15);
        return c;
    }
    
    public static void main(String[] args) throws Exception {
        int n = read() + 1;
        int m = read();
        int[][] dp = new int[n][n];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = read() + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int x1 = read() - 1;
            int y1 = read() - 1;
            int x2 = read();
            int y2 = read();
            sb.append(dp[x2][y2] + dp[x1][y1] - dp[x2][y1] - dp[x1][y2]).append("\n");
        }
        System.out.println(sb);
    }
}