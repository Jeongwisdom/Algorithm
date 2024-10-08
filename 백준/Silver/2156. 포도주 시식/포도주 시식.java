class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws Exception {
        int n = read();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = read();
        }

        int[] dp = new int[n + 1];
        dp[1] = arr[1];
        if (n >= 2) dp[2] = dp[1] + arr[2];
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i]);
        }
        System.out.println(dp[n]);
    }
}