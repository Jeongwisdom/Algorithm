import java.io.*;
import java.util.*;

class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        int l = 100;
        int r = 1;
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] < l) l = arr[i][j];
                if (arr[i][j] > r) r = arr[i][j];
            }
        }
        
        int answer = 1;
        boolean[][] ch;
        for (int k = l; k <= r; k++) {
            int count = 0;
            ch = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!ch[i][j] && arr[i][j] > k) {
                        count++;
                        DFS(arr, ch, i, j, n, k);
                    }
                }
            }
            if (answer < count) answer = count;
        }
        System.out.println(answer);
    }
    
    static void DFS(int[][] arr, boolean[][] ch, int x, int y, int n, int mid) {
        ch[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < n && !ch[nx][ny] && arr[nx][ny] > mid) {
                DFS(arr, ch, nx, ny, n, mid);
            }
        }
    }
}