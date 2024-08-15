import java.io.*;
import java.util.*;

class Main {
    static String[] arr = new String[5];
    static boolean[][] ch = new boolean[5][5];
    static Set<String> set = new HashSet<>();
    static int[][] princess = new int[7][2];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 2; j++) {
                princess[i][j] = -1;
            }
        }
        for (int i = 0; i < 5; i++) arr[i] = br.readLine();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                ch[i][j] = true;
                princess[0][0] = i;
                princess[0][1] = j;
                if (arr[i].charAt(j) == 'S') DFS(1, 1);
                else DFS(1, 0);
                ch[i][j] = false;
            }
        }
        System.out.println(answer);
    }

    static void DFS(int cnt, int numOfS) {
        if (7 - cnt + numOfS < 4) return;
        if (cnt == 7) {
            answer++;
            return;
        }
        for (int i = 0; i <= cnt; i++) {
            for (int j = 0; j < 4; j++) {
                int nx = princess[i][0] + dx[j];
                int ny = princess[i][1] + dy[j];
                if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5 && !ch[nx][ny]) {
                    ch[nx][ny] = true;
                    princess[cnt][0] = nx;
                    princess[cnt][1] = ny;
                    String str = makeString(nx, ny);
                    if (!set.contains(str)) {
                        set.add(str);
                        if (arr[nx].charAt(ny) == 'S') DFS(cnt + 1, numOfS + 1);
                        else DFS(cnt + 1, numOfS);
                    }
                    ch[nx][ny] = false;
                    princess[cnt][0] = -1;
                    princess[cnt][1] = -1;
                }
            }
        }
    }

    static String makeString(int x, int y) {
        int[][] sort = new int[7][2];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 2; j++) {
                sort[i][j] = princess[i][j];
            }
        }
        sort[6][0] = x;
        sort[6][1] = y;
        Arrays.sort(sort, (s1, s2) -> {
            if (s1[0] == s2[0]) {
                return s1[1] - s2[1];
            }
            return s1[0] - s2[0];
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 2; j++) {
                sb.append(sort[i][j]);
            }
        }
        return sb.toString();
    }
}