import java.io.*;
import java.util.*;

class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m;
    static int[][] arr;
    static boolean[][] ch;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int answer = -1;
        int ice = 1;
        while (ice == 1) {
            answer++;
            ice = 0;
            ch = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!ch[i][j] && arr[i][j] > 0) {
                        ice++;
                        DFS(i, j);
                    }
                }
            }
        }
        if (ice == 0) answer = 0;
        System.out.println(answer);
    }
    
    static void DFS(int x, int y) {
        ch[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if (!ch[nx][ny]) {
                    if (arr[nx][ny] <= 0) arr[x][y]--;
                    else DFS(nx, ny);
                }
            }
        }
    }
}