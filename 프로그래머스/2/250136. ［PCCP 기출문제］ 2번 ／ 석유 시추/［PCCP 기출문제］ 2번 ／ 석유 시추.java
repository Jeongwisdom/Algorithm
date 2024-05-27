import java.util.*;

class Solution {
    public int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        boolean[][] ch = new boolean[n][m];
        int id = 2;
        int[] areas = new int[250000];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && !ch[i][j]) {
                    ch[i][j] = true;
                    q.offer(new int[] {i, j});
                    int area = 0;
                    while (!q.isEmpty()) {
                        int[] point = q.poll();
                        land[point[0]][point[1]] = id;
                        area++;
                        Set<Integer> set = map.getOrDefault(point[1], new HashSet<>());
                        set.add(id);
                        map.put(point[1], set);
                        for (int k = 0; k < 4; k++) {
                            int nx = point[0] + dx[k];
                            int ny = point[1] + dy[k];
                            if (nx >= 0 && ny >= 0 && nx < n && ny < m && land[nx][ny] == 1 && !ch[nx][ny]) {
                                ch[nx][ny] = true;
                                q.offer(new int[] {nx, ny});
                            }
                        }
                    }
                    areas[id++] = area;
                }
            }
        }
        
        int answer = 0;
        for (int i = 0; i < m; i++) {
            int area = 0;
            for (int num: map.getOrDefault(i, new HashSet<>())) {
                area += areas[num];
            }
            if (answer < area) answer = area;
        }
        return answer;
    }
}