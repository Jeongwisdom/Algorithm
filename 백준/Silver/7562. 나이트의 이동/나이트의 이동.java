import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int[] dx = {-2, -2, 2, 2, -1, 1, -1, 1};
        int[] dy = {-1, 1, -1, 1, -2, -2, 2, 2};
        for (int c = 0; c < t; c++) {
            int n = Integer.parseInt(br.readLine());
            String[] start = br.readLine().split(" ");
            int sx = Integer.parseInt(start[0]);
            int sy = Integer.parseInt(start[1]);
            String[] end = br.readLine().split(" ");
            int ex = Integer.parseInt(end[0]);
            int ey = Integer.parseInt(end[1]);
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