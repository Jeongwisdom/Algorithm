class Main {
    static int n, m, h, answer = -1;
    static int[][] arr;
    
    static int read() throws Exception {
        int r, c = System.in.read() & 15;
        while ((r = System.in.read()) > 47) c = (c << 3) + (c << 1) + (r & 15);
        return c;
    }

    public static void main(String[] args) throws Exception {
        n = read();
        m = read();
        h = read();
        arr = new int[h][n + 1];
        int a, b;
        for (int i = 0; i < m; i++) {
            a = read() - 1;
            b = read() - 1;
            arr[a][b] = 1;
            arr[a][b + 1] = -1;
        }

        for (int i = 0; i < 4; i++) {
            DFS(0, 0, 0, i);
            if (answer == i) break;
        }
        System.out.println(answer);
    }

    static void DFS(int x, int y, int count, int goal) {
        if (goal == answer) return;
        if (count == goal) {
            if (climb()) answer = count;
            return;
        }

        if (y >= n) {
            x++;
            y = 0;
        }
        if (x == h) return;

        if (arr[x][y] == 0 && arr[x][y + 1] == 0) {
            arr[x][y] = 1;
            arr[x][y + 1] = -1;
            DFS(x, y + 2, count + 1, goal);
            arr[x][y] = 0;
            arr[x][y + 1] = 0;
        }
        DFS(x, y + 1, count, goal);
    }

    static boolean climb() {
        for (int i = 0; i < n - 1; i++) {
            int ladder = i;
            for (int j = 0; j < h; j++) {
                ladder += arr[j][ladder];
            }
            if (ladder != i) return false;
        }
        return true;
    }
}