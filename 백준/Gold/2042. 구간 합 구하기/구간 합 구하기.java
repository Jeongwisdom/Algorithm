class Main {
    static long read() throws Exception {
        long c, n = System.in.read();
        boolean minus = false;
        if (n > 47) n = n & 15;
        else {
            minus = true;
            n = 0;
        }
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return minus? -1 * n: n;
    }
    
    public static void main(String[] args) throws Exception {
        int n = (int) read(), m = (int) read(), k = (int) read();
        long[] arr = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = read();
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m + k; i++) {
            int a = (int) read(), b = (int) read();
            long c = read();
            if (a == 1) {
                arr[b] = c;
            } else {
                long answer = 0;
                for (int j = b; j <= c; j++) {
                    answer += arr[j];
                }
                sb.append(answer).append("\n");
            }
        }
        
        System.out.println(sb);
    }
}