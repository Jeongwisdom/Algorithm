class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        int n = read();
        int m = read();
        int r = read();
        int c = read();
        int d = read();
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = read();
            }
        }

        int answer = 0;
        loop:
        while (true) {
            if (arr[r][c] == 0) {
                answer++;
                arr[r][c] = 2;
            }
            for (int i = 0; i < 4; i++) {
                d--;
                if (d < 0) d = 3;
                int nx = r + dx[d];
                int ny = c + dy[d];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && arr[nx][ny] == 0) {
                    r = nx;
                    c = ny;
                    continue loop;
                }
            }
            int nx = r - dx[d];
            int ny = c - dy[d];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m && arr[nx][ny] != 1) {
                r = nx;
                c = ny;
            } else break;
        }
        System.out.println(answer);
    }
}