class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        int n = read();
        int[] dp = new int[n + 1];
        int p, t, day;
        for (int i = 1; i <= n; i++) {
            p = read();
            t = read();
            if (dp[i] < dp[i - 1]) dp[i] = dp[i - 1];
            day = i + p - 1;
            if (day <= n) dp[day] = Math.max(dp[day], dp[i - 1] + t);
        }
        System.out.println(dp[n]);
    }
}