import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] arr1 = new char[n][n];
        char[][] arr2 = new char[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                arr1[i][j] = str.charAt(j);
                arr2[i][j] = arr1[i][j] == 'G'? 'R': arr1[i][j];
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(check(arr1, n)).append(" ").append(check(arr2, n));
        System.out.println(sb);
    }
    
    static int check(char[][] arr, int n) {
        int answer = 0;
        boolean[][] ch = new boolean[n][n];
        Queue<int[]> q = new ArrayDeque<>();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = arr[i][j];
                if (!ch[i][j]) {
                    ch[i][j] = true;
                    answer++;
                    q.offer(new int[] {i, j});
                    while (!q.isEmpty()) {
                        int[] point = q.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = point[0] + dx[k];
                            int ny = point[1] + dy[k];
                            if (nx >= 0 && ny >= 0 && nx < n && ny < n && arr[nx][ny] == c && !ch[nx][ny]) {
                                ch[nx][ny] = true;
                                q.offer(new int[] {nx, ny});
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
}