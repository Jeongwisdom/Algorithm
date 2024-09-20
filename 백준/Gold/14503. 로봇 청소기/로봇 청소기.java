import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        loop:
        while (true) {
            if (arr[r][c] == 0) {
                answer++;
                arr[r][c] = 2;
            }
            for (int i = 0; i < 4; i++) {
                d--;
                if (d < 0) d = 3;
                int nx = r + dx[d];
                int ny = c + dy[d];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && arr[nx][ny] == 0) {
                    r = nx;
                    c = ny;
                    continue loop;
                }
            }
            int nx = r - dx[d];
            int ny = c - dy[d];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m && arr[nx][ny] != 1) {
                r = nx;
                c = ny;
            } else break;
        }
        System.out.println(answer);
    }
}