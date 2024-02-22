import java.util.*;

class Solution {
    public int solution(String dirs) {
        Set<String> answer = new HashSet<>();
        char[] command = {'U', 'D', 'R', 'L'};
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int id = 0;
        int x = 0;
        int y = 0;
        int nx, ny;
        StringBuilder xy, n;
        for (char c: dirs.toCharArray()) {
            for (int i = 0; i < command.length; i++) {
                if (c == command[i]) {
                    id = i;
                    break;
                }
            }
            
            nx = x + dx[id];
            ny = y+ dy[id];
            if (nx <= 5 && nx >= -5 && ny <= 5 && ny >= -5) {
                xy = new StringBuilder()
                    .append(x).append(" ").append(y);
                n = new StringBuilder()
                    .append(nx).append(" ").append(ny);
                answer.add(xy.toString() + n.toString());
                answer.add(n.toString() + xy.toString());
                x = nx;
                y = ny;
            }
        }
        
        return answer.size() / 2;
    }
}