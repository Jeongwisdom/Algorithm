import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        Deque<int[]> q = new ArrayDeque<>();
        StringTokenizer st;
        for (int i = 0, id = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[id++] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int[] original = {1, 2, 3, 4, 5, 6, 7, 8, 0};
        Set<String> ch = new HashSet<>();
        q.offer(arr);
        ch.add(Arrays.toString(arr));
        int answer = 0;
        loop:
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int[] tmp = q.poll();
                if (Arrays.toString(tmp).equals(Arrays.toString(original))) {
                    q.offer(new int[] {0});
                    break loop;
                }
                for (int k = 0; k < 9; k++) {
                    if (tmp[k] == 0) {
                        for (int j = 0; j < 4; j++) {
                            int nx = k / 3 + dx[j];
                            int ny = k % 3 + dy[j];
                            int num = nx * 3 + ny;
                            if (nx >= 0 && ny >= 0 && nx < 3 && ny < 3) {
                                int[] t = tmp.clone();
                                int a = t[k];
                                t[k] = t[num];
                                t[num] = a;
                                if (!ch.contains(Arrays.toString(t))) {
                                    q.offer(t);
                                    ch.add(Arrays.toString(t));
                                }
                            }
                        }
                        break;
                    }
                }
            }
            answer++;
        }
        if (q.isEmpty()) answer = -1;
        System.out.println(answer);
    }
}