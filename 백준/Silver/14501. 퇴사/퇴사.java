class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        int n = read();
        int[] dp = new int[n + 1];
        int p, t, d;
        for (int i = 0; i < n; i++) {
            p = read();
            t = read();
            d = i + p;
            if (dp[i + 1] < dp[i]) dp[i + 1] = dp[i];
            if (d <= n) dp[d] = Math.max(dp[d], dp[i] + t);
        }
        System.out.println(dp[n]);
    }
}