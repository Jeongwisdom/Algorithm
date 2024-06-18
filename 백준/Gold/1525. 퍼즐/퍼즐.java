import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder start = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                start.append(st.nextToken());
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        String end = "123456780";
        Deque<String> q = new ArrayDeque<>();
        Map<String, Integer> map = new HashMap<>();
        q.offer(start.toString());
        map.put(start.toString(), 0);
        while (!q.isEmpty()) {
            String tmp = q.poll();
            if (tmp.equals(end)) break;
            int zero = tmp.indexOf('0');
            int x = zero / 3;
            int y = zero % 3;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int num = nx * 3 + ny;
                if (nx >= 0 && ny >= 0 && nx < 3 && ny < 3) {
                    StringBuilder sb = new StringBuilder(tmp);
                    char c = sb.charAt(num);
                    sb.setCharAt(num, '0');
                    sb.setCharAt(zero, c);
                    if (!map.containsKey(sb.toString())) {
                        q.offer(sb.toString());
                        map.put(sb.toString(), map.get(tmp) + 1);
                    }
                }
            }
        }
        System.out.println(map.getOrDefault(end, -1));
    }
}