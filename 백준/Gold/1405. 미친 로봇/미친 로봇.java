class Main {
    static int n;
    static double answer = 0;
    static double[] percentage = new double[4];
    static boolean[][] ch;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int read() throws Exception {
        int a, b = System.in.read() & 15;
        while ((a = System.in.read()) > 47) b = (b << 3) + (b << 1) + (a & 15);
        return b;
    }

    public static void main(String[] args) throws Exception {
        n = read();
        for (int i = 0; i < 4; i++) {
            percentage[i] = read() / 100.0;
        }
        ch = new boolean[2 * n + 1][2 * n + 1];
        ch[n][n] = true;
        DFS(n, n, 0, 1);
        System.out.println(answer);
    }

    static void DFS(int x, int y, int count, double percent) {
        if (count == n) {
            answer += percent;
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (percentage[i] == 0) continue;
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (!ch[nx][ny]) {
                ch[nx][ny] = true;
                DFS(nx, ny, count + 1, percent * percentage[i]);
                ch[nx][ny] = false;
            }
        }
    }
}