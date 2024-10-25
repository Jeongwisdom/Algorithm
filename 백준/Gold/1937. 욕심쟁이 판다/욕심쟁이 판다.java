class Main {
    static int n;
    static int[][] bamboo, dp;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static int read() throws Exception {
        int r, c = System.in.read() & 15;
        while ((r = System.in.read()) > 47) c = (c << 3) + (c << 1) + (r & 15);
        return c;
    }

    public static void main(String[] args) throws Exception {
        n = read();
        bamboo = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bamboo[i][j] = read();
            }
        }

        dp = new int[n][n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer = Math.max(answer, DFS(i, j));
            }
        }
        System.out.println(answer);
    }

    static int DFS(int x, int y) {
        if (dp[x][y] != 0) return dp[x][y];
        int nx, ny;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
            if (bamboo[x][y] < bamboo[nx][ny]) dp[x][y] = Math.max(dp[x][y], DFS(nx, ny));
        }
        return ++dp[x][y];
    }
}