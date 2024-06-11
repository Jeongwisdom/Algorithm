import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
        boolean[][][] ch = new boolean[2][n][m];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0, 0, 0});
        ch[0][0][0] = true;
        int answer = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        loop:
        while (!q.isEmpty()) {
            int len = q.size();
            answer++;
            for (int i = 0; i < len; i++) {
                int[] point = q.poll();
                ch[point[2]][point[0]][point[1]] = true;
                if (point[0] == n - 1 && point[1] == m - 1) {
                    q.offer(new int[] {1});
                    break loop;
                }
                for (int j = 0; j < 4; j++) {
                    int nx = point[0] + dx[j];
                    int ny = point[1] + dy[j];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                        if (arr[nx].charAt(ny) == '0') {
                            if (!ch[point[2]][nx][ny]) {
                                ch[point[2]][nx][ny] = true;
                                q.offer(new int[] {nx, ny, point[2]});
                            }
                        } else {
                            if (point[2] == 0 && !ch[1][nx][ny]) {
                                ch[1][nx][ny] = true;
                                q.offer(new int[] {nx, ny, 1});
                            }
                        }
                    }
                }
            }
        }
        if (q.isEmpty()) answer = -1;
        System.out.println(answer);
    }
}