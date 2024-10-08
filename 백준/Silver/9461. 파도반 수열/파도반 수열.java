class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws Exception {
        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i < 101; i++) {
            dp[i] = dp[i - 2] + dp[i - 3];
        }

        StringBuilder sb = new StringBuilder();
        int t = read();
        for (int i = 0; i < t; i++) {
            sb.append(dp[read()]).append("\n");
        }
        System.out.println(sb);
    }
}