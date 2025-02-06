import java.io.*;
import java.util.*;

class Main {
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
            Deque<int[]> q = new ArrayDeque<>();
            Deque<int[]> doors = new ArrayDeque<>();
            char[][] arr = new char[h][w];
            boolean[][] ch = new boolean[h][w];
            boolean[] keys = new boolean[26];
            int answer = 0;
            for (int j = 0; j < h; j++) {
                String str = br.readLine();
                for (int k = 0; k < w; k++) {
                    arr[j][k] = str.charAt(k);
                    if (j == 0 || k == 0 || j == h - 1 || k == w - 1) {
                        ch[j][k] = true;
                        if (arr[j][k] == '*') continue;
                        q.offer(new int[] {j, k});
                    }
                }
            }
            String alphabet = br.readLine();
            for (int j = 0; j < alphabet.length(); j++) {
                if (alphabet.charAt(j) == '0') break;
                keys[alphabet.charAt(j) - 'a'] = true;
            }

            while (!q.isEmpty()) {
                int[] point = q.poll();
                char c = arr[point[0]][point[1]];
                if ('A' <= c && c <= 'Z' && !keys[c - 'A']) {
                    doors.offer(new int[] {point[0], point[1]});
                } else {
                    if ('a' <= c && c <= 'z') {
                        keys[c - 'a'] = true;
                    } else if (c == '$') answer++;

                    for (int j = 0; j < 4; j++) {
                        int nx = point[0] + dx[j];
                        int ny = point[1] + dy[j];
                        if (nx >= 0 && nx < h && ny >= 0 && ny < w && !ch[nx][ny]) {
                            ch[nx][ny] = true;
                            if (arr[nx][ny] == '*') continue;
                            q.offer(new int[] {nx, ny});
                        }
                    }
                }

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
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}