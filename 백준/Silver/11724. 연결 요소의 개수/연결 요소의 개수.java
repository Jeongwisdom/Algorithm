import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] arr = new boolean[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = true;
            arr[b][a] = true;
        }
        for (int i = 1; i <= n; i++) {
            arr[i][i] = true;
        }
        boolean[][] ch = new boolean[n + 1][n + 1];
        Queue<Integer> q = new LinkedList<>();
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] && !ch[i][j]) {
                    answer++;
                    q.offer(i);
                    while (!q.isEmpty()) {
                        int a = q.poll();
                        for (int b = j; b <= n; b++) {
                            if (arr[a][b] && !ch[a][b]) {
                                ch[a][b] = true;
                                ch[b][a] = true;
                                q.offer(b);
                            }
                        }
                    }
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}