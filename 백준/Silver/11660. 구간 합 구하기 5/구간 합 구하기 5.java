class Main {
    static int read() throws Exception {
        int r, c = System.in.read() & 15;
        while ((r = System.in.read()) > 47) c = (c << 3) + (c << 1) + (r & 15);
        return c;
    }
    
    public static void main(String[] args) throws Exception {
        int n = read();
        int m = read();
        int[][] dp = new int[n + 1][n + 1];
        int num;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                num = read();
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] + num - dp[i - 1][j - 1];
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int x1, y1, x2, y2, sum;
        for (int i = 0; i < m; i++) {
            x1 = read();
            y1 = read();
            x2 = read();
            y2 = read();
            sum = dp[x2][y2] + dp[x1 - 1][y1 - 1] - dp[x2][y1 - 1]  - dp[x1 - 1][y2];
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}