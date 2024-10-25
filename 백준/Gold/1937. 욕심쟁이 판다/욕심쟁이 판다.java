import java.io.*;

class Main {
    static int n;
    static int[][] bamboo, dp;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        bamboo = new int[n][n];
        String[] split;
        for (int i = 0; i < n; i++) {
            split = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                bamboo[i][j] = Integer.parseInt(split[j]);
            }
        }

        dp = new int[n][n];
        int answer = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer = Math.max(answer, DFS(i, j));
            }
        }
        System.out.println(answer);
    }

    static int DFS(int x, int y) {
        if (dp[x][y] > 0) return dp[x][y];
        dp[x][y] = 1;
        int nx, ny;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
            if (bamboo[x][y] < bamboo[nx][ny]) dp[x][y] = Math.max(dp[x][y], DFS(nx, ny) + 1);
        }
        return dp[x][y];
    }
}