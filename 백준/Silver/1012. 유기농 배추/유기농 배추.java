import java.util.*;
import java.io.*;

class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int t = read();
        for (int a = 0; a < t; a++) {
            int answer = 0;
            int n = read();
            int m = read();
            int k = read();
            boolean[][] arr = new boolean[n][m];
            for (int b = 0; b < k; b++) {
                int x = read();
                int y = read();
                arr[x][y] = true;
            }
            boolean[][] ch = new boolean[n][m];
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};
            Queue<int[]> q = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] && !ch[i][j]) {
                        answer++;
                        ch[i][j] = true;
                        q.offer(new int[] {i, j});
                        while (!q.isEmpty()) {
                            int[] point = q.poll();
                            for (int l = 0; l < 4; l++) {
                                int nx = point[0] + dx[l];
                                int ny = point[1] + dy[l];
                                if (nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] && !ch[nx][ny]) {
                                    ch[nx][ny] = true;
                                    q.offer(new int[] {nx, ny});
                                }
                            }
                        }
                    }
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}