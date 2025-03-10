class Main {
    static int read() throws Exception {
        boolean minus = false;
        int c, n = System.in.read();
        if (n == 45) {
            minus = true;
            n = System.in.read();
        }
        n = n & 15;
        while ((c =  System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return minus? -n: n;
    }

    public static void main(String[] args) throws Exception {
        int m = read(), n = read();
        int[][] arr = new int[n][m];
        int NM = n * m;
        int[] qx = new int[NM];
        int[] qy = new int[NM];
        int tomato = 0, head = 0, tail = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = read();
                if (arr[i][j] == 0) tomato++;
                else if (arr[i][j] == 1) {
                    qx[tail] = i;
                    qy[tail++] = j;
                }
            }
        }

        int nx, ny, len, cnt = 0;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        while (head < tail) {
            if (tomato == 0) break;
            cnt++;
            len = tail - head;
            while (len-- > 0) {
                for (int i = 0; i < 4; i++) {
                    nx = qx[head] + dx[i];
                    ny = qy[head] + dy[i];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                    if (arr[nx][ny] != 0) continue;
                    arr[nx][ny] = 1;
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