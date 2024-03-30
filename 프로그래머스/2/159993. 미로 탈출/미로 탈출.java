import java.util.*;

class Solution {
    public int solution(String[] maps) {
        int[] s = new int[2];
        int[] e = new int[2];
        int[] l = new int[2];
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                if (maps[i].charAt(j) == 'S') s = new int[] {i, j};
                if (maps[i].charAt(j) == 'E') e = new int[] {i, j};
                if (maps[i].charAt(j) == 'L') l = new int[] {i, j};
            }
        }
        
        int a = find(maps, s, l);
        int b = find(maps, l, e);
        return a == Integer.MAX_VALUE || b == Integer.MAX_VALUE? -1: a + b;
    }
    
    public int find(String[] maps, int[] s, int[] e) {
        int[][] arr = new int[maps.length][maps[0].length()];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = Integer.MAX_VALUE;
            }
        }
        
        arr[s[0]][s[1]] = 0;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {s[0], s[1]});
        while (!q.isEmpty() && (q.peek()[0] != e[0] || q.peek()[1] != e[1])) {
            int[] point = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = point[0] + dx[i];
                int ny = point[1] + dy[i];
                if (nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length()) {
                    if (arr[nx][ny] == Integer.MAX_VALUE && maps[nx].charAt(ny) != 'X') {
                        arr[nx][ny] = arr[point[0]][point[1]] + 1;
                        q.offer(new int[] {nx, ny});
                    }
                }
            }
        }
        
        return arr[e[0]][e[1]];
    }
}