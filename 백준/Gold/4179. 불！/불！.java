class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws Exception {
        int R = read(), C = read();
        int[][] arr = new int[R][C];
        int RC = R * C;
        int[] Fx = new int[RC];
        int[] Fy = new int[RC];
        int[] Jx = new int[RC];
        int[] Jy = new int[RC];
        int Fhead = 0, Ftail = 0, Jhead = 0, Jtail = 1;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                arr[i][j] = System.in.read();
                if (arr[i][j] == 'J') {
                    Jx[0] = i;
                    Jy[0] = j;
                } else if (arr[i][j] == 'F') {
                    Fx[Ftail] = i;
                    Fy[Ftail++] = j;
                }
            }
            System.in.read();
        }

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int len, nx, ny, cnt = 0;
        loop:
        while (Jhead < Jtail) {
            cnt++;

            len = Ftail - Fhead;
            while (len-- > 0) {
                for (int i = 0; i < 4; i++) {
                    nx = Fx[Fhead] + dx[i];
                    ny = Fy[Fhead] + dy[i];
                    if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                    if (arr[nx][ny] != '.') continue;
                    arr[nx][ny] = 'F';
                    Fx[Ftail] = nx;
                    Fy[Ftail++] = ny;
                }
                Fhead++;
            }

            len = Jtail - Jhead;
            while (len-- > 0) {
                for (int i = 0; i < 4; i++) {
                    nx = Jx[Jhead] + dx[i];
                    ny = Jy[Jhead] + dy[i];
                    if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                        Jtail++;
                        break loop;
                    }
                    if (arr[nx][ny] != '.') continue;
                    arr[nx][ny] = 'J';
                    Jx[Jtail] = nx;
                    Jy[Jtail++] = ny;
                }
                Jhead++;
            }
        }
        if (Jhead == Jtail) System.out.println("IMPOSSIBLE");
        else System.out.println(cnt);
    }
}