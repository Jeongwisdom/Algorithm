import java.util.*;

class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        int m = read();
        int n = read();
        int[][] arr = new int[n][m];
        Deque<int[]> q = new ArrayDeque<>();
        int tomato = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = read();
                if (arr[i][j] == 1) q.offer(new int[] {i, j});
                else if (arr[i][j] == 0) tomato++;
            }
        }
        int answer = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while (!q.isEmpty()) {
            if (tomato == 0) break;
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int[] point = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = point[0] + dx[j];
                    int ny = point[1] + dy[j];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < m && arr[nx][ny] == 0) {
                        arr[nx][ny] = 1;
                        tomato--;
                        q.offer(new int[] {nx, ny});
                    }
                }
            }
            answer++;
        }
        if (tomato != 0) answer = -1;
        System.out.println(answer);
    }
}