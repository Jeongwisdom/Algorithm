import java.util.*;

class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int t = read();
        int[] dx = {-2, -2, 2, 2, -1, 1, -1, 1};
        int[] dy = {-1, 1, -1, 1, -2, -2, 2, 2};
        for (int c = 0; c < t; c++) {
            int n = read();
            int sx = read();
            int sy = read();
            int ex = read();
            int ey = read();
            Queue<int[]> q = new ArrayDeque<>();
            int[][] ch = new int[n][n];
            ch[sx][sy] = 1;
            q.offer(new int[] {sx, sy});
            while (!q.isEmpty()) {
                int[] point = q.poll();
                if (ex == point[0] && ey == point[1]) break;
                for (int i = 0; i < 8; i++) {
                    int nx = point[0] + dx[i];
                    int ny = point[1] + dy[i];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < n && ch[nx][ny] == 0) {
                        ch[nx][ny] = ch[point[0]][point[1]] + 1;
                        q.offer(new int[] {nx, ny});
                    }
                }
            }
            sb.append(ch[ex][ey] - 1).append("\n");
        }
        System.out.println(sb);
    }
}