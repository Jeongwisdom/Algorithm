class Main {
    static int n, m, nx, ny, NM, head, tail;
    static int[] qx, qy;
    static int[][] arr;
    static int[] dx = {0, 0, 1, -1};
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
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = read();
            }
        }

        NM = n * m;
        qx = new int[NM];
        qy = new int[NM];
        head = 0;
        tail = 0;
        int num = 0, max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) continue;
                arr[i][j] = 0;
                num++;
                max = Math.max(max, BFS(i, j));
            }
        }
        System.out.println(num);
        System.out.println(max);
    }

    static int BFS(int x, int y) {
        int area = 1;
        qx[tail] = x;
        qy[tail++] = y;
        while (head < tail) {
            for (int i = 0; i < 4; i++) {
                nx = qx[head] + dx[i];
                ny = qy[head] + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (arr[nx][ny] == 0) continue;
                arr[nx][ny] = 0;
                qx[tail] = nx;
                qy[tail++] = ny;
                area++;
            }
            head++;
        }
        return area;
    }
}