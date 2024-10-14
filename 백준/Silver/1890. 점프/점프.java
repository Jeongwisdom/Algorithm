class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        int n = read();
        long[][] arr = new long[n][n];
        arr[0][0] = 1;
        int num;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                num = read();
                if (num == 0) continue;
                if (i + num < n) arr[i + num][j] += arr[i][j];
                if (j + num < n) arr[i][j + num] += arr[i][j];
            }
        }
        System.out.println(arr[n - 1][n - 1]);
    }
}