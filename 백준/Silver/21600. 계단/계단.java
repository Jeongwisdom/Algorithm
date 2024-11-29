class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        int num, n = read(), max = 0;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            num = read();
            dp[i] = Math.min(dp[i - 1] + 1, num);
            if (max < dp[i]) max = dp[i];
        }
        System.out.println(max);
    }
}