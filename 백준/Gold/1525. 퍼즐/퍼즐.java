import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[11];
        StringTokenizer st;
        for (int i = 0, id = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++, id++) {
                arr[id] = Integer.parseInt(st.nextToken());
                if (arr[id] == 0) arr[9] = id;
            }
        }
        
        Set<Integer> ch = new HashSet<>();
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(arr);
        int start = parseInt(arr);
        ch.add(start);
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int end = 123456780;
        int answer = -1;
        if (start == end) answer = 0;
        else {
            loop:
            while (!q.isEmpty()) {
                int[] a = q.poll();
                int x = a[9] / 3;
                int y = a[9] % 3;
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx >= 0 && ny >= 0 && nx < 3 && ny < 3) {
                        int num = nx * 3 + ny;
                        int[] b = a.clone();
                        b[b[9]] = b[num];
                        b[num] = 0;
                        int change = parseInt(b);
                        if (!ch.contains(change)) {
                            b[9] = num;
                            b[10]++;
                            q.offer(b);
                            ch.add(change);
                            if (change == end) {
                                answer = b[10];
                                break loop;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
    
    static int parseInt(int[] arr) {
        int c = 0;
        for (int i = 0; i < 9; i++) {
            c = c * 10 + arr[i];
        }
        return c;
    }
}