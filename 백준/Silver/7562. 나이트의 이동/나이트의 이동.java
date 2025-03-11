class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws Exception {
        int L, LL, X, Y, cnt, len, nx, ny, T = read();
        int[][] arr;
        int[] qx = new int[90000], qy = new int[90000];
        int[] dx = {2, 2, -2, -2, 1, -1, 1, -1};
        int[] dy = {1, -1, 1, -1, 2, 2, -2, -2};
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            L = read();
            arr = new int[L][L];
            int head = 0, tail = 0;
            qx[tail] = read();
            qy[tail++] = read();
            X = read();
            Y = read();
            cnt = 0;
            arr[qx[head]][qy[head]] = 1;
            while (head < tail) {
                if (arr[X][Y] == 1) break;
                cnt++;
                len = tail - head;
                while (len-- > 0) {
                    for (int i = 0; i < 8; i++) {
                        nx = qx[head] + dx[i];
                        ny = qy[head] + dy[i];
                        if (nx < 0 || ny < 0 || nx >= L || ny >= L) continue;
                        if (arr[nx][ny] == 1) continue;
                        arr[nx][ny] = 1;
                        qx[tail] = nx;
                        qy[tail++] = ny;
                    }
                    head++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}