class Main {
    static int c, n, nx, ny;
    static int[][] arr;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = System.in.read();
            }
            System.in.read();
        }

        int answer = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] < 3) continue;
                answer++;
                if (arr[i][j] == 66) DFS(i, j, 66, 2);
                else if (arr[i][j] == 71) DFS(i, j, 71, 1);
                else if (arr[i][j] == 82) DFS(i, j, 82, 1);
            }
        }
        sb.append(answer).append(" ");

        answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) continue;
                answer++;
                if (arr[i][j] == 1) DFS(i, j, 1, 0);
                else if (arr[i][j] == 2) DFS(i, j, 2, 0);
            }
        }
        sb.append(answer);
        System.out.println(sb);
    }

    static void DFS(int x, int y, int to, int from) {
        arr[x][y] = from;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
            if (arr[nx][ny] != to) continue;
            DFS(nx, ny, to, from);
        }
    }
}