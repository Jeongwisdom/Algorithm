import java.util.*;

class Solution {
    public int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        int id = 2;
        int[] areas = new int[250000];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<int[]> q = new ArrayDeque<>();
        int answer = 0;
        for (int j = 0; j < m; j++) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (land[i][j] == 1) {
                    q.offer(new int[] {i, j});
                    land[i][j] = id;
                    int area = 0;
                    while (!q.isEmpty()) {
                        int[] point = q.poll();
                        area++;
                        for (int k = 0; k < 4; k++) {
                            int nx = point[0] + dx[k];
                            int ny = point[1] + dy[k];
                            if (nx >= 0 && ny >= 0 && nx < n && ny < m && land[nx][ny] == 1) {
                                land[nx][ny] = id;
                                q.offer(new int[] {nx, ny});
                            }
                        }
                    }
                    set.add(id);
                    areas[id++] = area;
                } else set.add(land[i][j]);
            }
            int c = 0;
            for (int num: set) {
                c += areas[num];
            }
            if (answer < c) answer = c;
        }
        
        return answer;
    }
}