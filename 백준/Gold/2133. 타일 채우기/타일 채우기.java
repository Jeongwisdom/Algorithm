class Main {
    public static void main(String[] args) throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        
        if ((n & 1) == 1) {
            System.out.println(0);
        } else {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            if (n >= 2) dp[2] = 3;
            for (int i = 4; i <= n; i += 2) {
                dp[i] = dp[i - 2] * 4 - dp[i - 4];
            }
            System.out.println(dp[n]);
        }
    }
}