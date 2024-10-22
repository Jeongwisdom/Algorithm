class Main {
    public static void main(String[] args) throws Exception {
        char[] arr1 = read();
        char[] arr2 = read();
        int[][] dp = new int[arr1.length][arr2.length];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (arr1[i] == arr2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[arr1.length - 1][arr2.length - 1]);
    }

    static char[] read() throws Exception {
        StringBuilder sb = new StringBuilder("a");
        int c;
        while ((c = System.in.read()) > 64) sb.append((char)c);
        return sb.toString().toCharArray();
    }
}