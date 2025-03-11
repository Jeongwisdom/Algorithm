class Main {
    static int read() throws Exception {
        boolean minus = false;
        int c, n = System.in.read();
        if (n == 45) {
            minus = true;
            n = System.in.read();
        }
        n = n & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return minus? -n: n;
    }

    public static void main(String[] args) throws Exception {
        int tomato = 0, M = read(), N = read(), H = read();
        int[][][] arr = new int[H][N][M];
        int HNM = H * N * M;
        int[] qx = new int[HNM];
        int[] qy = new int[HNM];
        int[] qz = new int[HNM];
        int head = 0, tail = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    arr[i][j][k] = read();
                    if (arr[i][j][k] == 0) tomato++;
                    else if (arr[i][j][k] == 1) {
                        qz[tail] = i;
                        qx[tail] = j;
                        qy[tail++] = k;
                    }
                }
            }
        }

        int[] dx = {1, -1, 0, 0, 0, 0};
        int[] dy = {0, 0, 1, -1, 0, 0};
        int[] dz = {0, 0, 0, 0, 1, -1};
        int nx, ny, nz, len, cnt = 0;
        while (head < tail) {
            if (tomato == 0) break;
            cnt++;
            len = tail - head;
            while (len-- > 0) {
                for (int i = 0; i < 6; i++) {
                    nz = qz[head] + dz[i];
                    nx = qx[head] + dx[i];
                    ny = qy[head] + dy[i];
                    if (nz < 0 || nx < 0 || ny < 0 || nz >= H || nx >= N || ny >= M) continue;
                    if (arr[nz][nx][ny] != 0) continue;
                    arr[nz][nx][ny] = 1;
                    qz[tail] = nz;
                    qx[tail] = nx;
                    qy[tail++] = ny;
                    tomato--;
                }
                head++;
            }
        }
        if (tomato > 0) cnt = -1;
        System.out.println(cnt);
    }
}