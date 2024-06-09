import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        Queue<int[]> q = new ArrayDeque<>();
        int[][][] arr = new int[h][n][m];
        int zero = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if (arr[i][j][k] == 0) zero++;
                    else if (arr[i][j][k] == 1) q.offer(new int[] {i, j, k});
                }
            }
        }
        
        int[] dx = {-1, 1, 0, 0, 0, 0};
        int[] dy = {0, 0, -1, 1, 0, 0};
        int[] dz = {0, 0, 0, 0, -1, 1};
        int answer = 0;
        loop:
        while (zero != 0 && !q.isEmpty()) {
            int len = q.size();
            answer++;
            for (int i = 0; i < len; i++) {
                int[] point = q.poll();
                for (int j = 0; j < 6; j++) {
                    int nz = point[0] + dz[j];
                    int nx = point[1] + dx[j];
                    int ny = point[2] + dy[j];
                    if (nz >= 0 && nx >= 0 && ny >= 0  && nz < h && nx < n && ny < m && arr[nz][nx][ny] == 0) {
                        arr[nz][nx][ny] = 1;
                        zero--;
                        q.offer(new int[] {nz, nx, ny});
                    }
                    if (zero == 0) break loop;
                }
            }
        }
        if (zero > 0) answer = -1;
        System.out.println(answer);
    }
}