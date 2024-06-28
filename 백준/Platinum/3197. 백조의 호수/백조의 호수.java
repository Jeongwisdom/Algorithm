import java.io.*;
import java.util.*;

class Main {
    static int r, c;
    static char[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        r = Integer.parseInt(split[0]);
        c = Integer.parseInt(split[1]);
        arr = new char[r][c];
        Deque<int[]> q = new ArrayDeque<>();
        Deque<int[]> swan = new ArrayDeque<>();
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = str.charAt(j);
                if (arr[i][j] != 'X') q.offer(new int[] {i, j});
                if (arr[i][j] == 'L') swan.offer(new int[] {i, j});
            }
        }
        
        boolean[][] ch = new boolean[r][c];
        int[] end = swan.poll();
        int answer = 0;
        while (!q.isEmpty()) {
            swan = meet(swan, ch);
            if (ch[end[0]][end[1]]) break;
            q = watered(q);
            answer++;
        }
        System.out.println(answer);
    }
    
    static Deque<int[]> meet(Deque<int[]> swan, boolean[][] ch) {
        Deque<int[]> next = new ArrayDeque<>();
        while (!swan.isEmpty()) {
            int[] p = swan.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < r && ny < c && !ch[nx][ny]) {
                    ch[nx][ny] = true;
                    if (arr[nx][ny] != 'X') swan.offer(new int[] {nx, ny});
                    else next.offer(new int[] {nx, ny});
                }
            }
        }
        return next;
    }
    
    static Deque<int[]> watered(Deque<int[]> q) {
        Deque<int[]> next = new ArrayDeque<>();
        while (!q.isEmpty()) {
            int[] p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < r && ny < c && arr[nx][ny] == 'X') {
                    arr[nx][ny] = '.';
                    next.offer(new int[] {nx, ny});
                }
            }
        }
        return next;
    }
}