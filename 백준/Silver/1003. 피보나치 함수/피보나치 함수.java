class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        int n = read();
        int[][] dp = new int[41][2];
        dp[0][0] = 1;
        dp[1][1] = 1;
        for (int i = 2; i < 41; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = read();
            sb.append(dp[num][0]).append(" ").append(dp[num][1]).append("\n");
        }
        System.out.println(sb);
    }
}