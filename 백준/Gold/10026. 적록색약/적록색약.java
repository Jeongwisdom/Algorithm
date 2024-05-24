import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder[] arr = new StringBuilder[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new StringBuilder(br.readLine());
        }
        StringBuilder sb = new StringBuilder();
        sb.append(check(arr, n)).append(" ").append(check(arr, n));
        System.out.println(sb);
    }
    
    static int check(StringBuilder[] arr, int n) {
        int answer = 0;
        boolean[][] ch = new boolean[n][n];
        Queue<int[]> q = new ArrayDeque<>();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = arr[i].charAt(j);
                if (!ch[i][j]) {
                    ch[i][j] = true;
                    answer++;
                    q.offer(new int[] {i, j});
                    while (!q.isEmpty()) {
                        int[] point = q.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = point[0] + dx[k];
                            int ny = point[1] + dy[k];
                            if (nx >= 0 && ny >= 0 && nx < n && ny < n && arr[nx].charAt(ny) == c && !ch[nx][ny]) {
                                ch[nx][ny] = true;
                                q.offer(new int[] {nx, ny});
                            }
                        }
                    }
                }
                if (c == 'G') arr[i].setCharAt(j, 'R');
            }
        }
        return answer;
    }
}