import java.io.*;
import java.util.*;

class Main {
    static int[] dice = new int[6];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int[] dx = {0, 0, 0, -1, 1};
        int[] dy = {0, 1, -1, 0, 0};
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int c = Integer.parseInt(st.nextToken());
            if (x + dx[c] < 0 || x + dx[c] >= n || y + dy[c] < 0 || y + dy[c] >= m) continue;
            x += dx[c];
            y += dy[c];
            if (c == 1) move(0, 3, 1, 2);
            else if (c == 2) move(0, 2, 1, 3);
            else if (c == 3) move(0, 5, 1, 4);
            else move(0, 4, 1, 5);
            if (arr[x][y] == 0) arr[x][y] = dice[1];
            else {
                dice[1] = arr[x][y];
                arr[x][y] = 0;
            }
            sb.append(dice[0]).append("\n");
        }
        System.out.println(sb);
    }
    
    static void move(int a, int b, int c, int d) {
        int tmp = dice[a];
        dice[a] = dice[b];
        dice[b] = dice[c];
        dice[c] = dice[d];
        dice[d] = tmp;
    }
}