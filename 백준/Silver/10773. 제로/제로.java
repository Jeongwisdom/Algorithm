class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        int k = read();
        int[] dp = new int[k + 1];
        int num, id = 1;
        
        while (k-- > 0) {
            num = read();
            if (num == 0) id--;
            else {
                dp[id] = dp[id - 1] + num;
                id++;
            }
        }
        System.out.println(dp[id - 1]);
    }
}