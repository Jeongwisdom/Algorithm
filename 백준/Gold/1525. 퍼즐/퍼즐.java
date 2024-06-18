import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[10];
        StringTokenizer st;
        for (int i = 0, id = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++, id++) {
                arr[id] = Integer.parseInt(st.nextToken());
                if (arr[id] == 0) arr[9] = id;
            }
        }
        
        Map<Integer, Integer> ch = new HashMap<>();
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(arr);
        ch.put(parseInt(arr), 0);
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int end = 123456780;
        while (!q.isEmpty()) {
            int[] a = q.poll();
            int changeA = parseInt(a);
            if (changeA == end) break;
            int x = a[9] / 3;
            int y = a[9] % 3;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < 3 && ny < 3) {
                    int num = nx * 3 + ny;
                    int[] b = a.clone();
                    int tmp = b[num];
                    b[num] = 0;
                    b[b[9]] = tmp;
                    int change = parseInt(b);
                    if (!ch.containsKey(change)) {
                        b[9] = num;
                        q.offer(b);
                        ch.put(change, ch.get(changeA) + 1);
                    }
                }
            }
        }
        System.out.println(ch.getOrDefault(end, -1));
    }
    
    static int parseInt(int[] arr) {
        int c = 0;
        for (int i = 0; i < 9; i++) {
            c = c * 10 + arr[i];
        }
        return c;
    }
}