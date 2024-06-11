import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Queue<int[]> q = new ArrayDeque<>();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] > 0) q.offer(new int[] {i, j});
            }
        }
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int answer = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            int[][] a = new int[n][m];
            answer++;
            for (int i = 0; i < len; i++) {
                int[] point = q.poll();
                int x = point[0];
                int y = point[1];
                a[x][y] = arr[x][y];
                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < m && arr[nx][ny] <= 0) {
                        a[x][y]--;
                    }
                }
                if (a[x][y] > 0) q.offer(new int[] {x, y});
            } 
            arr = a;
            if (q.isEmpty()) break;
            
            int count = 1;
            boolean[][] ch = new boolean[n][m];
            Queue<int[]> tmp = new ArrayDeque<>();
            tmp.offer(q.peek());
            ch[q.peek()[0]][q.peek()[1]] = true;
            while (!tmp.isEmpty()) {
                int[] point = tmp.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = point[0] + dx[i];
                    int ny = point[1] + dy[i];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < m && !ch[nx][ny] && arr[nx][ny] > 0) {
                        ch[nx][ny] = true;
                        count++;
                        tmp.offer(new int[] {nx, ny});
                    }
                }
            }
            if (count < q.size()) break;
        }
        if (q.isEmpty()) answer = 0;
        System.out.println(answer);
    }
}