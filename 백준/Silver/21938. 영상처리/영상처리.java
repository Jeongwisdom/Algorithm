import java.util.*;

class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        int n = read();
        int m = read();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = (read() + read() + read()) / 3;
            }
        }
        int t = read();
        
        boolean[][] ch = new boolean[n][m];
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!ch[i][j]) {
                    ch[i][j] = true;
                    if (arr[i][j] >= t) {
                        answer++;
                        Deque<int[]> q = new ArrayDeque<>();
                        q.offer(new int[] {i, j});
                        while (!q.isEmpty()) {
                            int[] p = q.poll();
                            for (int k = 0; k < 4; k++) {
                                int nx = p[0] + dx[k];
                                int ny = p[1] + dy[k];
                                if (nx < 0 || ny < 0 || nx >= n || ny >= m || ch[nx][ny]) continue;
                                ch[nx][ny] = true;
                                if (arr[nx][ny] >= t) {
                                    q.offer(new int[] {nx, ny});
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
}