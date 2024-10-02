class Main {
    static int read() throws Exception {
        int c, n = System.in.read();
        boolean minus = true;
        if (n > 47) {
            minus = false;
            n &= 15;
        } else n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return minus? -1 * n: n;
    }
    
    public static void main(String[] args) throws Exception {
        int n = read();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = read();
        }
        
        int[] dp = new int[n];
        dp[0] = arr[0];
        int answer = arr[0];
        for (int i = 1; i < n; i++) {
            if (dp[i - 1] <= 0) dp[i] = arr[i];
            else dp[i] = dp[i - 1] + arr[i];
            if (answer < dp[i]) answer = dp[i];
        }
        System.out.println(answer);
    }
}