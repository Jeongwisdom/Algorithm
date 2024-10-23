class Main {
    static int n, m;
    static int[][] arr, dp;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static int read() throws Exception {
        int r, c = System.in.read() & 15;
        while ((r = System.in.read()) > 47) c = (c << 3) + (c << 1) + (r & 15);
        return c;
    }

    public static void main(String[] args) throws Exception {
        n = read();
        m = read();
        arr = new int[n][m];
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = read();
                dp[i][j] = -1;
            }
        }

        System.out.println(DFS(0, 0));
    }

    static int DFS(int x, int y) {
        if (x == n - 1 && y == m - 1) return 1;
        if (dp[x][y] != -1) return dp[x][y];

        dp[x][y] = 0;
        int nx, ny;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if (arr[x][y] > arr[nx][ny]) {
                dp[x][y] += DFS(nx, ny);
            }
        }

        return dp[x][y];
    }
}