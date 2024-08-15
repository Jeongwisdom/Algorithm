import java.io.*;
import java.util.*;

class Main {
    static List<Character>[] list = new ArrayList[6];
    static boolean[][] ch;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = new String[12];
        for (int i = 0; i < 12; i++) {
            arr[i] = br.readLine();
        }
        for (int i = 0; i < 6; i++) list[i] = new ArrayList<>();
        for (int i = 11; i >= 0; i--) {
            for (int j = 0; j < 6; j++) {
                if (arr[i].charAt(j) != '.') {
                    list[j].add(arr[i].charAt(j));
                }
            }
        }

        boolean flag = true;
        int answer = -1;
        while (flag) {
            flag = false;
            answer++;
            ch = new boolean[12][6];
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < list[i].size(); j++) {
                    if (!ch[j][i]) {
                        ch[j][i] = true;
                        if (check(i, j)) {
                            bomb(i, j);
                            list[i].set(j, '.');
                            flag = true;
                        }
                    }
                }
            }
            rebatch();
        }
        System.out.println(answer);
    }

    static boolean check(int x, int y) {
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] check = new boolean[12][6];
        q.offer(new int[] {x, y});
        check[y][x] = true;
        int num = 1;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < 6 && ny < list[nx].size() && !check[ny][nx]) {
                    check[ny][nx] = true;
                    if (list[nx].get(ny) == list[x].get(y)) {
                        num++;
                        q.offer(new int[] {nx, ny});
                    }
                }
                if (num >= 4) return true;
            }
        }
        return false;
    }

    static void bomb(int x, int y) {
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {x, y});
        while (!q.isEmpty()) {
            int[] p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < 6 && ny < list[nx].size() && !ch[ny][nx] && list[nx].get(ny) == list[x].get(y)) {
                    ch[ny][nx] = true;
                    list[nx].set(ny, '.');
                    q.offer(new int[] {nx, ny});
                }
            }
        }
    }

    static void rebatch() {
        for (int i = 0; i < 6; i++) {
            list[i].removeAll(List.of('.'));
        }
    }
}