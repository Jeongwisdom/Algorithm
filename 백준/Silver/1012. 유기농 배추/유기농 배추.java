class Main {
    static int M, N, K, X, Y, nx, ny;
    static boolean[][] arr;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        int answer, T = read();
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            M = read();
            N = read();
            K = read();
            arr = new boolean[M][N];
            while (K-- > 0) {
                X = read();
                Y = read();
                arr[X][Y] = true;
            }
            
            answer = 0;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j]) {
                        answer++;
                        arr[i][j]= false;
                        DFS(i, j);
                    }
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
    
    static void DFS(int x, int y) {
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
            if (!arr[nx][ny]) continue;
            arr[nx][ny] = false;
            DFS(nx, ny);
        }
    }
}