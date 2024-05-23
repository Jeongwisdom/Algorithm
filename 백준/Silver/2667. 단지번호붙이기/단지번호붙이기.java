import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
        List<Integer> l = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        boolean[][] ch = new boolean[n][n];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i].charAt(j) == '1' && !ch[i][j]) {
                    ch[i][j] = true;
                    q.offer(new int[] {i, j});
                    int area = 0;
                    while (!q.isEmpty()) {
                        area++;
                        int[] point = q.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = point[0] + dx[k];
                            int ny = point[1] + dy[k];
                            if (nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx].charAt(ny) == '1' && !ch[nx][ny]) {
                                ch[nx][ny] = true;
                                q.offer(new int[] {nx, ny});
                            }
                        }
                    }
                    l.add(area);
                }
            }
        }
        Collections.sort(l);
        StringBuilder sb = new StringBuilder();
        sb.append(l.size()).append("\n");
        for (int i: l) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}