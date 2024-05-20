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
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx].charAt(ny) == '1' && !ch[nx][ny]) {
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