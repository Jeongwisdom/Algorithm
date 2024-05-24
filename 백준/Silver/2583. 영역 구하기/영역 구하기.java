import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        boolean[][] arr = new boolean[n][m];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            for (int a = x1; a < x2; a++) {
                for (int b = y1; b < y2; b++) {
                    arr[a][b] = true;
                }
            }
        }
        boolean[][] ch = new boolean[n][m];
        Queue<int[]> q = new ArrayDeque<>();
        Queue<Integer> pq = new PriorityQueue<>();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!arr[i][j] && !ch[i][j]) {
                    ch[i][j] = true;
                    q.offer(new int[] {i, j});
                    int area = 0;
                    while (!q.isEmpty()) {
                        int[] point = q.poll();
                        for (int l = 0; l < 4; l++) {
                            int nx = point[0] + dx[l];
                            int ny = point[1] + dy[l];
                            if (nx >= 0 && ny >= 0 && nx < n && ny < m && !arr[nx][ny] &&!ch[nx][ny]) {
                                ch[nx][ny] = true;
                                q.offer(new int[] {nx, ny});
                            }
                        }
                        area++;
                    }
                    pq.offer(area);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(pq.size()).append("\n");
        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append(" ");
        }
        System.out.println(sb);
    }
}