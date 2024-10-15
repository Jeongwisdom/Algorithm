class Main {
    static int read() throws Exception {
        int c, n = System.in.read() &  15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        int n = read();
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            arr[i] = read();
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (answer < dp[i]) answer = dp[i];
        }
        System.out.println(answer);
    }
}