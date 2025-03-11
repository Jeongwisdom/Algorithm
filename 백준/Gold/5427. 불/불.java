class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws Exception {
        int w, h, fhead, ftail, head, tail, cnt, len, nx, ny, T = read();
        int[][] arr;
        int[] fx = new int[1000000], fy = new int[1000000], qx = new int[1000000], qy = new int[1000000];
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            w = read();
            h = read();
            fhead = 0;
            ftail = 0;
            head = 0;
            tail = 0;
            arr = new int[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    arr[i][j] = System.in.read();
                    if (arr[i][j] == '@') {
                        qx[tail] = i;
                        qy[tail++] = j;
                    } else if (arr[i][j] == '*') {
                        fx[ftail] = i;
                        fy[ftail++] = j;
                    }
                }
                System.in.read();
            }

            cnt = 0;
            loop:
            while (head < tail) {
                cnt++;
                len = ftail - fhead;
                while (len-- > 0) {
                    for (int i = 0; i < 4; i++) {
                        nx = fx[fhead] + dx[i];
                        ny = fy[fhead] + dy[i];
                        if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
                        if (arr[nx][ny] != '.') continue;
                        arr[nx][ny] = '*';
                        fx[ftail] = nx;
                        fy[ftail++] = ny;
                    }
                    fhead++;
                }

                len = tail - head;
                while (len-- > 0) {
                    for (int i = 0; i < 4; i++) {
                        nx = qx[head] + dx[i];
                        ny = qy[head] + dy[i];
                        if (nx < 0 || ny < 0 || nx >= h || ny >= w) {
                            tail++;
                            break loop;
                        }
                        if (arr[nx][ny] != '.') continue;
                        arr[nx][ny] = '@';
                        qx[tail] = nx;
                        qy[tail++] = ny;
                    }
                    head++;
                }
            }
            if (head == tail) sb.append("IMPOSSIBLE\n");
            else sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}