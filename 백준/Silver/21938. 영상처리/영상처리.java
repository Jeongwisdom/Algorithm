class Main {
    static int[][] arr;
    static int n, m, t, nx, ny, answer = 0;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        n = read();
        m = read();
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = (read() + read() + read()) / 3;
            }
        }
        t = read();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] >= t) {
                    answer++;
                    arr[i][j] = -1;
                    DFS(i, j);
                }
            }
        }
        System.out.println(answer);
    }
    
    static void DFS(int x, int y) {
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if (arr[nx][ny] >= t) {
                arr[nx][ny] = -1;
                DFS(nx, ny);
            }
        }
    }
}