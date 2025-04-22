import java.util.*;

class Main {
    static int n, c, nx, ny, cnt;
    static int[][] arr;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = System.in.read() & 15;
            }
            System.in.read();
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) continue;
                list.add(find(i, j));
            }
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");
        for (int num: list) {
            sb.append(num).append("\n");
        }
        System.out.println(sb);
    }

    static int find(int x, int y) {
        arr[x][y] = 0;
        cnt = 1;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= n || arr[nx][ny] == 0) continue;
            cnt += find(nx, ny);
        }
        return cnt;
    }
}