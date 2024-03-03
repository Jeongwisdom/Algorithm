import java.util.*;

class Solution {
    boolean[][] ch;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int[] solution(String[] maps) {
        Queue<Integer> pq = new PriorityQueue<>();
        ch = new boolean[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[0].length(); j++) {
                if (!ch[i][j] && maps[i].charAt(j) != 'X') {
                    pq.offer(DFS(i, j, maps));
                }
            }
        }
        
        int[] answer = new int[pq.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = pq.poll();
        }
        
        return answer.length == 0? new int[] {-1}: answer;
    }
    
    public int DFS(int x, int y, String[] maps) {
        int sum = maps[x].charAt(y) - '0';
        ch[x][y] = true;
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < maps.length && ny < maps[0].length() && !ch[nx][ny] && maps[nx].charAt(ny) != 'X') {
                sum += DFS(nx, ny, maps);
            }
        }
        
        return sum;
    }
}