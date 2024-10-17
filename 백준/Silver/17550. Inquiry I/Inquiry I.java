class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws Exception {
        int n = read();
        long[] arr = new long[n + 1];
        long[] dp = new long[n + 1];
        long num;
        for (int i = 1; i <= n; i++) {
            num = read();
            arr[i] = arr[i - 1] + num;
            dp[i] = dp[i - 1] + num * num;
        }

        long max = 0;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, dp[i] * (arr[n] - arr[i]));
        }
        System.out.println(max);
    }
}