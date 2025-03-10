import java.util.*;

class Main {
    static int n, m, nx, ny;
    static int[][] arr;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int read() throws Exception {
        int r, c = System.in.read() & 15;
        while ((r = System.in.read()) > 47) c = (c << 3) + (c << 1) + (r & 15);
        return c;
    }

    public static void main(String[] args) throws Exception {
        n = read();
        m = read();
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = read();
            }
        }

        int num = 0, max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) continue;
                arr[i][j] = 0;
                num++;
                max = Math.max(max, BFS(i, j));
            }
        }
        System.out.println(num);
        System.out.println(max);
    }

    static int BFS(int x, int y) {
        Deque<int[]> q = new ArrayDeque<>();
        int area = 1;
        q.offer(new int[] {x, y});
        while (!q.isEmpty()) {
            int[] p = q.poll();
            for (int i = 0; i < 4; i++) {
                nx = p[0] + dx[i];
                ny = p[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (arr[nx][ny] == 0) continue;
                arr[nx][ny] = 0;
                q.offer(new int[] {nx, ny});
                area++;
            }
        }
        return area;
    }
}