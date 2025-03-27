import java.util.*;

class Main {
    static int n, m;
    static int[][] arr;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static int read() throws Exception {
        int r, c = System.in.read() & 15;
        while ((r = System.in.read()) > 47) c = (c << 3) + (c << 1) + (r & 15);
        return c;
    }

    public static void main(String[] args) throws Exception {
        m = read();
        n = read();
        int k = read();
        arr = new int[n][m];
        while (k-- > 0) {
            int x1 = read(), y1 = read(), x2 = read() , y2 = read();
            for (int i = x1; i < x2; i++) {
                for (int j = y1; j < y2; j++) {
                    arr[i][j] = 1;
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) continue;
                arr[i][j] = 1;
                list.add(DFS(i, j));
            }
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");
        for (int num: list) {
            sb.append(num).append(' ');
        }
        System.out.println(sb);
    }

    static int DFS(int x, int y) {
        int cnt = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if (arr[nx][ny] == 1) continue;
            arr[nx][ny] = 1;
            cnt += DFS(nx, ny);
        }
        return cnt;
    }
}