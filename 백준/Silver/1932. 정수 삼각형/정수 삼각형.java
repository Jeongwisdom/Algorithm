class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        int n = read();
        int[][] arr = new int[n][n + 2];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < i + 2; j++) {
                arr[i][j] = read();
            }
        }
        
        int[][] dp = new int[n][n + 2];
        dp[0][1] = arr[0][1];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < i + 2; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + arr[i][j];
            }
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (answer < dp[n - 1][i]) answer = dp[n - 1][i];
        }
        System.out.println(answer);
    }
}