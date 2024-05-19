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
                arr[i][j] = read();
            }
        }
        
        boolean[][] ch = new boolean[n][m];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int count = 0;
        int area = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1 && !ch[i][j]) {
                    count++;
                    int a = 0;
                    Queue<int[]> q = new ArrayDeque<>();
                    q.offer(new int[] {i, j});
                    ch[i][j] = true;
                    while (!q.isEmpty()) {
                        int[] p = q.poll();
                        a++;
                        for (int k = 0; k < 4; k++) {
                            int nx = p[0] + dx[k];
                            int ny = p[1] + dy[k];
                            if (nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] == 1 && !ch[nx][ny]) {
                                q.offer(new int[] {nx, ny});
                                ch[nx][ny] = true;
                            }
                        }
                    }
                    if (a > area) area = a;
                }
            }
        }
        System.out.println(count + "\n" + area);
    }
}