class Main {
    static int read() throws Exception {
        int c, n = System.in.read();
        boolean minus = true;
        if (n > 47) {
            minus = false;
            n &= 15;
        } else n = 0;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return minus? -1 * n: n;
    }

    public static void main(String[] args) throws Exception {
        int n = read();
        int m = read();
        int[][] arr = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                arr[i][j] = arr[i][j - 1] + arr[i - 1][j] - arr[i - 1][j - 1] + read();
            }
        }

        int k = read();
        int i, j, x, y, sum;
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < k; t++) {
            i = read();
            j = read();
            x = read();
            y = read();
            sum =  arr[x][y] - arr[x][j - 1] - arr[i - 1][y] + arr[i - 1][j - 1];
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}