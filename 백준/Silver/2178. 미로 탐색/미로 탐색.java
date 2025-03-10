class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws Exception {
        int n = read(), m = read();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = System.in.read() & 15;
            }
            System.in.read();
        }

        int NM = n * m;
        int[] qx = new int[NM];
        int[] qy = new int[NM];
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int head = 0, tail = 1;
        arr[0][0] = 0;
        int nx, ny, len, cnt = 0;
        loop:
        while (head < tail) {
            cnt++;
            len = tail - head;
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < 4; j++) {
                    nx = qx[head] + dx[j];
                    ny = qy[head] + dy[j];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                    if (arr[nx][ny] == 0) continue;
                    if (nx == n - 1 && ny == m - 1) break loop;
                    arr[nx][ny] = 0;
                    qx[tail] = nx;
                    qy[tail++] = ny;
                }
                head++;
            }
        }
        System.out.println(++cnt);
    }
}