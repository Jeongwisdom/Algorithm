import java.util.*;

class Solution {
    public int solution(String[] board) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length();
        int[] r = {0, 0};
        int[] g = {0, 0};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i].charAt(j) == 'R') r = new int[] {i, j};
                if (board[i].charAt(j) == 'G') g = new int[] {i, j};
            }
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(r);
        boolean[][] ch = new boolean[n][m];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        boolean arrive = false;
        loop:
        while (!q.isEmpty()) {
            answer++;
            Queue<int[]> tmp = new LinkedList<>();
            while (!q.isEmpty()) {
                int[] point = q.poll();
                ch[point[0]][point[1]] = true;
                for (int i = 0; i < 4; i++) {
                    int nx = point[0];
                    int ny = point[1];
                    while (nx + dx[i] >= 0 && nx + dx[i] < n && ny + dy[i] >= 0 && ny + dy[i] < m && board[nx + dx[i]].charAt(ny + dy[i]) != 'D') {
                        nx += dx[i];
                        ny += dy[i];
                    }
                    if (nx == g[0] && ny == g[1]) {
                        arrive = true;
                        break loop;
                    }
                    if (!ch[nx][ny]) tmp.offer(new int[] {nx, ny});
                }
            }
            q = tmp;
        }
        if (!arrive) answer = -1;
        return answer;
    }
}