import java.io.*;
import java.util.*;

class Main {
    static int r, c, k, answer = 0;
    static String[] arr;
    static boolean[][] ch;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        r = Integer.parseInt(split[0]);
        c = Integer.parseInt(split[1]);
        k = Integer.parseInt(split[2]);
        arr = new String[r];
        for (int i = 0; i < r; i++) arr[i] = br.readLine();
        
        ch = new boolean[r][c];
        ch[r - 1][0] = true;
        DFS(r - 1, 0, 1);
        System.out.println(answer);
    }
    
    static void DFS(int x, int y, int dist) {
        if (dist == k) {
            if (x == 0 && y == c - 1) answer++;
        } else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < r && ny >= 0 && ny < c && !ch[nx][ny] && arr[nx].charAt(ny) == '.') {
                    ch[nx][ny] = true;
                    DFS(nx, ny, dist + 1);
                    ch[nx][ny] = false;
                }
            }
        }
    }
}