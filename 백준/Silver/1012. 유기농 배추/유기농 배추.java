import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int a = 0; a < t; a++) {
            int answer = 0;
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            boolean[][] arr = new boolean[n][m];
            for (int b = 0; b < k; b++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
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