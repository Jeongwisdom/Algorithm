import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        boolean[][] arr = new boolean[n + 1][m + 1];
        boolean[][] ch = new boolean[n + 1][m + 1];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = true;
        }
        Queue<int[]> q = new LinkedList<>();
        int answer = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (arr[i][j] && !ch[i][j]) {
                    q.offer(new int[] {i, j});
                    ch[i][j] = true;
                    int area = 0;
                    while (!q.isEmpty()) {
                        area++;
                        int[] point = q.poll();
                        for (int l = 0; l < 4; l++) {
                            int nx = point[0] + dx[l];
                            int ny = point[1] + dy[l];
                            if (nx >= 0 && nx <= n && ny >= 0 && ny <= m && arr[nx][ny] && !ch[nx][ny]) {
                                ch[nx][ny] = true;
                                q.offer(new int[] {nx, ny});
                            }
                        }
                    }
                    if (answer < area) answer = area;
                }
            }
        }
        System.out.println(answer);
    }
}