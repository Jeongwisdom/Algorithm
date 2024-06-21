import java.io.*;
import java.util.*;

class Main {
    static int r, c;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        r = Integer.parseInt(split[0]);
        c = Integer.parseInt(split[1]);
        char[][] arr = new char[r][c];
        Deque<int[]> q = new ArrayDeque<>();
        String s;
        int[] l = {0, 0};
        for (int i = 0; i < r; i++) {
            s = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = s.charAt(j);
                if (arr[i][j] != 'X') q.offer(new int[] {i, j});
                if (arr[i][j] == 'L') l = new int[] {i, j};
            }
        }

        Deque<int[]> swan = new ArrayDeque<>();
        boolean[][] chSwan = new boolean[r][c];
        swan.offer(l);
        chSwan[l[0]][l[1]] = true;
        int answer = 0;
        while (!q.isEmpty()) {
            if (meet(arr, swan, chSwan)) break;
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int[] p = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = p[0] + dx[j];
                    int ny = p[1] + dy[j];
                    if (nx >= 0 && ny >= 0 && nx < r && ny < c && arr[nx][ny] == 'X') {
                        arr[nx][ny] = '.';
                        q.offer(new int[] {nx, ny});
                    }
                }
            }
            answer++;
        }
        System.out.println(answer);
    }

    static boolean meet(char[][] arr, Deque<int[]> q, boolean[][] ch) {
        Deque<int[]> next = new ArrayDeque<>();
        while (!q.isEmpty()) {
            int[] p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < r && ny < c && !ch[nx][ny]) {
                    ch[nx][ny] = true;
                    if (arr[nx][ny] == '.') q.offer(new int[] {nx, ny});
                    else if (arr[nx][ny] == 'X') next.offer(new int[] {nx, ny});
                    else return true;
                }
            }
        }
        q.addAll(next);
        return false;
    }
}