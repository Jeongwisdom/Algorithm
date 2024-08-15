import java.io.*;
import java.util.*;

class Main {
    static String[] arr = new String[5];
    static boolean[][] ch = new boolean[5][5];
    static Set<String> set = new HashSet<>();
    static TreeSet<int[]> princess = new TreeSet<>((s1, s2) -> {
        if (s1[0] == s2[0]) {
            return s1[1] - s2[1];
        }
        return s1[0] - s2[0];
    });
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) arr[i] = br.readLine();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                ch[i][j] = true;
                int[] p = new int[] {i, j};
                princess.add(p);
                if (arr[i].charAt(j) == 'S') DFS(1, 1);
                else DFS(1, 0);
                ch[i][j] = false;
                princess.remove(p);
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
        for (int[] p: new HashSet<>(princess)) {
            for (int j = 0; j < 4; j++) {
                int nx = p[0] + dx[j];
                int ny = p[1] + dy[j];
                if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5 && !ch[nx][ny]) {
                    ch[nx][ny] = true;
                    princess.add(new int[] {nx, ny});
                    String str = makeString();
                    if (!set.contains(str)) {
                        set.add(str);
                        if (arr[nx].charAt(ny) == 'S') DFS(cnt + 1, numOfS + 1);
                        else DFS(cnt + 1, numOfS);
                    }
                    ch[nx][ny] = false;
                    princess.removeIf(point -> point[0] == nx && point[1] == ny);
                }
            }
        }
    }

    static String makeString() {
        StringBuilder sb = new StringBuilder();
        for (int[] p: princess) {
            sb.append(p[0]).append(p[1]);
        }
        return sb.toString();
    }
}