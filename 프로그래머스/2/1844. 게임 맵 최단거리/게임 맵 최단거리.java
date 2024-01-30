import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] ch = new boolean[n][m];
        ch[0][0] = true;
        Queue<Integer[]> queue = new ArrayDeque<>();
        queue.offer(new Integer[] {0, 0});
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        Integer[] point;
        int nx, ny;
        int l = 0;
        while (!queue.isEmpty()) {
            l++;
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                point = queue.poll();
                for (int j = 0; j < dx.length; j++) {
                    nx = point[0] + dx[j];
                    ny = point[1] + dy[j];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < m && maps[nx][ny] == 1 && !ch[nx][ny]) {
                        if (nx == n - 1 && ny == m - 1) return l + 1;
                        ch[nx][ny] = true;
                        queue.offer(new Integer[] {nx, ny});
                    }
                }
            }
        }
        
        return -1;
    }
}