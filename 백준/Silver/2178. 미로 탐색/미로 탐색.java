import java.io.*;
import java.util.*;

class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        int n = read();
        int m = read();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = System.in.read() & 15;
            }
            System.in.read();
        }
        Queue<int[]> q = new LinkedList<>();
        boolean[][] ch = new boolean[n][m];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        q.offer(new int[] {0, 0});
        ch[0][0] = true;
        int answer = 0;
        loop:
        while (!q.isEmpty()) {
            answer++;
            Queue<int[]> e = new LinkedList<>();
            while (!q.isEmpty()) {
                int[] point = q.poll();
                if (point[0] == n - 1 && point[1] == m - 1) break loop;
                for (int i = 0; i < 4; i++) {
                    int nx = point[0] + dx[i];
                    int ny = point[1] + dy[i];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] == 1 && !ch[nx][ny]) {
                        ch[nx][ny] = true;
                        e.offer(new int[] {nx, ny});
                    }
                }
            }
            q = e;
        }
        System.out.println(answer);
    }
}