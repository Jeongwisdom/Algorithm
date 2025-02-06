import java.io.*;
import java.util.*;

class Main {
    static Deque<int[]> q, doors;
    static char[][] arr;
    static boolean[] keys;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        for (int i = 0;i < t; i++) {
            String[] split = br.readLine().split(" ");
            int h = Integer.parseInt(split[0]);
            int w = Integer.parseInt(split[1]);
            q = new ArrayDeque<>();
            doors = new ArrayDeque<>();
            arr = new char[h][w];
            boolean[][] ch = new boolean[h][w];
            keys = new boolean[26];
            int answer = 0;
            for (int j = 0; j < h; j++) {
                String str = br.readLine();
                for (int k = 0; k < w; k++) {
                    arr[j][k] = str.charAt(k);
                    if (j == 0 || k == 0 || j == h - 1 || k == w - 1) {
                        ch[j][k] = true;
                        if (arr[j][k] == '*') continue;
                        if ('A' <= arr[j][k] && arr[j][k] <= 'Z') doors.offer(new int[] {j, k});
                        else {
                            q.offer(new int[] {j, k});
                            if ('a' <= arr[j][k] && arr[j][k] <= 'z') keys[arr[j][k] - 'a'] = true;
                            else if (arr[j][k] == '$') answer++;
                        }
                    }
                }
            }
            String alphabet = br.readLine();
            for (int j = 0; j < alphabet.length(); j++) {
                if (alphabet.charAt(j) == '0') break;
                keys[alphabet.charAt(j) - 'a'] = true;
            }

            while (checkDoors() && !q.isEmpty()) {
                int[] point = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = point[0] + dx[j];
                    int ny = point[1] + dy[j];
                    if (nx >= 0 && nx < h && ny >= 0 && ny < w && !ch[nx][ny]) {
                        ch[nx][ny] = true;
                        if (arr[nx][ny] == '*') continue;
                        if ('A' <= arr[nx][ny] && arr[nx][ny] <= 'Z' && !keys[arr[nx][ny] - 'A']) {
                            doors.offer(new int[] {nx, ny});
                            continue;
                        }
                        q.offer(new int[] {nx, ny});
                        if ('a' <= arr[nx][ny] && arr[nx][ny] <= 'z') keys[arr[nx][ny] - 'a'] = true;
                        else if (arr[nx][ny] == '$') answer++;
                    }
                }
            }
        sb.append(answer).append("\n");
    }
        System.out.println(sb);
    }

    static boolean checkDoors() {
        if (q.isEmpty()) {
            Iterator<int[]> iterator = doors.iterator();
            while (iterator.hasNext()) {
                int[] p = iterator.next();
                if (keys[arr[p[0]][p[1]] - 'A']) {
                    q.offer(new int[] {p[0], p[1]});
                    iterator.remove();
                }
            }
        }
        return true;
    }
}